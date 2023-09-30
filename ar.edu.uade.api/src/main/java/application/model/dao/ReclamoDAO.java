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
    public General read(General reclamo) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(General.class, reclamo.getId());
    }

    @Transactional(readOnly = true)
    public Localizado read(Localizado reclamo) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Localizado.class, reclamo.getId());
    }

    @Deprecated
    @Transactional(readOnly = true)
    public List<Reclamo> readByEstadoReclamo(EstadoReclamo estadoReclamo) {
        Session session = entityManager.unwrap(Session.class);
        Query<Reclamo> query = session.createQuery("FROM Reclamo WHERE estado_reclamo = :estado_reclamo", Reclamo.class);
        query.setParameter("estado_reclamo", estadoReclamo);
        return query.getResultList();
    }

    @Deprecated
    @Transactional(readOnly = true)
    public List<Reclamo> readAll() {
        Session session = entityManager.unwrap(Session.class);
        Query<Reclamo> query = session.createQuery("FROM Reclamo", Reclamo.class);
        return query.getResultList();
    }


    @Transactional
    public void update(General reclamo) {
        Session session = entityManager.unwrap(Session.class);
        session.merge(reclamo);
        session.persist(
                new Log(
                    reclamo.getEstadoReclamo(),
                    reclamo.getDescripcion(),
                    reclamo
                )
        );
    }

    public void update(Localizado reclamo) {
        Session session = entityManager.unwrap(Session.class);
        session.merge(reclamo);
        session.persist(
                new Log(
                        reclamo.getEstadoReclamo(),
                        reclamo.getDescripcion(),
                        reclamo
                )
        );
    }
}
