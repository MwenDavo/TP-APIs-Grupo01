package dao;

import pojo.Edificio;
import pojo.Unidad;

import java.util.List;

public interface DaoEdificio {

    List<Edificio> getAll();

    void save(Edificio edificio);

    void update(Edificio edificio);

    void updateDpto(Unidad unidad);

    void delete(Edificio edificio);
}
