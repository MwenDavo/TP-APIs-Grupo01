package controller;

import pojo.Edificio;

import java.util.List;

public class ControllerEdificio {
    //TODO dar funcionalidad
    private List<Edificio> edificios;
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
