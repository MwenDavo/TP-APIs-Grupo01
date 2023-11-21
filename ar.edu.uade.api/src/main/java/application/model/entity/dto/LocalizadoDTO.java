package application.model.entity.dto;

import application.model.util.EstadoReclamo;

import java.util.List;

public class LocalizadoDTO extends ReclamoDTO{
    private long idUnidad;

    public LocalizadoDTO(){

    }

    public LocalizadoDTO(String descripcion, String usuario, long idUnidad) {
        super(descripcion, usuario);
        this.idUnidad = idUnidad;
    }

    public LocalizadoDTO(long id, String descripcion/*, List<FotoDTO> fotos*/, EstadoReclamo estadoReclamo, List<LogDTO> historial) {
        super(id, descripcion/*, fotos*/, estadoReclamo, historial);
    }

    public LocalizadoDTO(EstadoReclamo estadoReclamo) {
        super(estadoReclamo);
    }


    public long getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(long idUnidad) {
        this.idUnidad = idUnidad;
    }
}
