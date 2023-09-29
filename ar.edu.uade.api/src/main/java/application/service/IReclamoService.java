package application.service;

import application.model.entity.General;
import application.model.entity.Localizado;
import application.model.entity.Reclamo;

import java.util.List;

public interface IReclamoService {
    void createReclamoGeneral(General reclamo);
    void createReclamoLocalizado(Localizado reclamo);
    Reclamo read(Reclamo reclamo);
    List<Reclamo> readByEstadoReclamo(Reclamo reclamo);
    List<Reclamo> readAll();
    void update(Reclamo reclamo);
}
