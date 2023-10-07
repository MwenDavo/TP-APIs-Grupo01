package application.model.entity.dto;

import application.model.entity.Log;
import application.model.util.EstadoReclamo;

import java.util.Date;

public class LogDTO {
    private Date FechaHora;
    private EstadoReclamo estadoReclamo;
    private String descripcion;

    public LogDTO(){

    }

    public LogDTO(EstadoReclamo estadoReclamo, String descripcion) {
        this.estadoReclamo = estadoReclamo;
        this.descripcion = descripcion;
    }

    public LogDTO(Date fechaHora, EstadoReclamo estadoReclamo, String descripcion) {
        FechaHora = fechaHora;
        this.estadoReclamo = estadoReclamo;
        this.descripcion = descripcion;
    }

    public Date getFechaHora() {
        return FechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        FechaHora = fechaHora;
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
}
