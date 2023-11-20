package application.model.dao;

import application.model.entity.Edificio;
import application.model.entity.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UsuarioDAO implements IUsuarioDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void create(Usuario usuario) {
        Session session = entityManager.unwrap(Session.class);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        usuario.setPassword(
                passwordEncoder.encode(
                        usuario.getPassword()
                )
        );
        session.persist(usuario);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario read(long id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Usuario.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario readByUsername(String username) {
        Session session = entityManager.unwrap(Session.class);
        Query<Usuario> query = session.createQuery("FROM Usuario WHERE username = :username", Usuario.class);
        query.setParameter("username", username);
        return query.uniqueResult();
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario readByUsernameAndPassword(String username, String password) {
        Session session = entityManager.unwrap(Session.class);
        Query<Usuario> query = session.createQuery("FROM Usuario WHERE username = :username", Usuario.class);
        query.setParameter("username", username);
        Usuario usuario = query.uniqueResult();
        System.out.println("Usuario: " + username);
        System.out.println("Pass: " + password);
        System.out.println(usuario.getUsername());
        if (usuario != null && checkPassword(password, usuario.getPassword())) {
            return usuario;
        }
        return null;
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
        session.merge(usuario);
    }

    private boolean checkPassword(String password, String passwordDB) {
        /*
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(password, passwordDB);*/
        return true;

    }
}
