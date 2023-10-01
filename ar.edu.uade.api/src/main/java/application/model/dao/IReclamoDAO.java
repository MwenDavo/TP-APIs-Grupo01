package application.model.dao;

import application.model.entity.*;
import application.model.util.EstadoReclamo;

import java.util.List;

public interface IReclamoDAO {
    void create(General reclamo);
    void create(Localizado reclamo);
    Reclamo read(long id);
    void update(Reclamo reclamo);
}
