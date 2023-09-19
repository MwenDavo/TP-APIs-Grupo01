package app.model.entity;

import app.util.EstadoReclamo;
import jakarta.persistence.*;

@Entity
@Table(name = "logs")
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private long fechaHora = System.currentTimeMillis();;
    @Column(nullable = false)
    private EstadoReclamo estadoReclamo;
    @Column(nullable = false)
    private String descripcion;
    @ManyToOne
    private Reclamo reclamo;

    public Log() {

    }

    public Log(EstadoReclamo estadoReclamo, String descripcion, Reclamo reclamo) {
        this.estadoReclamo = estadoReclamo;
        this.descripcion = descripcion;
        this.reclamo = reclamo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(long fechaHora) {
        this.fechaHora = fechaHora;
    }

    public EstadoReclamo getEstadoReclamo() {
        return estadoReclamo;
    }

    public void setEstadoReclamo(EstadoReclamo estadoReclamo) {
        this.estadoReclamo = estadoReclamo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Reclamo getReclamo() {
        return reclamo;
    }

    public void setReclamo(Reclamo reclamo) {
        this.reclamo = reclamo;
    }
}
