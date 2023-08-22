package dao;

import modelo.Reclamo;

import java.util.List;

public interface DaoReclamo {
    List<Reclamo> getAll();
    void save(Reclamo reclamo);
    void update(Reclamo reclamo);
    void delete(Reclamo reclamo);
}
