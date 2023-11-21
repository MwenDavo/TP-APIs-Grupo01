package application.model.dao;

import application.model.entity.*;
import application.model.util.EstadoReclamo;

import java.util.List;

public interface IReclamoDAO {
    void create(General reclamo);
    void create(Localizado reclamo);
    public List<Reclamo> readByDescripcion(String desc);
    General readGeneral(long id);
    Localizado readLocalizado(long id);
    void updateLocalizado(Localizado reclamo);

    void updateGeneral(General reclamo);
}
