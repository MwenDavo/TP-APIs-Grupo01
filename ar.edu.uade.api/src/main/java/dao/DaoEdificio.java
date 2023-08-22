package dao;

import pojo.Edificio;

import java.util.List;

public interface DaoEdificio {

    List<Edificio> getAll();

    void save(Edificio edificio);

    void update(Edificio edificio);

    void delete(Edificio edificio);
}
