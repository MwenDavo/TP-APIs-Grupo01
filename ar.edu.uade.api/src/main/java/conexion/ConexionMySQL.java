package conexion;

public class ConexionMySQL {
    private static ConexionMySQL instance = null;
    private ConexionMySQL() {

    }
    public static ConexionMySQL getInstance() {
        if (instance == null) {
            instance = new ConexionMySQL();
        }
        return instance;
    }
}
