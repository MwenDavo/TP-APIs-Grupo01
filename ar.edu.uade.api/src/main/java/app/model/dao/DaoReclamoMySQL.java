package app.model.dao;

import app.conexion.ConexionMySQL;
import app.model.entity.LogEstadoReclamo;
import app.util.EstadoReclamo;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import app.model.entity.Edificio;
import app.model.entity.Reclamo;
import app.model.entity.Usuario;

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

    public List<Reclamo> getByState(EstadoReclamo estado) {
        ConexionMySQL connection = ConexionMySQL.getInstance();
        Session session = connection.getSession();
        Query<Reclamo> query = session.createQuery("FROM Reclamo WHERE estado = :estado", Reclamo.class);
        query.setParameter("estado", estado);
        return query.list();
    }

    @Override
    public List<Reclamo> getAll() {
        ConexionMySQL connection = ConexionMySQL.getInstance();
        Session session = connection.getSession();
        Query<Reclamo> query = session.createQuery("FROM Reclamo", Reclamo.class);
        return query.list();
    }

    @Override
    public List<Reclamo> getByEdificio(Edificio edificio) {
        ConexionMySQL connection = ConexionMySQL.getInstance();
        Session session = connection.getSession();
        Query<Reclamo> query = session.createQuery("SELECT e.Reclamo FROM Edificio e JOIN e.Reclamo WHERE id = :id", Reclamo.class);
        query.setParameter("id", edificio.getId());
        return query.list();
    }

    @Override
    public List<Reclamo> getByUsuario(Usuario usuario) {
        ConexionMySQL connection = ConexionMySQL.getInstance();
        Session session = connection.getSession();
        Query<Reclamo> query = session.createQuery("SELECT u.Reclamo FROM Usuario u JOIN u.Reclamo WHERE id = :id", Reclamo.class);
        query.setParameter("id", usuario.getId());
        return query.list();
    }

    @Override
    public void save(Reclamo reclamo) {

        ConexionMySQL connection = ConexionMySQL.getInstance();
        Session session = connection.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(reclamo);
        transaction.commit();
    }

    @Override
    public void update(Reclamo reclamo, LogEstadoReclamo log) {
        ConexionMySQL connection = ConexionMySQL.getInstance();
        Session session = connection.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(log);
        session.update(reclamo);
        transaction.commit();
    }


    @Override
    public List<LogEstadoReclamo> getByReclamo(Reclamo reclamo){
        ConexionMySQL connection = ConexionMySQL.getInstance();
        Session session = connection.getSession();
        Query<LogEstadoReclamo> query = session.createQuery("SELECT r.LogEstadoReclamo FROM Reclamo r JOIN r.LogEstadoReclamo WHERE id = :id", LogEstadoReclamo.class);
        query.setParameter("id", reclamo.getId());
        return query.list();
    }
}
