package application.model.entity;

import application.model.entity.dto.FotoDTO;
import application.model.entity.dto.LogDTO;
import application.model.util.EstadoReclamo;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_reclamo", discriminatorType = DiscriminatorType.STRING)
public class Reclamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 144)
    private String descripcion;
    @OneToMany(mappedBy = "reclamo")
    private List<Foto> fotos;
    @ManyToOne
    private Usuario usuario;
    @Column(name = "estado_reclamo")
    private EstadoReclamo estadoReclamo;
    @OneToMany(mappedBy = "reclamo", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Log> historial;

    public Reclamo() {
    }

    public Reclamo(String descripcion, List<Foto> fotos, Usuario usuario) {
        this.descripcion = descripcion;
        this.fotos = fotos;
        this.usuario = usuario;
    }

    public Reclamo(String descripcion, List<Foto> fotos, EstadoReclamo estadoReclamo, List<Log> historial) {
        this.descripcion = descripcion;
        this.fotos = fotos;
        this.estadoReclamo = estadoReclamo;
        this.historial = historial;
    }

    public Reclamo(EstadoReclamo estadoReclamo) {
        this.estadoReclamo = estadoReclamo;
    }

    public Reclamo(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public EstadoReclamo getEstadoReclamo() {
        return estadoReclamo;
    }

    public void setEstadoReclamo(EstadoReclamo estadoReclamo) {
        this.estadoReclamo = estadoReclamo;
    }

    public List<Log> getHistorial() {
        return historial;
    }

    public void setHistorial(List<Log> historial) {
        this.historial = historial;
    }
}
