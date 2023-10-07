package application.model.entity.dto;

import application.model.entity.Foto;
import application.model.entity.Log;
import application.model.entity.Unidad;
import application.model.entity.Usuario;
import application.model.util.EstadoReclamo;

import java.util.ArrayList;
import java.util.List;

public class LocalizadoDTO extends ReclamoDTO{
    private UnidadDTO unidad;

    public LocalizadoDTO(String descripcion, List<FotoDTO> fotos, Usuario usuario, UnidadDTO unidad) {
        super(descripcion, fotos, usuario);
        this.unidad = unidad;
    }

    public LocalizadoDTO(String descripcion, List<FotoDTO> fotos, EstadoReclamo estadoReclamo, List<LogDTO> historial) {
        super(descripcion, fotos, estadoReclamo, historial);
    }

    public LocalizadoDTO(EstadoReclamo estadoReclamo) {
        super(estadoReclamo);
    }

    public UnidadDTO getUnidad() {
        return unidad;
    }

    public void setUnidad(UnidadDTO unidad) {
        this.unidad = unidad;
    }
}
