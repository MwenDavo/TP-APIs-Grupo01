package controller;

import dao.DaoUsuario;
import dao.DaoUsuarioMySQL;
import pojo.Credencial;
import pojo.Usuario;

import java.util.List;

public class ControllerUsuario {
    private static ControllerUsuario instance = null;

    private ControllerUsuario() {

    }

    public static ControllerUsuario getInstance() {
        if (instance == null) {
            instance = new ControllerUsuario();
        }
        return instance;
    }

    public void registrarUsuario(Credencial credencial, Usuario usuario) {
        DaoUsuario daoUsuario = DaoUsuarioMySQL.getInstance();
        daoUsuario.save(credencial, usuario);
    }

    public List<Usuario> listarUsuarios() {
        DaoUsuario daoUsuario = DaoUsuarioMySQL.getInstance();
        return daoUsuario.getAll();
    }

    public Usuario iniciarSesion(Credencial credencial) {
        DaoUsuario daoUsuario = DaoUsuarioMySQL.getInstance();
        return daoUsuario.get(credencial);
    }

    public void modificarUsuario(Usuario usuario) {
        DaoUsuario daoUsuario = DaoUsuarioMySQL.getInstance();
        daoUsuario.update(usuario);
    }

    public void eliminarUsuario(Usuario usuario) {
        DaoUsuario daoUsuario = DaoUsuarioMySQL.getInstance();
        daoUsuario.delete(usuario);
    }
}
