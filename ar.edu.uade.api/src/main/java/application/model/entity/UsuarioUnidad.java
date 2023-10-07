package application.model.entity;

import application.model.util.TipoRelacion;
import jakarta.persistence.*;

@Entity
@Table(name = "usuarios_unidades")
public class UsuarioUnidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Usuario usuario;
    @ManyToOne
    private Unidad unidad;

    //TODO REGRESAR @COLUMN(NULLABLE = FALSE)
    @Column(name = "tipo_relacion", nullable = false)
    private TipoRelacion tipoRelacion;

    public UsuarioUnidad() {
    }

    public UsuarioUnidad(Usuario usuario, Unidad unidad, TipoRelacion tipoRelacion) {
        this.usuario = usuario;
        this.unidad = unidad;
        this.tipoRelacion = tipoRelacion;
    }

    public UsuarioUnidad(Usuario usuario, Unidad unidad) {
        this.usuario = usuario;
        this.unidad = unidad;
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

    public TipoRelacion getTipoRelacion() {
        return tipoRelacion;
    }

    public void setTipoRelacion(TipoRelacion tipoRelacion) {
        this.tipoRelacion = tipoRelacion;
    }
}
