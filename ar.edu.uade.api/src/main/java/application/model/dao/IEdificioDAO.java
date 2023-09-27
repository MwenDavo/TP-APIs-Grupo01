package application.model.dao;

import application.model.entity.Edificio;

import java.util.List;

public interface IEdificioDAO {
    void create(Edificio edificio);
    Edificio read(long id);
    Edificio readByDireccion(String direccion);
    List<Edificio> readAll();
}
