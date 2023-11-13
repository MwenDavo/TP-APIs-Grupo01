package application.service;

import application.model.dao.IEdificioDAO;
import application.model.dao.IUsuarioDAO;
import application.model.entity.*;
import application.model.util.ComprobacionRol;
import application.model.util.TipoRelacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UsuarioService implements IUsuarioService {
    @Autowired
    private IUsuarioDAO usuarioDAO;
    @Autowired
    private IEdificioDAO edificioDAO;


    @Override
    /**
     * @param UsuarioDTO completo convertido a Usuario
     */
    public void create(Usuario usuario, String username) {
        Usuario usuario1 = usuarioDAO.readByUsername(username);
        if (ComprobacionRol.comprobarAdmin(usuario1)){
            usuarioDAO.create(usuario);
        }
    }

    @Override
    /**
     * @param UsuarioDTO con id convertido a Usuario
     */
    public Usuario read(long id) {
        return usuarioDAO.read(id);
    }

    @Override
    /**
     * @param UsuarioDTO con username convertido a Usuario
     */
    public Usuario readByUsername(String usuario) {
        return usuarioDAO.readByUsername(usuario);
    }

    @Override
    /**
     * @param UsuarioDTO con username y password convertido a Usuario
     */
    public Usuario readByUsernameAndPassword(Usuario usuario) {
        usuario = usuarioDAO.readByUsernameAndPassword(usuario.getUsername(), usuario.getPassword());
        System.out.println("Usuario: " + usuario.isDisponible());
        if (usuario.isDisponible() == true) {
            return usuario;
        }
        return null;
    }

    @Override
    public List<Usuario> readAll() {
        return usuarioDAO.readAll();
    }

    /**
     * @param UsuarioDTO completo convertido a Usuario
     */
    @Override
    public void update(long id, Usuario u, String username) {
        if(ComprobacionRol.comprobarAdmin(usuarioDAO.readByUsername(username))){
            Usuario usuario = usuarioDAO.read(id);
            usuario.setTelefono(u.getTelefono());
            usuario.setPassword(u.getPassword());
            usuarioDAO.update(usuario);
        }
    }

    @Override
    /**
     * @param UsuarioDTO con id convertido a Usuario
     */
    public void delete(long id,String username) {
        if (ComprobacionRol.comprobarAdmin(usuarioDAO.readByUsername(username))){
            Usuario usuario = usuarioDAO.read(id);
            usuario.setDisponible(false);
            usuarioDAO.update(usuario);
        }
    }

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

    @Override
    public List<Unidad> verificarRelacion(String username, List<Unidad> unidades){
        Usuario usuario = usuarioDAO.readByUsername(username);
        List<Unidad> unidadesComp = new ArrayList<>();
        if(!ComprobacionRol.comprobarAdmin(usuario)){
            for (Unidad unidad : unidades){
            for (UsuarioUnidad usuarioUnidad:
                    unidad.getUsuarios()) {
                if(usuarioUnidad.getUsuario().getId() == usuario.getId()){
                    unidadesComp.add(unidad);
                }
            }
        }
        }else{
            unidadesComp = unidades;
        }
        return unidadesComp;
    }
}
