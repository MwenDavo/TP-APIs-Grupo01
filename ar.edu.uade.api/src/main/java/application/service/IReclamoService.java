package application.service;

import application.model.entity.General;
import application.model.entity.Localizado;
import application.model.entity.Log;
import application.model.entity.Reclamo;

import java.util.List;

public interface IReclamoService {
    void create(General reclamo);
    void create(Localizado reclamo);
    Reclamo read(long id);
    void update(long id, Log log);
}
