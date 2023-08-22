package dao;

public class DaoUsuarioMySQL {
    private static DaoUsuarioMySQL instance = null;
    private DaoUsuarioMySQL() {

    }
    public static DaoUsuarioMySQL getInstance() {
        if (instance == null) {
            instance = new DaoUsuarioMySQL();
        }
        return instance;
    }
}
