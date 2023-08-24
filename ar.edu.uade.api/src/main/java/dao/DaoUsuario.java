package dao;

import pojo.Credencial;
import pojo.Edificio;
import pojo.Usuario;

import java.util.List;

public interface DaoUsuario {
    Usuario get(Credencial credencial);

    List<Usuario> getAll();

    void save(Credencial credencial, Usuario usuario);

    void update(Usuario usuario);

    void delete(Usuario usuario);
}
