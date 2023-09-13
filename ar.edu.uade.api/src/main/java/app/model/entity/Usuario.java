package app.model.entity;

import app.util.EstadoUsuario;
import app.util.TipoUsuario;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private TipoUsuario tipoUsuario;
    @Column(length = 12, unique = true)
    private String user;
    private String password;
    @Column(unique = true, nullable = false)
    private int dni;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private int telefono;
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UsuarioUnidad> unidades = new ArrayList<>();
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Reclamo> reclamos = new ArrayList<>();
    @Column(nullable = false)
    private EstadoUsuario estadoUsuario = EstadoUsuario.DISPONIBLE;

    public Usuario() {

    }

    public Usuario(TipoUsuario tipoUsuario, String user, String password, int dni, String nombre, int telefono) {
        this.tipoUsuario = tipoUsuario;
        this.user = user;
        this.password = password;
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
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

    public EstadoUsuario getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(EstadoUsuario estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }
}
