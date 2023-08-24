package pojo;

import util.estadosreclamo.EstadoReclamo;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipoReclamo", discriminatorType = DiscriminatorType.STRING)
public abstract class Reclamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descripcion;
    @OneToMany(mappedBy = "id")
    private List<Foto> fotos;
    @ManyToOne
    private Usuario usuario;
    @Embedded
    private EstadoReclamo estado;

    public Reclamo() {

    }

}
