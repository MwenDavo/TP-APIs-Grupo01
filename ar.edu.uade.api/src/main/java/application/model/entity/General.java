package application.model.entity;

import application.model.util.EstadoReclamo;
import jakarta.persistence.*;

import java.util.List;

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

    public General(String descripcion, List<Foto> fotos, Usuario usuario, EstadoReclamo estadoReclamo, List<Log> historial) {
        super(descripcion, fotos, usuario, estadoReclamo, historial);
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
