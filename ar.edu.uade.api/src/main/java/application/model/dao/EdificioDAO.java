package application.model.dao;

import application.model.entity.Edificio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EdificioDAO implements IEdificioDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void create(Edificio edificio) {
        Session session = entityManager.unwrap(Session.class);
        session.persist(edificio);
    }

    @Override
    @Transactional(readOnly = true)
    public Edificio read(long id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Edificio.class, id);
    }

    @Override
    public Edificio readByDireccion(String direccion) {
        Session session = entityManager.unwrap(Session.class);
        Query<Edificio> query = session.createQuery("FROM Edificio WHERE direccion = :direccion", Edificio.class);
        query.setParameter("direccion", direccion);
        return query.uniqueResult();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Edificio> readAll() {
        Session session = entityManager.unwrap(Session.class);
        Query<Edificio> query = session.createQuery("FROM Edificio", Edificio.class);
        return query.getResultList();
    }
}
