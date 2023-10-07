package application.service;

import application.model.entity.Edificio;
import application.model.entity.Unidad;
import application.model.entity.Usuario;

import java.util.List;

public interface IEdificioService {
    void create(Edificio edificio);
    Edificio read(Edificio edificio);
    Edificio readByDireccion(String direccion);
    List<Edificio> readAll(String usuario);

    Unidad readUnidad(long id);
}
