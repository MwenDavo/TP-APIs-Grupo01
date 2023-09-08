package app.model.dao;

import app.conexion.ConexionMySQL;
import app.model.entity.Unidad;
import app.model.entity.UsuarioUnidad;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import app.model.entity.Credencial;
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
    public Usuario get(Credencial credencial) {
        ConexionMySQL connection = ConexionMySQL.getInstance();
        Session session = connection.getSession();
        Query<Integer> query = session.createQuery("SELECT id FROM Credencial WHERE user = :user AND password = :password");
        query.setParameter("user", credencial.getUser());
        query.setParameter("password", credencial.getPassword());
        Integer result = query.uniqueResult();
        if (result != null) {
            return session.get(Usuario.class, (int) result);
        }
        return null;
    }

    @Override
    public List<Usuario> getAll() {
        ConexionMySQL connection = ConexionMySQL.getInstance();
        Session session = connection.getSession();
        Query<Usuario> query = session.createQuery("FROM Usuario", Usuario.class);
        return query.list();
    }

    @Override
    public void save(Credencial credencial, Usuario usuario) {
        ConexionMySQL connection = ConexionMySQL.getInstance();
        Session session = connection.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(credencial);
        session.save(usuario);
        transaction.commit();
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
    public void sacarUnidad(Usuario usuario, Unidad unidad) {
        ConexionMySQL connection = ConexionMySQL.getInstance();
        Session session = connection.getSession();
        usuario = session.find(Usuario.class, usuario.getId());
        Transaction transaction = session.beginTransaction();
        for (UsuarioUnidad u : usuario.getUnidades()) {
            if (u.getUnidad() == unidad) {
                session.remove(u);
                usuario.getUnidades().remove(u);
                break;
            }
        }
        session.update(usuario);
        transaction.commit();
    }

    @Override
    public void delete(Usuario usuario) {
        ConexionMySQL connection = ConexionMySQL.getInstance();
        Session session = connection.getSession();
        Credencial credencial = session.find(Credencial.class, usuario.getId());
        usuario = session.find(Usuario.class, usuario.getId());
        Transaction transaction = session.beginTransaction();
        session.remove(credencial);
        for (UsuarioUnidad u: usuario.getUnidades()) {
            session.remove(u);
        }
        usuario.getUnidades().clear();
        session.remove(usuario);
        transaction.commit();
    }
}
