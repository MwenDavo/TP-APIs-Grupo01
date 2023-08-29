package app.model.entity;

import app.util.EstadoReclamo;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "reclamos")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipoReclamo", discriminatorType = DiscriminatorType.STRING)
public abstract class Reclamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descripcion;
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<Foto> fotos;
    @ManyToOne
    private Usuario usuario;
    private EstadoReclamo estado;

    public Reclamo() {

    }

    public Reclamo(String descripcion, List<Foto> fotos, Usuario usuario, EstadoReclamo estado) {
        this.descripcion = descripcion;
        this.fotos = fotos;
        this.usuario = usuario;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Foto> getFotos() {
        return fotos;
    }

    public void setFotos(List<Foto> fotos) {
        this.fotos = fotos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public EstadoReclamo getEstado() {
        return estado;
    }

    public void setEstado(EstadoReclamo estado) {
        this.estado = estado;
    }
}
