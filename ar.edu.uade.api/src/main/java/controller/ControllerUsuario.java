package controller;

import dao.Dao;
import modelo.Usuario;

import java.util.ArrayList;
import java.util.List;

public class ControllerUsuario {
    private List<Usuario> usuarios;
    private Dao dao;
    private static ControllerUsuario instance = null;
    private ControllerUsuario() {
        usuarios = new ArrayList<Usuario>();
        dao = Dao.getInstance();
    }
    public static ControllerUsuario getInstance() {
        if (instance == null) {
            instance = new ControllerUsuario();
        }
        return instance;
    }
}
