package application.model.entity;

import application.model.util.EstadoReclamo;
import jakarta.persistence.*;
import org.springframework.security.core.parameters.P;

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
    @OneToMany(mappedBy = "reclamo", cascade = CascadeType.ALL)
    private List<Foto> Fotos;
    @ManyToOne
    private Usuario usuario;
    @Column(name = "estado_reclamo")
    private EstadoReclamo estadoReclamo = EstadoReclamo.NUEVO;
    @OneToMany(mappedBy = "reclamo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Log> historial = new ArrayList<>();

    public Reclamo() {
    }

    public Reclamo(String descripcion, Usuario usuario){
        this.descripcion = descripcion;
        this.usuario = usuario;
    }

    public Reclamo(String descripcion, List<Foto> Fotos, Usuario usuario) {
        this.descripcion = descripcion;
        //this.Fotos = Fotos;
        this.usuario = usuario;
    }

    public Reclamo(String descripcion , List<Foto> Fotos, EstadoReclamo estadoReclamo, List<Log> historial) {
        this.descripcion = descripcion;
        this.Fotos = Fotos;
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
        return Fotos;
    }

    public void setFotos(List<Foto> Fotos) {
        this.Fotos = Fotos;
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
