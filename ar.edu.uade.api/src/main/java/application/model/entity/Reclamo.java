package application.model.entity;

import application.model.util.EstadoReclamo;
import jakarta.persistence.*;
import org.springframework.web.multipart.MultipartFile;

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
    private MultipartFile[] fotos;
    @ManyToOne
    private Usuario usuario;
    @Column(name = "estado_reclamo")
    private EstadoReclamo estadoReclamo = EstadoReclamo.NUEVO;
    @OneToMany(mappedBy = "reclamo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Log> historial = new ArrayList<>();

    public Reclamo() {
    }

    public Reclamo(String descripcion, MultipartFile[] fotos, Usuario usuario) {
        this.descripcion = descripcion;
        this.fotos = fotos;
        this.usuario = usuario;
    }

    public Reclamo(String descripcion, MultipartFile[] fotos, EstadoReclamo estadoReclamo, List<Log> historial) {
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

    public MultipartFile[] getFotos() {
        return fotos;
    }

    public void setFotos(MultipartFile[] fotos) {
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
