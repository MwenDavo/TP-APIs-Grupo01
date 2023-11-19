package application.model.entity.dto;

import application.model.util.EstadoReclamo;

import java.util.Date;

public class LogDTO {
    private long id;
    private Date fechaHora;
    private EstadoReclamo estadoReclamo;
    private String descripcion;

    public LogDTO(){

    }

    public LogDTO(EstadoReclamo estadoReclamo, String descripcion) {
        this.estadoReclamo = estadoReclamo;
        this.descripcion = descripcion;
    }

    public LogDTO(long id, Date fechaHora, EstadoReclamo estadoReclamo, String descripcion) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.estadoReclamo = estadoReclamo;
        this.descripcion = descripcion;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
