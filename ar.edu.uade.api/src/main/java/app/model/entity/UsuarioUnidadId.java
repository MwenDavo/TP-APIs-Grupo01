package app.model.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UsuarioUnidadId implements Serializable {
    @Column(name = "usuario_id")
    private int usuarioId;
    @Column(name = "unidad_id")
    private int unidadId;

    public UsuarioUnidadId() {

    }

    public UsuarioUnidadId(int usuarioId, int unidadId) {
        this.usuarioId = usuarioId;
        this.unidadId = unidadId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getUnidadId() {
        return unidadId;
    }

    public void setUnidadId(int unidadId) {
        this.unidadId = unidadId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuarioId, unidadId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()){
            return false;
        }

        UsuarioUnidadId that = (UsuarioUnidadId) obj;
        return Objects.equals(usuarioId, that.usuarioId) && Objects.equals(unidadId, that.unidadId);
    }
}
