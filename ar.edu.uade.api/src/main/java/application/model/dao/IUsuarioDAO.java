package application.model.dao;

import application.model.entity.Usuario;

import java.util.List;

public interface IUsuarioDAO {
    void create(Usuario usuario);
    Usuario read(long id);
    Usuario readByUsername(String username);
    Usuario readByUsernameAndPassword(String user, String password);
    List<Usuario> readAll();
    void update(Usuario usuario);
}
