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
        /*for (Foto f:
                reclamo.getFotos()) {
            f.setReclamo(reclamo);
        }*/
        session.persist(reclamo);
    }

    @Transactional
    public void create(Localizado reclamo) {
        Session session = entityManager.unwrap(Session.class);
        /*for (Foto f:
             reclamo.getFotos()) {
            f.setReclamo(reclamo);
        }*/
        session.persist(reclamo);
    }

    @Override
    @Transactional(readOnly = true)
    public General readGeneral(long id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(General.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    public Localizado readLocalizado(long id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Localizado.class, id);
    }

    @Override
    public void updateLocalizado(Localizado reclamo) {
        Session session = entityManager.unwrap(Session.class);
        session.merge(reclamo);
    }


    @Transactional
    public void updateGeneral(General reclamo) {
        Session session = entityManager.unwrap(Session.class);
        session.merge(reclamo);
    }
}
