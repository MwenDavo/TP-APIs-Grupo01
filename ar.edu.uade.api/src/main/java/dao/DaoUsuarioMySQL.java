package dao;

import conexion.ConexionMySQL;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pojo.Edificio;
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

    public Usuario get(int id) {
        ConexionMySQL connection = ConexionMySQL.getInstance();
        Session session = connection.getSession();
        return session.get(Usuario.class, id);
    }

    @Override
    public List<Usuario> getAll() {
        ConexionMySQL connection = ConexionMySQL.getInstance();
        Session session = connection.getSession();
        Query<Usuario> query = session.createQuery("FROM Usuario", Usuario.class);
        return query.list();
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
