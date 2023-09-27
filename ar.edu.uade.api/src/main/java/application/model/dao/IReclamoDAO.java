package application.model.dao;

import application.model.entity.Reclamo;

import java.util.List;

public interface IReclamoDAO {

    void create(Reclamo reclamo);
    Reclamo read(long id);
    List<Reclamo> readAll();
}
