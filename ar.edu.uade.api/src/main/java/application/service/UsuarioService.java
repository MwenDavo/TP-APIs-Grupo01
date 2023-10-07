package application.service;

import application.model.dao.IUsuarioDAO;
import application.model.entity.Log;
import application.model.entity.Reclamo;
import application.model.entity.Usuario;
import application.model.util.EstadoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements IUsuarioService {
    @Autowired
    private IUsuarioDAO usuarioDAO;


    @Override
    /**
     * @param UsuarioDTO completo convertido a Usuario
     */
    public void create(Usuario usuario) {
        usuarioDAO.create(usuario);
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
    public void update(long id, Usuario u) {
        Usuario usuario = usuarioDAO.read(id);
        usuario.setTelefono(u.getTelefono());
        usuario.setPassword(u.getPassword());
        usuarioDAO.update(usuario);
        };

    @Override
    /**
     * @param UsuarioDTO con id convertido a Usuario
     */
    public void delete(long id) {
        Usuario usuario = usuarioDAO.read(id);
        usuario.setDisponible(false);
        usuarioDAO.update(usuario);
    };
}
