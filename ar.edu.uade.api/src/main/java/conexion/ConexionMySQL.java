package conexion;

import pojo.Edificio;
import pojo.Reclamo;
import pojo.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConexionMySQL {
    private Session session;

    private static ConexionMySQL instance = null;

    private ConexionMySQL() {
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(Edificio.class);
        configuration.addAnnotatedClass(Reclamo.class);
        configuration.addAnnotatedClass(Usuario.class);
        //TODO agregar las AnnotatedClass faltantes
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
