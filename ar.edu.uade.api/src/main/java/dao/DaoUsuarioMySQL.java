package dao;

import modelo.Usuario;

import java.util.List;

public class DaoUsuarioMySQL implements DaoUsuario {
    private static DaoUsuarioMySQL instance = null;

    private DaoUsuarioMySQL() {

    }

    public static DaoUsuarioMySQL getInstance() {
        if (instance == null) {
            instance = new DaoUsuarioMySQL();
        }
        return instance;
    }

    @Override
    public List<Usuario> getAll() {
        return null;
    }

    @Override
    public void save(Usuario usuario) {

    }

    @Override
    public void update(Usuario usuario) {

    }

    @Override
    public void delete(Usuario usuario) {

    }
}
