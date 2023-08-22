package dao;

import pojo.Usuario;

import java.util.List;

public interface DaoUsuario {
    void save(Usuario usuario);

    void update(Usuario usuario);

    void delete(Usuario usuario);
}
