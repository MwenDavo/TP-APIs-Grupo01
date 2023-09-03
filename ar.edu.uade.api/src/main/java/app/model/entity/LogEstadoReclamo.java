package app.model.entity;

import java.sql.Timestamp;

public class LogEstadoReclamo {
    private int idReclamo;
    private long fechaHora; //En vez de guardar la fecha hora en si, se guarda un long de numeros que representan el tiempo entre el 1ro de enero del 70 y el momento actual (mas facil que guardar una clase de timestamp)
    private String estado;
    private String descripcion;

    public LogEstadoReclamo(int idReclamo, long fechaHora, String estado, String descripcion) {
        this.idReclamo = idReclamo;
        this.fechaHora = fechaHora;
        this.estado = estado;
        this.descripcion = descripcion;
    }

    public int getIdReclamo() {
        return idReclamo;
    }

    public void setIdReclamo(int idReclamo) {
        this.idReclamo = idReclamo;
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
