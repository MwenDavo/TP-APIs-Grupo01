package dao;

import controller.ControllerUsuario;

import java.util.ArrayList;

public class Dao {
    private static Dao instance = null;
    private Dao() {


    }
    public static Dao getInstance() {
        if (instance == null) {
            instance = new Dao();
        }
        return instance;
    }
}
