package application.model.entity.dto;

import application.model.util.EstadoReclamo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class LocalizadoDTO extends ReclamoDTO{
    private long idUnidad;

    public LocalizadoDTO(){

    }

    public LocalizadoDTO(String descripcion, MultipartFile[] fotos, String usuario, long idUnidad) {
        super(descripcion, usuario);
        this.idUnidad = idUnidad;
    }

    public LocalizadoDTO(long id, String descripcion, MultipartFile[] fotos, EstadoReclamo estadoReclamo, List<LogDTO> historial) {
        super(id, descripcion, fotos, estadoReclamo, historial);
    }

    public LocalizadoDTO(EstadoReclamo estadoReclamo) {
        super(estadoReclamo);
    }

    public long getUnidad() {
        return idUnidad;
    }

    public void setUnidad(long unidad) {
        this.idUnidad = unidad;
    }


}
