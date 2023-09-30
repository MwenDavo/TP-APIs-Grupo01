package application.model.entity;

import application.model.util.EstadoReclamo;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "localizados")
@DiscriminatorValue("localizado")
public class Localizado extends Reclamo {
    @ManyToOne
    private Unidad unidad;

    public Localizado(Reclamo r) {
        super(
                r.getDescripcion(),
                r.getFotos(),
                r.getUsuario(),
                r.getEstadoReclamo(),
                r.getHistorial()
        );
    }

    public Localizado(String descripcion, List<Foto> fotos, Usuario usuario, EstadoReclamo estadoReclamo, List<Log> historial) {
        super(descripcion, fotos, usuario, estadoReclamo, historial);
    }

    public Localizado(Unidad unidad) {
        this.unidad = unidad;
    }

    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }
}
