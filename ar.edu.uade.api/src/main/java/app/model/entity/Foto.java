package app.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "fotos")
public class Foto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Lob
    private Byte[] bits;

    public Foto() {

    }

    public Foto(Byte[] bits) {
        this.bits = bits;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Byte[] getBits() {
        return bits;
    }

    public void setBits(Byte[] bits) {
        this.bits = bits;
    }
}
