package application.service;

import application.model.entity.Unidad;
import application.model.entity.Usuario;
import application.model.util.TipoRelacion;

public interface IAsignacionService {
    void asignarUnidad(long idUsuario, long idUnidad, String relacion);
    void desasignarUnidad(long idUsuario, long idUnidad);
}
