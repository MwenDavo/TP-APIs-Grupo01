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

    @Override
    @Transactional
    public void create(Reclamo reclamo) {
        Session session = entityManager.unwrap(Session.class);
        session.persist(reclamo);
    }

    @Override
    @Transactional(readOnly = true)
    public Reclamo read(long id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Reclamo.class, id);
    }

    @Override
    public List<Reclamo> readByEstadoReclamo(EstadoReclamo estadoReclamo) {
        Session session = entityManager.unwrap(Session.class);
        Query<Reclamo> query = session.createQuery("FROM Reclamo WHERE estado_reclamo = :estado_reclamo", Reclamo.class);
        query.setParameter("estado_reclamo", estadoReclamo);
        return query.getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Reclamo> readAll() {
        Session session = entityManager.unwrap(Session.class);
        Query<Reclamo> query = session.createQuery("FROM Reclamo", Reclamo.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Reclamo reclamo) {
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
