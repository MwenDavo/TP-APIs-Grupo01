package app.model.dao;

import app.conexion.ConexionMySQL;
import app.model.entity.Unidad;
import app.model.entity.UsuarioUnidad;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import app.model.entity.Usuario;

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
    public void create(Usuario usuario) {
        ConexionMySQL connection = ConexionMySQL.getInstance();
        Session session = connection.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(usuario);
        transaction.commit();
    }

    @Override
    public Usuario read(Usuario usuario) {
        ConexionMySQL connection = ConexionMySQL.getInstance();
        Session session = connection.getSession();
        Query<Usuario> query = session.createQuery("FROM Usuario WHERE user = :user AND password = :password");
        query.setParameter("user", usuario.getUser());
        query.setParameter("password", usuario.getPassword());
        return query.uniqueResult();
    }

    @Override
    public List<Usuario> readAll() {
        ConexionMySQL connection = ConexionMySQL.getInstance();
        Session session = connection.getSession();
        Query<Usuario> query = session.createQuery("FROM Usuario", Usuario.class);
        return query.list();
    }

    @Override
    public void update(Usuario usuario) {
        ConexionMySQL connection = ConexionMySQL.getInstance();
        Session session = connection.getSession();
        usuario = session.find(Usuario.class, usuario.getId());
        Transaction transaction = session.beginTransaction();
        session.update(usuario);
        transaction.commit();
    }

    @Override
    public void updateUnidades(Usuario usuario, Unidad unidad) {
        ConexionMySQL connection = ConexionMySQL.getInstance();
        Session session = connection.getSession();
        usuario = session.find(Usuario.class, usuario.getId());
        Transaction transaction = session.beginTransaction();
        for (UsuarioUnidad u : usuario.getUnidades()) {
            if (u.getUnidad() == unidad) {
                usuario.getUnidades().remove(u);
                unidad.getUsuarios().remove(u);
                session.remove(u);
                break;
            }
        }
        session.update(usuario);
        transaction.commit();
    }
}
