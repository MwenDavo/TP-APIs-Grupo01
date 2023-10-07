package application.model.entity.dto;

import application.model.entity.Foto;
import application.model.entity.Log;
import application.model.entity.Unidad;
import application.model.entity.Usuario;
import application.model.util.EstadoReclamo;

import java.util.ArrayList;
import java.util.List;

public class LocalizadoDTO extends ReclamoDTO{
    private long idUnidad;

    public LocalizadoDTO(){

    }

    public LocalizadoDTO(String descripcion, List<FotoDTO> fotos, String usuario, long idUnidad) {
        super(descripcion, fotos, usuario);
        this.idUnidad = idUnidad;
    }

    public LocalizadoDTO(String descripcion, List<FotoDTO> fotos, EstadoReclamo estadoReclamo, List<LogDTO> historial) {
        super(descripcion, fotos, estadoReclamo, historial);
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
