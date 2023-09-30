package application.model.entity.dto;

import application.model.entity.Foto;
import application.model.entity.Log;
import application.model.entity.Unidad;
import application.model.entity.Usuario;
import application.model.util.EstadoReclamo;

import java.util.ArrayList;
import java.util.List;

public class LocalizadoDTO {
    private long id;

    private String descripcion;

    private List<Foto> fotos = new ArrayList<>();

    private Usuario usuario;

    private EstadoReclamo estadoReclamo = EstadoReclamo.NUEVO;

    private List<Log> historial = new ArrayList<>();

    private Unidad unidad;

    public LocalizadoDTO(long id, String descripcion, List<Foto> fotos, Usuario usuario, EstadoReclamo estadoReclamo, List<Log> historial) {
        this.id = id;
        this.descripcion = descripcion;
        this.fotos = fotos;
        this.usuario = usuario;
        this.estadoReclamo = estadoReclamo;
        this.historial = historial;
    }

    public LocalizadoDTO(long id, String descripcion, List<Foto> fotos, EstadoReclamo estadoReclamo) {
        this.id = id;
        this.descripcion = descripcion;
        this.fotos = fotos;
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

    public List<Foto> getFotos() {
        return fotos;
    }

    public void setFotos(List<Foto> fotos) {
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

    public List<Log> getHistorial() {
        return historial;
    }

    public void setHistorial(List<Log> historial) {
        this.historial = historial;
    }
}
