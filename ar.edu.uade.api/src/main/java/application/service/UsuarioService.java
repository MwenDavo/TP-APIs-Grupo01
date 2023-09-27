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
    public void create(Usuario usuario) {
        usuarioDAO.create(usuario);
    }

    @Override
    public Usuario read(String username, String password) {
        Usuario usuario = usuarioDAO.read(username, password);
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
    public void update(Usuario usuario) {
        usuarioDAO.update(usuario);
    }

    @Override
    public void delete(Usuario usuario) {
        usuario = usuarioDAO.read(usuario.getUsername(), usuario.getPassword());
        usuario.setEstadoUsuario(EstadoUsuario.ELIMINADO);
        usuarioDAO.update(usuario);
    }
}
