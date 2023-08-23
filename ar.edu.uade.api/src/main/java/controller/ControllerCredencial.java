package controller;

import dao.DaoCredencial;
import dao.DaoCredencialMySQL;
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

    public void register() {

    }

    public Usuario login(String user, String password) {
        DaoCredencial daoCredencial = DaoCredencialMySQL.getInstance();
        ControllerUsuario controllerUsuario = ControllerUsuario.getInstance();
        int idUsuario = daoCredencial.getId(user, password);
        return controllerUsuario.get(idUsuario);
    }
}
