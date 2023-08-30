package app.model.entity;

import app.util.EstadoReclamo;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "localizados")
@DiscriminatorValue("localizado")
public class Localizado extends Reclamo {
    @ManyToOne
    private Unidad unidad;

    public Localizado() {
        super();
    }

    public Localizado(String descripcion, List<Foto> fotos, Usuario usuario, EstadoReclamo estado, Unidad unidad) {
        super(descripcion, fotos, usuario, estado);
        this.unidad = unidad;
    }

    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }
}
