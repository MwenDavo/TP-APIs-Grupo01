package application.service;

import application.model.dao.IEdificioDAO;
import application.model.dao.IUsuarioDAO;
import application.model.entity.Edificio;
import application.model.entity.Unidad;
import application.model.entity.Usuario;
import application.model.util.ComprobacionRol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnidadService implements IUnidadService {
@Autowired
private IEdificioDAO edificioDAO;
@Autowired
private IUsuarioDAO usuarioDAO;
    @Override
    public void create(Unidad unidad, Edificio edificio, String username) {
        Usuario usuario = usuarioDAO.readByUsername(username);
        if (ComprobacionRol.comprobarAdmin(usuario)){
            edificioDAO.createUnidad(unidad,edificio);
        }
    }

    @Override
    public void delete(Unidad unidad,String username) {
        Usuario usuario = usuarioDAO.readByUsername(username);
        if (ComprobacionRol.comprobarAdmin(usuario)){
            edificioDAO.deleteUnidad(unidad);
        }

    }


}
