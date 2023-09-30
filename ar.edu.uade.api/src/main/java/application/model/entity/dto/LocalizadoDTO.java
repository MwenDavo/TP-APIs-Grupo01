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

    public LocalizadoDTO(long id, String descripcion, List<Foto> fotos, Usuario usuario, EstadoReclamo estadoReclamo, List<Log> historial) {
        super(id,descripcion,fotos,usuario,estadoReclamo,historial);
    }

    public LocalizadoDTO(long id, String descripcion, List<Foto> fotos, EstadoReclamo estadoReclamo) {
        super(id,descripcion,fotos,estadoReclamo);
    }

    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }
}
