package application.service;

import application.model.entity.Foto;

public interface IFotoService {
    void create(Foto foto);
    Foto read(long id);
}
