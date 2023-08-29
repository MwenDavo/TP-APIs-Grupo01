package controller;

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
