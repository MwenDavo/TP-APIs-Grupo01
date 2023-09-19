package app.model.dao;

import app.model.entity.Edificio;
import app.model.entity.Unidad;
import app.model.entity.Usuario;

import java.util.List;

public interface DaoEdificio {

    void create(Edificio edificio);

    List<Edificio> readAll();

    @Deprecated
    void update(Edificio edificio);

    @Deprecated
    void updateUnidad(Unidad unidad);
}
