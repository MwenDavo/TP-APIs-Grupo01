package app.model.entity;

import javax.persistence.*;
import java.sql.Timestamp;
@Entity
@Table(name = "log_estado_reclamo")
public class LogEstadoReclamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private long fechaHora; //En vez de guardar la fecha hora en si, se guarda un long de numeros que representan el tiempo entre el 1ro de enero del 70 y el momento actual (mas facil que guardar una clase de timestamp)
    private String estado;
    private String descripcion;
    @ManyToOne
    private Reclamo reclamo;

    public LogEstadoReclamo(Reclamo reclamo, long fechaHora, String estado, String descripcion) {
        this.reclamo = reclamo;
        this.fechaHora = fechaHora;
        this.estado = estado;
        this.descripcion = descripcion;
    }

    public Reclamo getReclamo() {
        return reclamo;
    }

    public void setReclamo(Reclamo reclamo) {
        this.reclamo = reclamo;
    }

    public long getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(long fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
