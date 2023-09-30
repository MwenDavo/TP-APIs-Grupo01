package application.model.dao;

import application.model.entity.Edificio;
import application.model.entity.General;
import application.model.entity.Localizado;
import application.model.entity.Reclamo;
import application.model.util.EstadoReclamo;

import java.util.List;

public interface IReclamoDAO {
    void create(General reclamo);
    void create(Localizado reclamo);
    General read(General reclamo);
    Localizado read(Localizado reclamo);
    void update(General reclamo);
    void update(Localizado reclamo);
}
