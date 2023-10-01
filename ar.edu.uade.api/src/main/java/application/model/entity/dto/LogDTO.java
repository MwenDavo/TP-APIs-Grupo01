package application.model.entity.dto;

import application.model.util.EstadoReclamo;

import java.util.Date;

public class LogDTO {
    private EstadoReclamo estadoReclamo;
    private String descripcion;

    public LogDTO(EstadoReclamo estadoReclamo, String descripcion) {
        this.estadoReclamo = estadoReclamo;
        this.descripcion = descripcion;
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
