package dao;

import modelo.Edificio;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DaoEdificioMySQL implements DaoEdificio {
    private static DaoEdificioMySQL instance = null;

    private DaoEdificioMySQL() {

    }

    public static DaoEdificioMySQL getInstance() {
        if (instance == null) {
            instance = new DaoEdificioMySQL();
        }
        return instance;
    }

    @Override
    public List<Edificio> getAll() {
        return null;
    }

    @Override
    public void save(Edificio edificio) {

    }

    @Override
    public void update(Edificio edificio) {

    }

    @Override
    public void delete(Edificio edificio) {

    }
}
