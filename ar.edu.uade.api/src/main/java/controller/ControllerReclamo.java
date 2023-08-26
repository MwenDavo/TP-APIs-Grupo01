package controller;

import dao.DaoReclamo;
import dao.DaoReclamoMySQL;
import pojo.Edificio;
import pojo.Reclamo;
import pojo.Usuario;
import util.estadosreclamo.EstadoReclamo;

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

    public void cargarReclamo(Reclamo reclamo) {
        DaoReclamo daoReclamo = DaoReclamoMySQL.getInstance();
        daoReclamo.save(reclamo);
    }

    public List<Reclamo> listarReclamos() {
        DaoReclamo daoReclamo = DaoReclamoMySQL.getInstance();
        return daoReclamo.getAll();
    }

    public List<Reclamo> listarReclamosPorEstado(String estado) {
        DaoReclamo daoReclamo = DaoReclamoMySQL.getInstance();
        return daoReclamo.getByState(estado);
    }

    public void modificarReclamo(Reclamo reclamo) {
        DaoReclamo daoReclamo = DaoReclamoMySQL.getInstance();
        daoReclamo.update(reclamo);
    }

    public void eliminarReclamo(Reclamo reclamo) {
        DaoReclamo daoReclamo = DaoReclamoMySQL.getInstance();
        daoReclamo.delete(reclamo);
    }
}
