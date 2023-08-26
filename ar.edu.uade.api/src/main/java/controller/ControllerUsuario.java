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
}
