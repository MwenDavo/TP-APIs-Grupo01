package application.service;

import application.model.entity.General;
import application.model.entity.Localizado;
import application.model.entity.Reclamo;

import java.util.List;

public interface IReclamoService {
    void create(General reclamo);
    void create(Localizado reclamo);
    General read(General reclamo);
    Localizado read(Localizado reclamo);
    void update(General reclamo);
    void update(Localizado reclamo);
}
