package controller;

import dao.DaoEdificio;
import dao.DaoEdificioMySQL;
import pojo.Edificio;
import pojo.Unidad;

import java.util.List;

public class ControllerEdificio {
    private ControllerEdificio instance = null;

    private ControllerEdificio() {

    }

    public ControllerEdificio getInstance() {
        if (instance == null) {
            instance = new ControllerEdificio();
        }
        return instance;
    }
}
