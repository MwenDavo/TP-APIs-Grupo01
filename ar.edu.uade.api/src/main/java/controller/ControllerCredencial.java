package controller;

import dao.DaoCredencial;
import dao.DaoCredencialMySQL;
import dao.DaoUsuario;
import dao.DaoUsuarioMySQL;
import pojo.Usuario;

public class ControllerCredencial {
    private static ControllerCredencial instance = null;

    private ControllerCredencial() {

    }

    public static ControllerCredencial getInstance() {
        if (instance == null) {
            instance = new ControllerCredencial();
        }
        return instance;
    }

    public void register(Usuario usuario, String user, String password) {
        DaoCredencial daoCredencial = DaoCredencialMySQL.getInstance();
        DaoUsuario daoUsuario = DaoUsuarioMySQL.getInstance();
        daoCredencial.save(user, password);
        daoUsuario.save(usuario);
    }

    public Usuario login(String user, String password) {
        DaoCredencial daoCredencial = DaoCredencialMySQL.getInstance();
        ControllerUsuario controllerUsuario = ControllerUsuario.getInstance();
        int idUsuario = daoCredencial.getId(user, password);
        if (idUsuario == -1) {
            return null;
        }
        return controllerUsuario.get(idUsuario);
    }
}
