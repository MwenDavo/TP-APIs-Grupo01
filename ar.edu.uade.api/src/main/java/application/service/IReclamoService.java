package application.service;

import application.model.entity.*;
import jakarta.transaction.Transactional;

import java.util.List;

public interface IReclamoService {
    void create(General reclamo);
    void create(Localizado reclamo);
    List<Reclamo> readByDescripcion(String desc);
    Localizado readLocalizado(long id);
    void updateGeneral(long id, Log log, String username);
    void updateLocalizado(long id, Log log,String username);
    General readGeneral(long id);
    void cargarFotoGeneral(long id, Foto foto);
    void cargarFotoLocalizado(long id, Foto foto);
}
