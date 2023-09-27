package application.service;

import application.model.entity.Reclamo;

import java.util.List;

public interface IReclamoService {
    void create(Reclamo reclamo);

    Reclamo read(long id);

    List<Reclamo> readAll();

}
