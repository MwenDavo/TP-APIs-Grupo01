package application.model.dao;

import application.model.entity.Reclamo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    @Transactional(readOnly = true)
    public List<Reclamo> readAll() {
        Session session = entityManager.unwrap(Session.class);
        Query<Reclamo> query = session.createQuery("FROM Reclamo", Reclamo.class);
        return query.getResultList();
    }
}
