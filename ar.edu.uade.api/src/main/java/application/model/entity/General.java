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

    public General(String descripcion, List<Foto> Fotos, Usuario usuario, Edificio edificio) {
        super(descripcion, Fotos, usuario);
        this.edificio = edificio;
    }

    public General(String descripcion, List<Foto> Fotos, EstadoReclamo estadoReclamo, List<Log> historial) {
        super(descripcion, Fotos, estadoReclamo, historial);
    }

    public General(EstadoReclamo estadoReclamo) {
        super(estadoReclamo);
    }

    public General(String descripcion, MultipartFile[] fotos, String username, String s) {
    }

    public General(String descripcion, Usuario usuario, Edificio edificio) {
        super(descripcion,usuario);
        this.edificio = edificio;
    }

    public Edificio getEdificio() {
        return edificio;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }
}
