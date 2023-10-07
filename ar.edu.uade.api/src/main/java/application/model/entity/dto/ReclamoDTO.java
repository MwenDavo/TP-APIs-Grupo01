package application.model.entity.dto;

import application.model.entity.Foto;
import application.model.entity.Log;
import application.model.entity.Usuario;
import application.model.util.EstadoReclamo;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

public class ReclamoDTO {
    private String descripcion;
    private List<FotoDTO> fotos;
    private UsuarioDTO usuario;
    private EstadoReclamo estadoReclamo;
    private List<LogDTO> historial;

    public ReclamoDTO(String descripcion, List<FotoDTO> fotos, UsuarioDTO usuario) {
        this.descripcion = descripcion;
        this.fotos = fotos;
        this.usuario = usuario;
    }

    public ReclamoDTO(String descripcion, List<FotoDTO> fotos, EstadoReclamo estadoReclamo, List<LogDTO> historial) {
        this.descripcion = descripcion;
        this.fotos = fotos;
        this.estadoReclamo = estadoReclamo;
        this.historial = historial;
    }

    public ReclamoDTO(EstadoReclamo estadoReclamo) {
        this.estadoReclamo = estadoReclamo;
    }

    public ReclamoDTO() {

    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<FotoDTO> getFotos() {
        return fotos;
    }

    public void setFotos(List<FotoDTO> fotos) {
        this.fotos = fotos;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public EstadoReclamo getEstadoReclamo() {
        return estadoReclamo;
    }

    public void setEstadoReclamo(EstadoReclamo estadoReclamo) {
        this.estadoReclamo = estadoReclamo;
    }

    public List<LogDTO> getHistorial() {
        return historial;
    }

    public void setHistorial(List<LogDTO> historial) {
        this.historial = historial;
    }
}
