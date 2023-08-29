package app.model;

import javax.persistence.*;

@Entity
//credenciales
public class Credencial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String user;
    private String password;
    @Transient
    private static Credencial instance = null;

    private Credencial(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public static Credencial getInstance(String user, String password) {
        if (instance == null) {
            instance = new Credencial(user, password);
        }
        return instance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
