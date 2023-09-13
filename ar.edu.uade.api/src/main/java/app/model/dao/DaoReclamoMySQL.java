package app.model.dao;

import app.conexion.ConexionMySQL;
import app.model.entity.*;
import app.util.EstadoReclamo;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
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
    public boolean create(Reclamo reclamo) {

        ConexionMySQL connection = ConexionMySQL.getInstance();
        Session session = connection.getSession();

        try {

            Transaction transaction = session.beginTransaction();
            session.save(reclamo);
            transaction.commit();
        } catch (Exception exception) {

            return false;
        }

        return true;
    }
    @Override
    public Reclamo read(int id) {

        ConexionMySQL connection = ConexionMySQL.getInstance();
        Session session = connection.getSession();

        return session.find(Reclamo.class, id);
    }
    @Override
    public List<Reclamo> readAll() {
        ConexionMySQL connection = ConexionMySQL.getInstance();
        Session session = connection.getSession();
        Query<Reclamo> query = session.createQuery("FROM Reclamo", Reclamo.class);
        return query.list();
    }

    @Override
    public List<Reclamo> readByEstadoReclamo(EstadoReclamo estado) {

        ConexionMySQL connection = ConexionMySQL.getInstance();
        Session session = connection.getSession();

        Query<Reclamo> query = session.createQuery("FROM Reclamo WHERE estado = :estado", Reclamo.class);
        query.setParameter("estado", estado);

        return query.list();
    }

    @Override
    public List<General> readByEdificio(Edificio edificio) {

        ConexionMySQL connection = ConexionMySQL.getInstance();
        Session session = connection.getSession();

        Query<General> query = session.createQuery("SELECT g FROM General g JOIN g.edificio e WHERE e.id = :id", General.class);
        query.setParameter("id", edificio.getId());

        return query.list();
    }

    @Override
    public boolean update(Reclamo reclamo, Log log) {

        ConexionMySQL connection = ConexionMySQL.getInstance();
        Session session = connection.getSession();

        try {

            Transaction transaction = session.beginTransaction();
            session.save(log);
            session.update(reclamo);
            transaction.commit();
        } catch (Exception exception) {

            return false;
        }

        return true;
    }

    @Override
    public List<Log> readByReclamo(Reclamo reclamo) {

        ConexionMySQL connection = ConexionMySQL.getInstance();
        Session session = connection.getSession();

        Query<Log> query = session.createQuery("SELECT l FROM Log l JOIN l.reclamo r WHERE r.id = :id", Log.class);
        query.setParameter("id", reclamo.getId());

        return query.list();
    }
}


