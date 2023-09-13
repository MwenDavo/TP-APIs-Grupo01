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
    @Column(nullable = false)
    private String descripcion;
    @OneToMany(mappedBy = "id", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Foto> fotos;
    @ManyToOne
    private Usuario usuario;
    @Column(nullable = false)
    private EstadoReclamo estado = EstadoReclamo.NUEVO;
    @OneToMany(mappedBy = "reclamo", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Log> historial;

    public Reclamo() {

    }

    public Reclamo(String descripcion, List<Foto> fotos, Usuario usuario) {
        this.descripcion = descripcion;
        this.fotos = fotos;
        this.usuario = usuario;
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

    public List<Log> getHistorial() {
        return historial;
    }

    public void setHistorial(List<Log> historial) {
        this.historial = historial;
    }
}
