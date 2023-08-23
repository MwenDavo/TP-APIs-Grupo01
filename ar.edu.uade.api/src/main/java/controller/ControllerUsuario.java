package controller;

import dao.DaoUsuario;
import dao.DaoUsuarioMySQL;
import pojo.Usuario;

public class ControllerUsuario {
    //TODO dar funcionalidad
    private static ControllerUsuario instance = null;

    private ControllerUsuario() {

    }

    public static ControllerUsuario getInstance() {
        if (instance == null) {
            instance = new ControllerUsuario();
        }
        return instance;
    }

    public Usuario get(int id) {
        DaoUsuario dao = DaoUsuarioMySQL.getInstance();
        return dao.get(id);
    }
}
