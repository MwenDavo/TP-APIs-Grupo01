package application.service;

import application.model.entity.General;
import application.model.entity.Reclamo;

import java.util.List;

public interface IReclamoService {
    void create(Reclamo reclamo);
    Reclamo read(Reclamo reclamo);
    List<Reclamo> readByEstadoReclamo(Reclamo reclamo);
    List<General> readByEdificio(General general);
    List<Reclamo> readAll();
    void update(Reclamo reclamo);
}
