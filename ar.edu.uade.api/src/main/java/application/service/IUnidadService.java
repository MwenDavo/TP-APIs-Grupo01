package application.service;

import application.model.entity.Edificio;
import application.model.entity.Unidad;

public interface IUnidadService {
    void create(Unidad unidad, Edificio edificio,String username);

    void delete(Unidad unidad, String username);
}
