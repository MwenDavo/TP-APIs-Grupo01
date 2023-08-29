package app.conexion;

import app.model.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConexionMySQL {
    private Session session;

    private static ConexionMySQL instance = null;

    private ConexionMySQL() {
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(Credencial.class);
        configuration.addAnnotatedClass(Edificio.class);
        configuration.addAnnotatedClass(Foto.class);
        configuration.addAnnotatedClass(Reclamo.class);
        configuration.addAnnotatedClass(Unidad.class);
        configuration.addAnnotatedClass(Usuario.class);
        configuration.addAnnotatedClass(UsuarioUnidad.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.openSession();
    }

    public static ConexionMySQL getInstance() {
        if (instance == null) {
            instance = new ConexionMySQL();
        }
        return instance;
    }

    public Session getSession() {
        return session;
    }
}
