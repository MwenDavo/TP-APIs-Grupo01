package application.service;

import application.model.dao.IEdificioDAO;
import application.model.dao.IUsuarioDAO;
import application.model.entity.Edificio;
import application.model.entity.Unidad;
import application.model.entity.Usuario;
import application.model.entity.UsuarioUnidad;
import application.model.util.ComprobacionRol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EdificioService implements IEdificioService {
    @Autowired
    private IEdificioDAO edificioDAO;

    @Autowired
    private IUsuarioDAO usuarioDAO;

    @Override
    public void create(Edificio edificio, String username) {
        if (ComprobacionRol.comprobarAdmin(usuarioDAO.readByUsername(username))){
            edificioDAO.create(edificio);
        }

    }

    @Override
    public Edificio read(Edificio edificio) {
        return edificioDAO.read(edificio.getId());
    }

    @Override
    public Edificio readByDireccion(String direccion) {
        return edificioDAO.readByDireccion(direccion);
    }

    @Override
    public List<Edificio> readAll(String usuario) {
        Usuario u = usuarioDAO.readByUsername(usuario);
        if (!ComprobacionRol.comprobarAdmin(u)){
            List<Edificio> edificios = new ArrayList<>();
            for (UsuarioUnidad usuarioUnidad : u.getUnidades()) {
                edificios.add(usuarioUnidad.getUnidad().getEdificio());
            }
            return edificios;
        }else{
            return edificioDAO.readAll();
        }
    }

    @Override
    public Unidad readUnidad(long id){
        return edificioDAO.readUnidad(id);
    }
}
