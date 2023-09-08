package app.model.dao;

import app.model.entity.Credencial;
import app.model.entity.Unidad;
import app.model.entity.Usuario;

import java.util.List;

public interface DaoUsuario {

    Usuario get(Credencial credencial);

    List<Usuario> getAll();

    void save(Credencial credencial, Usuario usuario);

    void update(Usuario usuario);

    void sacarUnidad(Usuario usuario, Unidad unidad);

    void delete(Usuario usuario);
}
