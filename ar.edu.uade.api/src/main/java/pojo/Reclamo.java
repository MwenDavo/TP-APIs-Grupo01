package pojo;

import pojo.estadosreclamo.EstadoReclamo;
import pojo.estrategiareclamo.ITipo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

public class Reclamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Edificio edificio;
    private String descripcion;
    private List<Foto> fotos;
    private Usuario usuario;
    private EstadoReclamo estado;
    private ITipo estrategia;
    public List<String> historial;

    public EstadoReclamo getEstado() {
        return estado;
    }
    public void setEstado(EstadoReclamo estado) {
        this.estado = estado;
    }
}
