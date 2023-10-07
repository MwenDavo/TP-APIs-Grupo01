package application.model.entity;

import application.model.entity.dto.EdificioDTO;
import application.model.entity.dto.FotoDTO;
import application.model.entity.dto.LogDTO;
import application.model.util.EstadoReclamo;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "reclamos_generales")
@DiscriminatorValue("general")
public class General extends Reclamo {
    @ManyToOne
    private Edificio edificio;

    public General() {
    }

    public General(String descripcion, List<Foto> fotos, Usuario usuario, Edificio edificio) {
        super(descripcion, fotos, usuario);
        this.edificio = edificio;
    }

    public General(String descripcion, List<Foto> fotos, EstadoReclamo estadoReclamo, List<Log> historial) {
        super(descripcion, fotos, estadoReclamo, historial);
    }

    public General(EstadoReclamo estadoReclamo) {
        super(estadoReclamo);
    }

    public Edificio getEdificio() {
        return edificio;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }
}
