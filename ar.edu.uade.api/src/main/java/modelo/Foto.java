package modelo;

import javax.persistence.*;
import java.util.List;
@Entity
public class Foto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreFoto;
    @Lob
    private Byte[] bits;
}
