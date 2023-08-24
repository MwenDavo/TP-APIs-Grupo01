package pojo;

import util.UsuarioUnidad;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "unidad")
public class Unidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Edificio edificio;
    private int piso;
    private int numero;
    @Embedded //TODO borrar anotacion si no se hacen States
    private EstadoUnidad estado;
    @OneToMany(mappedBy = "unidad")
    private List<UsuarioUnidad> usuarios;

    public Unidad() {

    }

    public Unidad(Edificio edificio, int piso, int numero, EstadoUnidad estado, List<UsuarioUnidad> usuarios) {
        this.edificio = edificio;
        this.piso = piso;
        this.numero = numero;
        this.estado = estado;
        this.usuarios = usuarios;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Edificio getEdificio() {
        return edificio;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public EstadoUnidad getEstado() {
        return estado;
    }

    public void setEstado(EstadoUnidad estado) {
        this.estado = estado;
    }

    public List<UsuarioUnidad> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<UsuarioUnidad> usuarios) {
        this.usuarios = usuarios;
    }
}
