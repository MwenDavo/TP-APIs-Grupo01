package application.model.entity;

import application.model.util.EstadoReclamo;
import jakarta.persistence.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Entity
@Table(name = "reclamos_generales")
@DiscriminatorValue("general")
public class General extends Reclamo {
    @ManyToOne
    private Edificio edificio;

    public General() {
    }

    public General(String descripcion, List<foto> fotos, Usuario usuario, Edificio edificio) {
        super(descripcion, fotos, usuario);
        this.edificio = edificio;
    }

    public General(String descripcion, List<foto> fotos, EstadoReclamo estadoReclamo, List<Log> historial) {
        super(descripcion, fotos, estadoReclamo, historial);
    }

    public General(EstadoReclamo estadoReclamo) {
        super(estadoReclamo);
    }

    public General(String descripcion, MultipartFile[] fotos, String username, String s) {
    }

    public Edificio getEdificio() {
        return edificio;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }
}
