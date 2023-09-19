package app.model.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.query.Query;
import app.model.entity.Edificio;
import org.hibernate.Session;
import org.hibernate.Transaction;
import app.model.entity.Unidad;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class DaoEdificioMySQL implements DaoEdificio {
    @PersistenceContext
    private EntityManager entityManager;

    public DaoEdificioMySQL() {

    }

    @Override
    @Transactional(readOnly = true)
    public List<Edificio> readAll() {

        Session session = entityManager.unwrap(Session.class);

        Query<Edificio> query = session.createQuery("FROM Edificio", Edificio.class);

        return query.getResultList();
    }

    @Override
    @Transactional
    public void create(Edificio edificio) {

        Session session = entityManager.unwrap(Session.class);

        session.persist(edificio);
    }

    @Override
    @Transactional
    public void update(Edificio edificio) {

        Session session = entityManager.unwrap(Session.class);

        session.update(edificio);
    }

    @Override
    @Transactional
    public void updateUnidad(Unidad unidad) {

        Session session = entityManager.unwrap(Session.class);

        session.update(unidad);
    }
}
