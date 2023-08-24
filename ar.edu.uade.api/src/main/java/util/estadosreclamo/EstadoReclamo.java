package util.estadosreclamo;

import pojo.Reclamo;

import javax.persistence.Embeddable;
import javax.persistence.Transient;

//TODO definir funcionamiento de cada estado para agregarselo
@Embeddable
public abstract class EstadoReclamo {
    protected String tipo;
    protected Reclamo reclamo;

    public EstadoReclamo() {

    }

    public EstadoReclamo(Reclamo reclamo, String tipo) {
        this.reclamo = reclamo;
        this.tipo = tipo;
    }

    public abstract void Abierto();

    public abstract void Anulado();

    public abstract void Desestimado();

    public abstract void EnProceso();

    public abstract void Nuevo();

    public abstract void Terminado();
}

