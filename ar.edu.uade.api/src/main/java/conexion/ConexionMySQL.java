package conexion;

import dao.DaoEdificioMySQL;
import modelo.Edificio;
import modelo.Reclamo;
import modelo.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConexionMySQL {
    private Session session;

    private static ConexionMySQL instance = null;

    private ConexionMySQL() {
        Configuration configuration = new Configuration().configure();
        //TODO agregar todas las AnnotatedClass necesarias
        configuration.addAnnotatedClass(Edificio.class);
        configuration.addAnnotatedClass(Reclamo.class);
        configuration.addAnnotatedClass(Usuario.class);
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
