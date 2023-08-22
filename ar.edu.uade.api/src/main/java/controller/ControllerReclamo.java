package controller;

public class ControllerReclamo {
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
