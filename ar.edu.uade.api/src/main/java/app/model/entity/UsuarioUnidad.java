package app.model.entity;

import app.util.TipoRelacion;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "usuarios_unidades")
public class UsuarioUnidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Usuario usuario;
    @ManyToOne
    private Unidad unidad;
    @Column(nullable = false)
    private TipoRelacion relacion;

    public UsuarioUnidad() {

    }

    public UsuarioUnidad(Usuario usuario, Unidad unidad, TipoRelacion relacion) {
        this.usuario = usuario;
        this.unidad = unidad;
        this.relacion = relacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }

    public TipoRelacion getRelacion() {
        return relacion;
    }

    public void setRelacion(TipoRelacion relacion) {
        this.relacion = relacion;
    }
}