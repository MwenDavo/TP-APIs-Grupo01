package conexion;

import pojo.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import util.UsuarioUnidad;
import util.estadounidad.EstadoUnidad;

public class ConexionMySQL {
    private Session session;

    private static ConexionMySQL instance = null;

    private ConexionMySQL() {
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(Edificio.class);
        configuration.addAnnotatedClass(Reclamo.class);
        configuration.addAnnotatedClass(Usuario.class);
        configuration.addAnnotatedClass(Foto.class);
        configuration.addAnnotatedClass(Unidad.class);
        configuration.addAnnotatedClass(UsuarioUnidad.class);
        configuration.addAnnotatedClass(EstadoUnidad.class);
        configuration.addAnnotatedClass(Credencial.class);
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
