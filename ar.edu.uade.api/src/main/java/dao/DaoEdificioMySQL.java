package dao;

public class DaoEdificioMySQL {
    private static DaoEdificioMySQL instance = null;
    private DaoEdificioMySQL() {

    }
    public static DaoEdificioMySQL getInstance() {
        if (instance == null) {
            instance = new DaoEdificioMySQL();
        }
        return instance;
    }
}
