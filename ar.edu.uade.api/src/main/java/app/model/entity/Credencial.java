package app.model.entity;

import javax.persistence.*; //Reemplazar por Jakarta

@Entity
@Table(name = "credenciales")
public class Credencial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 12, unique = true, nullable = false)
    private String user;
    @Column(nullable = false)
    private String password;

    public Credencial() {

    }

    public Credencial(String user, String password) {
        this.user = user;
        this.password = password;
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
