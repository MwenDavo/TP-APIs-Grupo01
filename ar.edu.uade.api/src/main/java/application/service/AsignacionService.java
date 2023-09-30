package application.service;

import application.model.dao.IUsuarioDAO;
import application.model.entity.Unidad;
import application.model.entity.Usuario;
import application.model.entity.UsuarioUnidad;
import application.model.util.TipoRelacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsignacionService implements IAsignacionService {
    @Autowired
    private IUsuarioDAO usuarioDAO;

    @Override
    public Usuario asignarUnidad(Usuario usuario, Unidad unidad, TipoRelacion tipoRelacion) {
        UsuarioUnidad usuarioUnidad = new UsuarioUnidad(usuario, unidad, tipoRelacion);
        usuario.getUnidades().add(usuarioUnidad);
        unidad.getUsuarios().add(usuarioUnidad);
        usuarioDAO.update(usuario);
        return usuario;
    }

    @Override
    public Usuario desasignarUnidad(Usuario usuario, Unidad unidad) {
        for (UsuarioUnidad usuarioUnidad : usuario.getUnidades()) {
            if (usuarioUnidad.getUnidad().getId() == unidad.getId()) {
                usuario.getUnidades().remove(usuarioUnidad);
                unidad.getUsuarios().remove(usuarioUnidad);
                usuarioDAO.update(usuario);
                break;
            }
        }
        return usuario;
    }
}
