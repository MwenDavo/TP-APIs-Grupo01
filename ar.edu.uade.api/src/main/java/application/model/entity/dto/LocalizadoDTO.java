package application.model.entity.dto;

import application.model.entity.Foto;
import application.model.entity.Log;
import application.model.entity.Unidad;
import application.model.entity.Usuario;
import application.model.util.EstadoReclamo;

import java.util.ArrayList;
import java.util.List;

public class LocalizadoDTO extends ReclamoDTO{

    private Unidad unidad;

    public LocalizadoDTO(long id, String descripcion, List<FotoDTO> fotos, Usuario usuario, EstadoReclamo estadoReclamo, List<LogDTO> historial, Unidad unidad) {
        super(id, descripcion, fotos, usuario, estadoReclamo, historial);
        this.unidad = unidad;
    }

    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }
}
