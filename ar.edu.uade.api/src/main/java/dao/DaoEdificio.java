package dao;

import modelo.Edificio;

public interface DaoEdificio {
    List<Edificio> getAll();
    void save(Edificio edificio);
    void update(Edificio edificio);
    void delete(Edificio edificio);
}
