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
    private long id;
    private String descripcion;
    private List<FotoDTO> fotos = new ArrayList<>();
    private Usuario usuario;
    private EstadoReclamo estadoReclamo = EstadoReclamo.NUEVO;
    private List<LogDTO> historial = new ArrayList<>();

    public ReclamoDTO(long id, String descripcion, List<FotoDTO> fotos, Usuario usuario, EstadoReclamo estadoReclamo, List<LogDTO> historial) {
        this.id = id;
        this.descripcion = descripcion;
        this.fotos = fotos;
        this.usuario = usuario;
        this.estadoReclamo = estadoReclamo;
        this.historial = historial;
    }

    public ReclamoDTO(String descripcion, List<FotoDTO> fotos, EstadoReclamo estadoReclamo) {
        this.descripcion = descripcion;
        this.fotos = fotos;
        this.estadoReclamo = estadoReclamo;
    }

    public ReclamoDTO(String descripcion, EstadoReclamo estadoReclamo) {
        this.descripcion = descripcion;
        this.estadoReclamo = estadoReclamo;
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

    public List<FotoDTO> getFotos() {
        return fotos;
    }

    public void setFotos(List<FotoDTO> fotos) {
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

    public List<LogDTO> getHistorial() {
        return historial;
    }

    public void setHistorial(List<LogDTO> historial) {
        this.historial = historial;
    }
}
