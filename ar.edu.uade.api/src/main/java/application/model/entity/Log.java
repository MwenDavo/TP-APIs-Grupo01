package application.model.entity;

import application.model.util.EstadoReclamo;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "logs")
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_hora")
    private Date fechaHora = new Date(System.currentTimeMillis());
    @Column(nullable = false, name = "estado_reclamo")
    private EstadoReclamo estadoReclamo;
    @Column(nullable = false)
    private String descripcion;
    @ManyToOne
    private Reclamo reclamo;

    public Log() {
    }

    public Log(Date fechaHora, EstadoReclamo estadoReclamo, String descripcion, Reclamo reclamo) {
        this.fechaHora = fechaHora;
        this.estadoReclamo = estadoReclamo;
        this.descripcion = descripcion;
        this.reclamo = reclamo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
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
