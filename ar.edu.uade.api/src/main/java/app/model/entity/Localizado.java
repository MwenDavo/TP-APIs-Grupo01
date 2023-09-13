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

    public Localizado(String descripcion, List<Foto> fotos, Usuario usuario, Unidad unidad) {
        super(descripcion, fotos, usuario);
        this.unidad = unidad;
    }

    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }

    @Override
    public boolean equals(Object object) {

        if (object == null) {
            return false;
        }

        if (object == this) {
            return true;
        }

        if (object.getClass() != this.getClass()) {
            return false;
        }

        Localizado that = (Localizado) object;

        return that.getId() == this.getId() &&
                that.getDescripcion() == this.getDescripcion() &&
                that.getFotos() == this.getFotos() &&
                that.getUsuario() == this.getUsuario() &&
                that.getEstado() == this.getEstado() &&
                that.getHistorial() == getHistorial() &&
                that.getUnidad() == this.getUnidad();
    }
}
