package pojo;

import util.estadosreclamo.EstadoReclamo;
import util.estrategiareclamo.ITipo;

import javax.persistence.*;
import java.util.List;

@Entity
public abstract class Reclamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne //TODO en la clase padre se vuelve redundante cuando se agrega la unidad que ya tiene el edificio
    private Edificio edificio;
    private String descripcion;
    @Embedded
    private List<Foto> fotos;
    @ManyToOne
    private Usuario usuario;
    @Embedded
    private EstadoReclamo estado;
    private ITipo estrategia;/*TODO propongo mejor hacer una herencia porque el comportamiento con el que se va a manejar un Reclamo
     no va a cambiar en ejecución (Strategy) sino que será el mismo (herencia)*/
    public List<String> historial;

    public Reclamo() {

    }
}
