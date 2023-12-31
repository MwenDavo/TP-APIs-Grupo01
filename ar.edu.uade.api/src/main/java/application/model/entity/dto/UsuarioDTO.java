package application.model.entity.dto;

import application.model.entity.Unidad;
import application.model.util.TipoUsuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDTO {
    private long id;
    private String username;
    private String password;
    private int dni;
    private String nombre;
    private int telefono;
    private TipoUsuario tipoUsuario;
    private List<UnidadDTO> unidadesDTO = new ArrayList<>();

    public UsuarioDTO(){

    }

    public UsuarioDTO(String username, String password, int dni, String nombre, int telefono, TipoUsuario tipoUsuario) {
        this.username = username;
        this.password = password;
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.tipoUsuario = tipoUsuario;
    }

    public UsuarioDTO(long id, String nombre, int telefono, TipoUsuario tipoUsuario, List<UnidadDTO> unidadesDTO) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.tipoUsuario = tipoUsuario;
        this.unidadesDTO = unidadesDTO;
    }

    public UsuarioDTO(long id, String username, int dni, String nombre, int telefono, TipoUsuario tipoUsuario, List<UnidadDTO> unidadesDTO) {
        this.id = id;
        this.username = username;
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.tipoUsuario = tipoUsuario;
        this.unidadesDTO = unidadesDTO;
    }

    public UsuarioDTO(String username, String password){
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

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
