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

    public void cargarEdificio(Edificio edificio) {
        DaoEdificio daoEdificio = DaoEdificioMySQL.getInstance();
        daoEdificio.save(edificio);
    }

    public List<Edificio> listarEdificios() {
        DaoEdificio daoEdificio = DaoEdificioMySQL.getInstance();
        return daoEdificio.getAll();
    }

    public void modificarEdificio(Edificio edificio) {
        DaoEdificio daoEdificio = DaoEdificioMySQL.getInstance();
        daoEdificio.update(edificio);
    }

    public void modificarUnidad(Unidad unidad) {
        DaoEdificio daoEdificio = DaoEdificioMySQL.getInstance();
        daoEdificio.updateDpto(unidad);
    }

    public void eliminarEdificio(Edificio edificio) {
        DaoEdificio daoEdificio = DaoEdificioMySQL.getInstance();
        daoEdificio.delete(edificio);
    }
}
