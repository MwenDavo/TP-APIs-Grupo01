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

    public General(String descripcion, List<Foto> fotos, Usuario usuario, EstadoReclamo estado, Edificio edificio) {
        super(descripcion, fotos, usuario, estado);
        this.edificio = edificio;
    }

    public Edificio getEdificio() {
        return edificio;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }
}
