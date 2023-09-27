package application.service;

import application.model.dao.IReclamoDAO;
import application.model.entity.Reclamo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ReclamoService implements IReclamoService {
    @Autowired
    private IReclamoDAO dao;

    @Override
    public void create(Reclamo reclamo) {
        dao.create(reclamo);
    }

    @Override
    public Reclamo read(long id) {
        return dao.read(id);
    }

    @Override
    public List<Reclamo> readAll() {

        return dao.readAll();
    }
}
