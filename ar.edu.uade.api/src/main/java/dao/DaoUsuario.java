package dao;

import app.model.Credencial;
import app.model.Usuario;

import java.util.List;

public interface DaoUsuario {

    Usuario get(Credencial credencial);

    List<Usuario> getAll();

    void save(Credencial credencial, Usuario usuario);

    void update(Usuario usuario);

    void delete(Usuario usuario);
}
