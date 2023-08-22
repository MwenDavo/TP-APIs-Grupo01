package dao;

public class DaoReclamoMySQL {
    private static DaoReclamoMySQL instance = null;
    private DaoReclamoMySQL() {

    }
    public static DaoReclamoMySQL getInstance() {
        if (instance == null) {
            instance = new DaoReclamoMySQL();
        }
        return instance;
    }
}
