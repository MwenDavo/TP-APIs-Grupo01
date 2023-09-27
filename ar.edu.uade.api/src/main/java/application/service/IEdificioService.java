package application.service;

import application.model.entity.Edificio;

import java.util.List;

public interface IEdificioService {
    void create(Edificio edificio);
    Edificio read(Edificio edificio);
    Edificio readByDireccion(Edificio edificio);
    List<Edificio> readAll();
}
