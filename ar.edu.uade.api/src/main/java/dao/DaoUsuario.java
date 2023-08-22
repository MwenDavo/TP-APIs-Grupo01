package dao;

import modelo.Usuario;

import java.util.List;

public interface DaoUsuario {
    List<Usuario> getAll();

    void save(Usuario usuario);

    void update(Usuario usuario);

    void delete(Usuario usuario);
}
