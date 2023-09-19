package app.model.service;

import app.model.entity.Edificio;
import app.model.entity.General;
import app.model.entity.Log;
import app.model.entity.Reclamo;
import app.util.EstadoReclamo;

import java.util.List;

public interface IServiceReclamo {

    void create(Reclamo reclamo);

    Reclamo read(int id);

    List<Reclamo> readAll();

    List<Reclamo> readByEstadoReclamo(EstadoReclamo estadoReclamo);

    List<General> readByEdificio(Edificio edificio);

    void update(Reclamo reclamo, Log log);

    List<Log> readByReclamo(Reclamo reclamo);
}
