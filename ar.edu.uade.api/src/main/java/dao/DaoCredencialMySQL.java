package dao;

import com.sun.org.apache.xpath.internal.operations.Bool;
import conexion.ConexionMySQL;
import controller.ControllerCredencial;
import org.hibernate.Session;
import org.hibernate.query.Query;
import pojo.Reclamo;

public class DaoCredencialMySQL implements DaoCredencial {
    private static DaoCredencialMySQL instance = null;

    private DaoCredencialMySQL() {

    }

    public static DaoCredencialMySQL getInstance() {
        if (instance == null) {
            instance = new DaoCredencialMySQL();
        }
        return instance;
    }

    @Override
    public int getId(String user, String password) {
        ConexionMySQL connection = ConexionMySQL.getInstance();
        Session session = connection.getSession();
        Query<Integer> query = session.createQuery("SELECT id FROM Credencial WHERE user = ':user' AND password = ':password'");
        query.setParameter("user", user);
        query.setParameter("password", password);
        Integer result = query.uniqueResult();
        if (result != null) {
            return (int) result;
        }
        return 0;
        //TODO confirmar que auto increment no comienza en 0
    }
}
