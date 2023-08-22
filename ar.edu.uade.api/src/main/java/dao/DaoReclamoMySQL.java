package dao;

import modelo.Reclamo;

import java.util.List;

public class DaoReclamoMySQL implements DaoReclamo {
    private static DaoReclamoMySQL instance = null;

    private DaoReclamoMySQL() {

    }

    public static DaoReclamoMySQL getInstance() {
        if (instance == null) {
            instance = new DaoReclamoMySQL();
        }
        return instance;
    }

    @Override
    public List<Reclamo> getAll() {
        return null;
    }

    @Override
    public void save(Reclamo reclamo) {

    }

    @Override
    public void update(Reclamo reclamo) {

    }

    @Override
    public void delete(Reclamo reclamo) {

    }
}
