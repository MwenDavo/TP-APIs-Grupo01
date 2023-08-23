package dao;

public interface DaoCredencial {
    int getId(String user, String password);
    void save (String user, String password);
}
