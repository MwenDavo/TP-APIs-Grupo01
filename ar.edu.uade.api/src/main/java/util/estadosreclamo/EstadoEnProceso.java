package util.estadosreclamo;

import pojo.Reclamo;

public class EstadoEnProceso extends EstadoReclamo {

    public EstadoEnProceso(Reclamo reclamo, String estado) {
        super(reclamo, estado);
    }

    public void Abierto() {

    }

    public void Anulado() {
        reclamo.setEstado(new EstadoAnulado(reclamo, "anulado"));
    }

    public void Desestimado() {

    }

    public void EnProceso() {

    }

    public void Nuevo() {

    }

    public void Terminado() {
        reclamo.setEstado(new EstadoTerminado(reclamo, "terminado"));
    }
}
