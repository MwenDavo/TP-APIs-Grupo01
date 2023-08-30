package app.model.entity;

import app.util.TipoUsuario;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private TipoUsuario tipoUsuario;
    @Column(unique = true, nullable = false)
    private int dni;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private int telefono;
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<UsuarioUnidad> unidades;

    @OneToMany
    private List<Reclamo> reclamos;

    public Usuario() {

    }

    public Usuario(TipoUsuario tipoUsuario, int dni, String nombre, int telefono, List<UsuarioUnidad> unidades, List<Reclamo> reclamos) {
        this.tipoUsuario = tipoUsuario;
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.unidades = unidades;
        this.reclamos = reclamos;
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
}
