package dao;

import com.sun.org.apache.xpath.internal.operations.Bool;
import conexion.ConexionMySQL;
import controller.ControllerCredencial;
import org.hibernate.Session;
import org.hibernate.Transaction;
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
        return -1;
    }

    public void save(String user, String password) {
        ConexionMySQL connection = ConexionMySQL.getInstance();
        Session session = connection.getSession();
        Transaction transaction = session.beginTransaction();
        String sql = "INSERT INTO Credencial (id, user, password) VALUES (':id', ':user', ':password')";
        Query query = session.createSQLQuery(sql);
        query.setParameter("id", "id");
        query.setParameter("user", "user");
        query.setParameter("password", "password");
        query.executeUpdate();
        transaction.commit();
    }
}
