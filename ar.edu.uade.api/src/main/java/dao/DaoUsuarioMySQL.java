package dao;

import conexion.ConexionMySQL;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Usuario;

import java.util.List;

public class DaoUsuarioMySQL implements DaoUsuario {
    private static DaoUsuarioMySQL instance = null;

    private DaoUsuarioMySQL() {

    }

    public static DaoUsuarioMySQL getInstance() {
        if (instance == null) {
            instance = new DaoUsuarioMySQL();
        }
        return instance;
    }

    @Override
    public void save(Usuario usuario) {
        ConexionMySQL connection = ConexionMySQL.getInstance();
        Session session = connection.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(usuario);
        transaction.commit();
    }

    @Override
    public void update(Usuario usuario) {
        ConexionMySQL connection = ConexionMySQL.getInstance();
        Session session = connection.getSession();
        Transaction transaction = session.beginTransaction();
        session.update(usuario);
        transaction.commit();
    }

    @Override
    public void delete(Usuario usuario) {
        ConexionMySQL connection = ConexionMySQL.getInstance();
        Session session = connection.getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(usuario);
        transaction.commit();
    }
}
