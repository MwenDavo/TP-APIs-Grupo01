package app.model.dao;

import app.conexion.ConexionMySQL;
import app.model.entity.Usuario;
import app.model.entity.UsuarioUnidad;
import org.hibernate.query.Query;
import app.model.entity.Edificio;
import org.hibernate.Session;
import org.hibernate.Transaction;
import app.model.entity.Unidad;

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
    public List<Edificio> readAll() {
        ConexionMySQL connection = ConexionMySQL.getInstance();
        Session session = connection.getSession();
        Query<Edificio> query = session.createQuery("FROM Edificio", Edificio.class);
        return query.list();
    }

    @Override
    public void create(Edificio edificio) {
        ConexionMySQL connection = ConexionMySQL.getInstance();
        Session session = connection.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(edificio);
        transaction.commit();
    }

    @Override
    public Edificio read() {
        return null;
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
    public void updateUnidad(Unidad unidad) {
        ConexionMySQL connection = ConexionMySQL.getInstance();
        Session session = connection.getSession();
        Transaction transaction = session.beginTransaction();
        session.update(unidad);
        transaction.commit();
    }
}
