package dao;

import conexion.ConexionMySQL;
import org.hibernate.query.Query;
import app.model.Edificio;
import org.hibernate.Session;
import org.hibernate.Transaction;
import app.model.Unidad;

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
        ConexionMySQL connection = ConexionMySQL.getInstance();
        Session session = connection.getSession();
        Query<Edificio> query = session.createQuery("FROM Edificio", Edificio.class);
        return query.list();
    }

    @Override
    public void save(Edificio edificio) {
        ConexionMySQL connection = ConexionMySQL.getInstance();
        Session session = connection.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(edificio);
        transaction.commit();
    }

    @Override
    public void update(Edificio edificio) {
        ConexionMySQL connection = ConexionMySQL.getInstance();
        Session session = connection.getSession();
        Transaction transaction = session.beginTransaction();
        session.update(edificio);
        transaction.commit();
    }

    @Override
    public void updateDpto(Unidad unidad) {
        ConexionMySQL connection = ConexionMySQL.getInstance();
        Session session = connection.getSession();
        Transaction transaction = session.beginTransaction();
        session.update(unidad);
        transaction.commit();
    }

    @Override
    public void delete(Edificio edificio) {
        ConexionMySQL connection = ConexionMySQL.getInstance();
        Session session = connection.getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(edificio);
        transaction.commit();
    }
}
