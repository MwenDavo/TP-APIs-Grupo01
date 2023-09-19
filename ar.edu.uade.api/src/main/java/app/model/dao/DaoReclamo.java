package app.model.dao;

import app.model.entity.*;
import app.util.EstadoReclamo;
import java.util.List;

public interface DaoReclamo {

    void create(Reclamo reclamo);

    Reclamo read(int id);

    List<Reclamo> readAll();

    List<Reclamo> readByEstadoReclamo(EstadoReclamo estadoReclamo);

    List<General> readByEdificio(Edificio edificio);

    void update(Reclamo reclamo, Log log);

    List<Log> readByReclamo(Reclamo reclamo);
}
