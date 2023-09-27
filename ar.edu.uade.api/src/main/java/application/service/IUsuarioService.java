package application.service;

import application.model.entity.Usuario;

import java.util.List;

public interface IUsuarioService {
    void create(Usuario usuario);
    Usuario read(Usuario usuario);
    Usuario readByUsername(Usuario usuario);
    Usuario readByUsernameAndPassword(Usuario usuario);
    List<Usuario> readAll();
    void update(Usuario usuario);
    void delete(Usuario usuario);
}
