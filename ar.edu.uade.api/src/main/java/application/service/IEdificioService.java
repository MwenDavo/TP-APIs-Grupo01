package application.service;

import application.model.entity.Edificio;

import java.util.List;

public interface IEdificioService {
    void create(Edificio edificio);
    Edificio read(long id);
    List<Edificio> readAll();
    void delete(Edificio edificio);

    void update(long id, Edificio edificio);
}
