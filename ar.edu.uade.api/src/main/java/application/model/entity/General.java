package application.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "generales")
@DiscriminatorValue("general")
public class General extends Reclamo {
    @ManyToOne
    private Edificio edificio;

    public General(Reclamo r) {
        super(
                r.getDescripcion(),
                r.getFotos(),
                r.getUsuario(),
                r.getEstadoReclamo(),
                r.getHistorial()
        );
    }

    public General(Edificio edificio) {
        this.edificio = edificio;
    }

    public Edificio getEdificio() {
        return edificio;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }
}
