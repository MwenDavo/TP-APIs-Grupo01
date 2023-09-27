package application.model.dao;

import application.model.entity.Edificio;
import application.model.entity.General;
import application.model.entity.Reclamo;
import application.model.util.EstadoReclamo;

import java.util.List;

public interface IReclamoDAO {
    void create(Reclamo reclamo);
    Reclamo read(long id);
    List<Reclamo> readByEstadoReclamo(EstadoReclamo estadoReclamo);
    List<General> readByEdificio(Edificio edificio);
    List<Reclamo> readAll();
    void update(Reclamo reclamo);
}
