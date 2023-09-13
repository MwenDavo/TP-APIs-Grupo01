package app.model.entity;

import app.util.EstadoReclamo;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "generales")
@DiscriminatorValue("general")
public class General extends Reclamo {
    @ManyToOne
    private Edificio edificio;

    public General() {
        super();
    }

    public General(String descripcion, List<Foto> fotos, Usuario usuario, Edificio edificio) {
        super(descripcion, fotos, usuario);
        this.edificio = edificio;
    }

    public Edificio getEdificio() {
        return edificio;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
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

        General that = (General) object;

        return that.getId() == this.getId() &&
                that.getDescripcion() == this.getDescripcion() &&
                that.getFotos() == this.getFotos() &&
                that.getUsuario() == this.getUsuario() &&
                that.getEstado() == this.getEstado() &&
                that.getHistorial() == getHistorial() &&
                that.getEdificio() == this.getEdificio();
    }
}
