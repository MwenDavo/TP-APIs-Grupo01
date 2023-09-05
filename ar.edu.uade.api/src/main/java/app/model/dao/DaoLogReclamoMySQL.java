package app.model.dao;

import app.conexion.ConexionMySQL;
import app.model.entity.LogEstadoReclamo;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import app.model.entity.Reclamo;

import java.util.List;


public class DaoLogReclamoMySQL implements DaoLogReclamo{

    private static DaoLogReclamoMySQL instance = null;

    private DaoLogReclamoMySQL(){

    }
    public static DaoLogReclamoMySQL getInstance() {
        if(instance == null){
            instance = new DaoLogReclamoMySQL();
        }
        return instance;
    }

    public void saveLogEstadoReclamo(LogEstadoReclamo log) {
        ConexionMySQL connection = ConexionMySQL.getInstance();
        Session session = connection.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(log);
        transaction.commit();
    }

    public List<Reclamo> getByReclamo(Reclamo reclamo) {
        ConexionMySQL connection = ConexionMySQL.getInstance();
        Session session = connection.getSession();
        Query<LogEstadoReclamo> query = session.createQuery("FROM LogEstadoReclamo WHERE reclamo = :reclamo", LogEstadoReclamo.class);
        query.setParameter("reclamo", reclamo);
        return query.list();
    }
}
