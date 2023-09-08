package app.model.dao;

import app.model.entity.LogEstadoReclamo;
import app.model.entity.Reclamo;

import java.util.List;

public interface DaoLogReclamo {

    void saveLogEstadoReclamo(LogEstadoReclamo log);

    List<LogEstadoReclamo> getByReclamo(Reclamo reclamo);
}
