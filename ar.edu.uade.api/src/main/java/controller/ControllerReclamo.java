package controller;

import dao.DaoReclamo;
import dao.DaoReclamoMySQL;
import pojo.*;

import java.util.List;

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
