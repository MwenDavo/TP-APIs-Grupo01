package application.service;

import application.model.dao.IEdificioDAO;
import application.model.dao.IUsuarioDAO;
import application.model.entity.Unidad;
import application.model.entity.Usuario;
import application.model.entity.UsuarioUnidad;
import application.model.util.TipoRelacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class AsignacionService implements IAsignacionService {
    @Autowired
    private IUsuarioDAO usuarioDAO;
    @Autowired
    private IEdificioDAO edificioDAO;

    @Override //TODO modificar interfaz
    public void asignarUnidad(long idUsuario, long idUnidad, String relacion) {
        Usuario usuario = usuarioDAO.read(idUsuario);
        Unidad unidad = edificioDAO.readUnidad(idUnidad);
        if (usuario != null && unidad != null) {
            UsuarioUnidad usuarioUnidad = new UsuarioUnidad(usuario, unidad);
            if (Objects.equals(relacion, "PROPIETARIO")) {
                usuarioUnidad.setTipoRelacion(TipoRelacion.PROPIETARIO);
            }else {
                usuarioUnidad.setTipoRelacion(TipoRelacion.INQUILINO);
            }
            usuario.getUnidades().add(usuarioUnidad);
            unidad.getUsuarios().add(usuarioUnidad);
            usuarioDAO.update(usuario);
        }
    }

    @Override //TODO modificar interfaz
    @Transactional
    public void desasignarUnidad(long idUsuario, long idUnidad) {
        Usuario usuario = usuarioDAO.read(idUsuario);
        Unidad unidad = edificioDAO.readUnidad(idUnidad);
        if (usuario != null && unidad != null) {

            for (UsuarioUnidad usuarioUnidad : usuario.getUnidades()) {
                if (usuarioUnidad.getUnidad().getId() == unidad.getId()) {
                    usuario.getUnidades().remove(usuarioUnidad);
                    unidad.getUsuarios().remove(usuarioUnidad);
                    usuarioDAO.update(usuario);
                    edificioDAO.borrarRelacion(usuarioUnidad);
                    break;
                }
            }
        }
    }
}
