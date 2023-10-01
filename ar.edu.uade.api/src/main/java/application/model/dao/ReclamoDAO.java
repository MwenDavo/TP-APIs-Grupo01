package application.model.dao;

import application.model.entity.*;
import application.model.util.EstadoReclamo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ReclamoDAO implements IReclamoDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void create(General reclamo) {
        Session session = entityManager.unwrap(Session.class);
        session.persist(reclamo);
    }

    @Transactional
    public void create(Localizado reclamo) {
        Session session = entityManager.unwrap(Session.class);
        session.persist(reclamo);
    }

    @Transactional(readOnly = true)
    public Reclamo read(long id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Reclamo.class, id);
    }

    @Transactional
    public void update(Reclamo reclamo) {
        Session session = entityManager.unwrap(Session.class);
        session.merge(reclamo);
    }
}
