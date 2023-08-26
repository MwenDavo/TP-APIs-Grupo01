package util.estadosunidad;

import pojo.Reclamo;
import pojo.Unidad;

import javax.persistence.Embeddable;

@Embeddable
public abstract class EstadoUnidad {
    protected Unidad unidad;

    public EstadoUnidad() {

    }

    public EstadoUnidad(Unidad unidad) {
        this.unidad = unidad;
    }

    public abstract void Habitado();

    public abstract void Deshabitado();

    public abstract void Alquilado();
}
