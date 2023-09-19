package app.model.service;

import app.model.dao.DaoReclamo;
import app.model.entity.Edificio;
import app.model.entity.General;
import app.model.entity.Log;
import app.model.entity.Reclamo;
import app.util.EstadoReclamo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceReclamo implements IServiceReclamo {
    @Autowired
    private DaoReclamo dao;

    @Override
    public void create(Reclamo reclamo) {

    }

    @Override
    public Reclamo read(int id) {
        return null;
    }

    @Override
    public List<Reclamo> readAll() {

        return dao.readAll();
    }

    @Override
    public List<Reclamo> readByEstadoReclamo(EstadoReclamo estadoReclamo) {
        return null;
    }

    @Override
    public List<General> readByEdificio(Edificio edificio) {
        return null;
    }

    @Override
    public void update(Reclamo reclamo, Log log) {

    }

    @Override
    public List<Log> readByReclamo(Reclamo reclamo) {
        return null;
    }
}
