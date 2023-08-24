package util;

import pojo.Unidad;
import pojo.Usuario;

import javax.persistence.*;

@Entity
@Table(name = "usuario_unidad")
public class UsuarioUnidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private TipoRelacion tipoRelacion;
    @ManyToOne
    private Usuario usuario;
    @ManyToOne
    private Unidad unidad;

    public UsuarioUnidad() {

    }

    public UsuarioUnidad(TipoRelacion tipoRelacion, Usuario usuario, Unidad unidad) {
        this.tipoRelacion = tipoRelacion;
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
        return tipoRelacion;
    }

    public void setRelacion(TipoRelacion relacion) {
        this.tipoRelacion = relacion;
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
