package controller;

import pojo.Reclamo;

import java.util.List;

public class ControllerReclamo {
    private List<Reclamo> reclamos;
    private ControllerReclamo instance = null;
    private ControllerReclamo() {
    }
    public ControllerReclamo getInstance() {
        if (instance == null) {
            instance = new ControllerReclamo();
        }
        return instance;
    }
}
