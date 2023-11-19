package application.model.entity;

import application.model.util.EstadoReclamo;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "reclamos_localizados")
@DiscriminatorValue("localizado")
public class Localizado extends Reclamo {
    @ManyToOne
    private Unidad unidad;

    public Localizado() {
    }

    public Localizado(String descripcion, List<foto> fotos, Usuario usuario, Unidad unidad) {
        super(descripcion, fotos, usuario);
        this.unidad = unidad;
    }

    public Localizado(String descripcion, List<foto> fotos, EstadoReclamo estadoReclamo, List<Log> historial) {
        super(descripcion, fotos, estadoReclamo, historial);
    }

    public Localizado(EstadoReclamo estadoReclamo) {
        super(estadoReclamo);
    }

    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }
}
