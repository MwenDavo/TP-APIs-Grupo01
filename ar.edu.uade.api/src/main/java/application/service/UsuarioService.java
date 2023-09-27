package application.service;

import application.model.dao.IUsuarioDAO;
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
    public Usuario read(Usuario usuario) {
        return usuarioDAO.read(usuario.getId());
    }

    @Override
    /**
     * @param UsuarioDTO con username convertido a Usuario
     */
    public Usuario readByUsername(Usuario usuario) {
        return usuarioDAO.readByUsername(usuario.getUsername());
    }

    @Override
    /**
     * @param UsuarioDTO con username y password convertido a Usuario
     */
    public Usuario readByUsernameAndPassword(Usuario usuario) {
        usuario = usuarioDAO.readByUsernameAndPassword(usuario.getUsername(), usuario.getPassword());
        if (usuario.getEstadoUsuario() == EstadoUsuario.DISPONIBLE) {
            return usuario;
        }
        return null;
    }

    @Override
    public List<Usuario> readAll() {
        return usuarioDAO.readAll();
    }

    @Override
    /**
     * @param UsuarioDTO completo convertido a Usuario
     */
    public void update(Usuario usuario) {
        usuarioDAO.update(usuario);
    }

    @Override
    /**
     * @param UsuarioDTO con id convertido a Usuario
     */
    public void delete(Usuario usuario) {
        usuario = usuarioDAO.read(usuario.getId());
        usuario.setEstadoUsuario(EstadoUsuario.ELIMINADO);
        usuarioDAO.update(usuario);
    }
}
