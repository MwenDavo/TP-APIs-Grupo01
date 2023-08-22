package pojo;

import javax.persistence.*;

@Entity
public class Foto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreFoto;
    @Lob
    private Byte[] bits;
}
