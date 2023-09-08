package app.model.dao;

import app.model.entity.Edificio;
import app.model.entity.Unidad;
import app.model.entity.Usuario;

import java.util.List;

public interface DaoEdificio {

    List<Edificio> getAll();

    void save(Edificio edificio);

    void update(Edificio edificio);

    void updateDpto(Unidad unidad);

    void sacarUsuarioDpto(Unidad unidad, Usuario usuario);
}
