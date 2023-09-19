package app.model.dao;

import app.conexion.ConexionMySQL;
import app.model.entity.Unidad;
import app.model.entity.UsuarioUnidad;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import app.model.entity.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class DaoUsuarioMySQL implements DaoUsuario {
    @PersistenceContext
    private EntityManager entityManager;

    public DaoUsuarioMySQL() {

    }

    @Override
    @Transactional
    public void create(Usuario usuario) {

        Session session = entityManager.unwrap(Session.class);

        Transaction transaction = session.beginTransaction();

        session.persist(usuario);

        transaction.commit();
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario read(Usuario usuario) {

        Session session = entityManager.unwrap(Session.class);

        Query<Usuario> query = session.createQuery("FROM Usuario WHERE user = :user AND password = :password");
        query.setParameter("user", usuario.getUser());
        query.setParameter("password", usuario.getPassword());

        return query.uniqueResult(); //TODO ver si funciona con Jakarta
    }

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> readAll() {

        Session session = entityManager.unwrap(Session.class);

        Query<Usuario> query = session.createQuery("FROM Usuario", Usuario.class);

        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Usuario usuario) {

        Session session = entityManager.unwrap(Session.class);

        usuario = session.find(Usuario.class, usuario.getId());

        Transaction transaction = session.beginTransaction();

        session.update(usuario);

        transaction.commit();
    }

    @Override
    @Transactional
    public void updateUnidades(Usuario usuario, Unidad unidad) {

        Session session = entityManager.unwrap(Session.class);

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
