package application.service;

import application.model.entity.General;
import application.model.entity.Localizado;
import application.model.entity.Log;
import application.model.entity.Reclamo;

import java.util.List;

public interface IReclamoService {
    void create(General reclamo);
    void create(Localizado reclamo);
    List<Reclamo> readByDescripcion(String desc);
    Localizado readLocalizado(long id);
    void updateGeneral(long id, Log log, String username);
    void updateLocalizado(long id, Log log,String username);
    General readGeneral(long id);
}
