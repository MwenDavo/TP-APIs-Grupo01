package dao;

import pojo.Edificio;
import pojo.Usuario;

import java.util.List;

public interface DaoUsuario {
    Usuario get(int id);

    List<Usuario> getAll();

    void save(Usuario usuario);

    void update(Usuario usuario);

    void delete(Usuario usuario);
}
