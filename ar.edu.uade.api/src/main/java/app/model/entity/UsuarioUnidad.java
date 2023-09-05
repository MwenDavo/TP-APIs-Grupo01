package app.model.entity;

import app.util.TipoRelacion;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "usuarios_unidades")
public class UsuarioUnidad {
    @EmbeddedId
    private UsuarioUnidadId id;
    @ManyToOne
    @MapsId("usuarioId")
    private Usuario usuario;
    @ManyToOne
    @MapsId("unidadId")
    private Unidad unidad;
    private TipoRelacion relacion;

    public UsuarioUnidad() {

    }

    public UsuarioUnidad(Usuario usuario, Unidad unidad, TipoRelacion relacion) {
        this.usuario = usuario;
        this.unidad = unidad;
        this.relacion = relacion;
    }

    public UsuarioUnidadId getId() {
        return id;
    }

    public void setId(UsuarioUnidadId id) {
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

    @Override
    public int hashCode() {
        return Objects.hash(usuario, unidad);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        UsuarioUnidad that = (UsuarioUnidad) obj;
        return Objects.equals(usuario, that.usuario) && Objects.equals(unidad, that.unidad);
    }
}