package application.model.dao;

import application.model.entity.Edificio;
import application.model.entity.Unidad;
import application.model.entity.Usuario;
import application.model.entity.UsuarioUnidad;
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

        for (Unidad unidad : edificio.getUnidades()) {
            unidad.setEdificio(edificio);
        }
        session.persist(edificio);
    }
    @Override
    @Transactional
    public void createUnidad(Unidad unidad, Edificio edificio){
        Session session = entityManager.unwrap(Session.class);
        unidad.setEdificio(edificio);
        edificio.getUnidades().add(unidad);
        session.merge(edificio);
    }

    @Override
    @Transactional(readOnly = true)
    public Edificio read(long id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Edificio.class, id);
    }

    @Override
    @Transactional(readOnly = true)
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
    @Override
    @Transactional(readOnly = true)
    public List<Edificio> readAllComun(Usuario usuario){
        Session session = entityManager.unwrap(Session.class);
        Query<Edificio> query = session.createQuery("SELECT DISTINCT e FROM UsuarioUnidad uu JOIN uu.unidad u JOIN u.edificio e WHERE uu.usuario = :usuario", Edificio.class);
        query.setParameter("usuario",usuario);
        return query.getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Unidad readUnidad(long id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Unidad.class, id);
    }

    @Override
    @Transactional
    public void borrarRelacion(UsuarioUnidad usuarioUnidad){
        Session session = entityManager.unwrap(Session.class);
        session.remove(usuarioUnidad);
    }

    @Override
    @Transactional
    public void deleteUnidad(Unidad unidad) {
        Session session = entityManager.unwrap(Session.class);
        Edificio edificio = unidad.getEdificio();
        edificio.getUnidades().remove(unidad);
        unidad.setEdificio(null);
        session.merge(edificio);
        session.remove(unidad);
    }


}
