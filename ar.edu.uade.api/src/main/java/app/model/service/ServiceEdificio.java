package app.model.service;

import app.model.dao.DaoEdificio;
import app.model.entity.Edificio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceEdificio implements IServiceEdificio {
    @Autowired
    private DaoEdificio dao;

    @Override
    public void create(Edificio edificio) {

        dao.create(edificio);
    }

    @Override
    public List<Edificio> readAll() {

        return dao.readAll();
    }
}
