package util.estadosreclamo;

import pojo.Reclamo;

import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
public abstract class EstadoReclamo {
    protected Reclamo reclamo;
    protected String estado;

    public EstadoReclamo() {

    }

    public EstadoReclamo(Reclamo reclamo, String estado) {
        this.reclamo = reclamo;
        this.estado = estado;
    }

    public abstract void Abierto();

    public abstract void Anulado();

    public abstract void Desestimado();

    public abstract void EnProceso();

    public abstract void Nuevo();

    public abstract void Terminado();
}

