package controller;

import modelo.Edificio;

import java.util.List;

public class ControllerEdificio {
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
