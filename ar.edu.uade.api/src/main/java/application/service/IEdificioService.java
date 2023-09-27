package application.service;

import application.model.entity.Edificio;

import java.util.List;

public interface IEdificioService {
    void create(Edificio edificio);
    Edificio read(long id);
    List<Edificio> readAll();
}
