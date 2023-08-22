package dao;

import conexion.ConexionMySQL;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Edificio;
import pojo.Reclamo;
import pojo.Usuario;

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
    public List<Reclamo> getByEdificio(Edificio edificio) {
        ConexionMySQL connection = ConexionMySQL.getInstance();
        Session session = connection.getSession();
        return null;
    }

    @Override
    public List<Reclamo> getByUsuario(Usuario usuario) {
        ConexionMySQL connection = ConexionMySQL.getInstance();
        Session session = connection.getSession();
        return null;
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
    public void update(Reclamo reclamo) {
        ConexionMySQL connection = ConexionMySQL.getInstance();
        Session session = connection.getSession();
        Transaction transaction = session.beginTransaction();
        session.update(reclamo);
        transaction.commit();
    }

    @Override
    public void delete(Reclamo reclamo) {
        ConexionMySQL connection = ConexionMySQL.getInstance();
        Session session = connection.getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(reclamo);
        transaction.commit();
    }
}
