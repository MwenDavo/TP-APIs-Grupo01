package application.service;

import application.model.dao.IReclamoDAO;
import application.model.entity.General;
import application.model.entity.Reclamo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReclamoService implements IReclamoService {
    @Autowired
    private IReclamoDAO reclamoDAO;

    @Override
    public void create(Reclamo reclamo) {
        reclamoDAO.create(reclamo);
    }

    @Override
    public Reclamo read(Reclamo reclamo) {
        return reclamoDAO.read(reclamo.getId());
    }

    @Override
    public List<Reclamo> readByEstadoReclamo(Reclamo reclamo) {
        return reclamoDAO.readByEstadoReclamo(reclamo.getEstadoReclamo());
    }

    @Override
    public List<Reclamo> readAll() {
        return reclamoDAO.readAll();
    }

    @Override
    public void update(Reclamo reclamo) {
        reclamoDAO.update(reclamo);
    }
}
