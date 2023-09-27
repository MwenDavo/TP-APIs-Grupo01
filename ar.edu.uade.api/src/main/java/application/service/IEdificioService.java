package application.service;

import application.model.entity.Edificio;
import application.model.entity.Usuario;

import java.util.List;

public interface IEdificioService {
    void create(Edificio edificio);
    Edificio read(Edificio edificio);
    Edificio readByDireccion(Edificio edificio);
    List<Edificio> readAll(Usuario usuario);
}
