package application.service;

import application.model.entity.Usuario;

import java.util.List;

public interface IUsuarioService {
    void create(Usuario usuario);
    Usuario read(String user, String password);
    List<Usuario> readAll();
    void update(long id, Usuario usuario);
    void delete(long id, Usuario usuario);
}
