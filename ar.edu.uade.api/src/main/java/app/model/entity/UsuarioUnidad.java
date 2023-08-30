package app.model.entity;

import app.util.TipoRelacion;

import javax.persistence.*;

@Entity
@Table(name = "usuarios_unidades")
public class UsuarioUnidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private TipoRelacion relacion;
    @ManyToOne
    @JoinColumn(name = "unidades")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "usuarios")
    private Unidad unidad;

    public UsuarioUnidad() {

    }

    public UsuarioUnidad(TipoRelacion tipoRelacion, Usuario usuario, Unidad unidad) {
        this.relacion = tipoRelacion;
        this.usuario = usuario;
        this.unidad = unidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoRelacion getRelacion() {
        return relacion;
    }

    public void setRelacion(TipoRelacion relacion) {
        this.relacion = relacion;
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
}
