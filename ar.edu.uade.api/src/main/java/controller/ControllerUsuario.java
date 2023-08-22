package controller;

import dao.Dao;
import modelo.Usuario;

import java.util.ArrayList;
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
