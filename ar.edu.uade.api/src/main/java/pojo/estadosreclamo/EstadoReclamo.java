package pojo.estadosreclamo;

import pojo.Reclamo;

//TODO definir funcionamiento de cada estado para agregarselo
public abstract class EstadoReclamo {
    protected Reclamo reclamo;

    public EstadoReclamo(Reclamo reclamo) {
        this.reclamo = reclamo;
    }

    public abstract void Abierto();

    public abstract void Anulado();

    public abstract void Desestimado();

    public abstract void EnProceso();

    public abstract void Nuevo();

    public abstract void Terminado();
}

