package controller;

public class ControllerUsuario {
    //TODO dar funcionalidad
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
