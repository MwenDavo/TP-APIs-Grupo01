package application.model.entity.dto;

import application.model.entity.Reclamo;
import jakarta.persistence.*;

@Entity
@Table(name = "fotos")
public class fotoDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] data;
    @ManyToOne
    private Reclamo reclamo;
    public fotoDTO(){}
    public fotoDTO(byte[] data) {
        this.data = data;
    }
    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public Reclamo getReclamo() {
        return reclamo;
    }

    public void setReclamo(Reclamo reclamo) {
        this.reclamo = reclamo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
