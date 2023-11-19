package application.model.entity.dto;

import application.model.util.EstadoReclamo;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

public class ReclamoDTO {
    private String descripcion;
    private MultipartFile[] fotos;;
    private String username;
    private EstadoReclamo estadoReclamo;
    private List<LogDTO> historial = new ArrayList<>();

    public ReclamoDTO(String descripcion, String username) {
        this.descripcion = descripcion;
        this.username = username;
    }

    public ReclamoDTO(String descripcion, MultipartFile[] fotos, EstadoReclamo estadoReclamo, List<LogDTO> historial) {
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

    public MultipartFile[] getFotos() {
        return fotos;
    }

    public void setFotos(MultipartFile[] fotos) {
        this.fotos = fotos;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
