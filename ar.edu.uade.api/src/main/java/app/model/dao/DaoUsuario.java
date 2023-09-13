package app.model.dao;

import app.model.entity.Unidad;
import app.model.entity.Usuario;

import java.util.List;

public interface DaoUsuario {

    void create(Usuario usuario);

    Usuario read(Usuario usuario);

    List<Usuario> readAll();

    void update(Usuario usuario);

    void updateUnidades(Usuario usuario, Unidad unidad);

}
