package application.model.entity;

import application.model.util.EstadoUsuario;
import application.model.util.TipoUsuario;
import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuarios")
@SQLDelete(sql = "UPDATE Usuario SET disponible = false WHERE id = ?") //TODO corregir service y DAO
@Where(clause = "disponible = true")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    private boolean disponible = true;
    @Column(name = "tipo_usuario")
    private TipoUsuario tipoUsuario; //TODO incluir autenticacion de permisos en la vista!
    @Column(nullable = false, unique = true)
    private int dni;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private int telefono;
    @OneToMany(mappedBy = "usuario")
    private List<UsuarioUnidad> unidades = new ArrayList<>();
    @OneToMany(mappedBy = "usuario")
    private List<Reclamo> reclamos = new ArrayList<>();

    public Usuario() {
    }

    public Usuario(String username, String password, TipoUsuario tipoUsuario, int dni, String nombre, int telefono) {
        this.username = username;
        this.password = password;
        this.tipoUsuario = tipoUsuario;
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public List<UsuarioUnidad> getUnidades() {
        return unidades;
    }

    public void setUnidades(List<UsuarioUnidad> unidades) {
        this.unidades = unidades;
    }

    public List<Reclamo> getReclamos() {
        return reclamos;
    }

    public void setReclamos(List<Reclamo> reclamos) {
        this.reclamos = reclamos;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean b) {
        disponible = b;
    }


}
