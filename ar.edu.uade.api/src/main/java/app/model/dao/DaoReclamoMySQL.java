package app.model.dao;

import app.model.entity.*;
import app.util.EstadoReclamo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class DaoReclamoMySQL implements DaoReclamo {
    @PersistenceContext
    private EntityManager entityManager;

    public DaoReclamoMySQL() {

    }

    @Override
    @Transactional
    public void create(Reclamo reclamo) {

        Session session = entityManager.unwrap(Session.class);

        Transaction transaction = session.beginTransaction();

        session.persist(reclamo);

        transaction.commit();
    }
    @Override
    @Transactional(readOnly = true)
    public Reclamo read(int id) {

        Session session = entityManager.unwrap(Session.class);

        return session.get(Reclamo.class, id);
    }
    @Override
    @Transactional(readOnly = true)
    public List<Reclamo> readAll() {

        Session session = entityManager.unwrap(Session.class);

        Query<Reclamo> query = session.createQuery("FROM Reclamo", Reclamo.class);

        return query.getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Reclamo> readByEstadoReclamo(EstadoReclamo estado) {

        Session session = entityManager.unwrap(Session.class);

        Query<Reclamo> query = session.createQuery("FROM Reclamo WHERE estado = :estado", Reclamo.class);
        query.setParameter("estado", estado);

        return query.getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<General> readByEdificio(Edificio edificio) {

        Session session = entityManager.unwrap(Session.class);

        Query<General> query = session.createQuery("SELECT g FROM General g JOIN g.edificio e WHERE e.id = :id", General.class);
        query.setParameter("id", edificio.getId());

        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Reclamo reclamo, Log log) {

        Session session = entityManager.unwrap(Session.class);

        Transaction transaction = session.beginTransaction();

        session.save(log);
        session.update(reclamo);

        transaction.commit();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Log> readByReclamo(Reclamo reclamo) {

        Session session = entityManager.unwrap(Session.class);

        Query<Log> query = session.createQuery("SELECT l FROM Log l JOIN l.reclamo r WHERE r.id = :id", Log.class);
        query.setParameter("id", reclamo.getId());

        return query.getResultList();
    }
}


