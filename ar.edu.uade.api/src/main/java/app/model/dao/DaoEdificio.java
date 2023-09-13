package app.model.dao;

import app.model.entity.Edificio;
import app.model.entity.Unidad;
import app.model.entity.Usuario;

import java.util.List;

public interface DaoEdificio {

    void create(Edificio edificio);

    Edificio read();

    List<Edificio> readAll();

    void update(Edificio edificio);

    void updateUnidad(Unidad unidad);
}
