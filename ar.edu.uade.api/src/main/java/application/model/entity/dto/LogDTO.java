package application.model.entity.dto;

import application.model.util.EstadoReclamo;

import java.util.Date;

public class LogDTO {

    private Date FechaHora;

    private EstadoReclamo estadoReclamo;

    private String descripcion;

    public LogDTO(Date fechaHora, EstadoReclamo estadoReclamo, String descripcion){
        this.FechaHora = fechaHora;
        this.estadoReclamo = estadoReclamo;
        this.descripcion = descripcion;
    }

    public Date getFechaHora() {
        return FechaHora;
    }

    public EstadoReclamo getEstadoReclamo() {
        return estadoReclamo;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
