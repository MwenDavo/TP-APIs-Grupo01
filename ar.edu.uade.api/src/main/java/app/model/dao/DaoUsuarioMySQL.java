package app.model.dao;

import app.conexion.ConexionMySQL;
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
        Transaction transaction = session.beginTransaction();
        session.update(usuario);
        transaction.commit();
    }

    @Override
    public void delete(Usuario usuario) {
        ConexionMySQL connection = ConexionMySQL.getInstance();
        Session session = connection.getSession();
        Credencial credencial = session.get(Credencial.class, usuario.getId());
        Transaction transaction = session.beginTransaction();
        session.delete(credencial);
        List<UsuarioUnidad> lista = usuario.getUnidades();
        for (UsuarioUnidad u:
             lista) {
            //u.getUsuario().getUnidades().remove(u);
            u.setUsuario(null);
            u.getUnidad().getUsuarios().remove(u);
            u.setUnidad(null);
        }
        session.delete(usuario);
        transaction.commit();
    }

}
