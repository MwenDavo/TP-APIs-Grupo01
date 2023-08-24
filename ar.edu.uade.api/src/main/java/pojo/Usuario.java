package pojo;

import util.TipoUsuario;
import util.UsuarioUnidad;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private TipoUsuario tipoUsuario;
    private int dni;
    private String nombre;
    private String telefono;
    @OneToMany(mappedBy = "usuario")
    private List<UsuarioUnidad> unidades;

    public Usuario() {

    }

    public Usuario(TipoUsuario tipoUsuario, int dni, String nombre, String telefono, List<UsuarioUnidad> unidades) {
        this.tipoUsuario = tipoUsuario;
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.unidades = unidades;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<UsuarioUnidad> getUnidades() {
        return unidades;
    }

    public void setUnidades(List<UsuarioUnidad> unidades) {
        this.unidades = unidades;
    }
}
