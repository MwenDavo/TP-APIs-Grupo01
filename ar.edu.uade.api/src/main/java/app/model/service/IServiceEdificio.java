package app.model.service;

import app.model.entity.Edificio;

import java.util.List;

public interface IServiceEdificio {

    void create(Edificio edificio);

    List<Edificio> readAll();
}
