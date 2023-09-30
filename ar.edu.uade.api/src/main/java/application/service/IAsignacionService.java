package application.service;

import application.model.entity.Unidad;
import application.model.entity.Usuario;
import application.model.util.TipoRelacion;

public interface IAsignacionService {
    Usuario asignarUnidad(Usuario usuario, Unidad unidad, TipoRelacion tipoRelacion);
    Usuario desasignarUnidad(Usuario usuario, Unidad unidad);
}
