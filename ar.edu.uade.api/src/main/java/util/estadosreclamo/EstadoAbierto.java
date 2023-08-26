package util.estadosreclamo;

import pojo.Reclamo;

public class EstadoAbierto extends EstadoReclamo {

    public EstadoAbierto(Reclamo reclamo, String estado) {
        super(reclamo, estado);
    }

    public void Abierto() {

    }

    public void Anulado() {

    }

    public void Desestimado() {
        reclamo.setEstado(new EstadoDesestimado(reclamo, "desestimado"));
    }

    public void EnProceso() {
        reclamo.setEstado(new EstadoEnProceso(reclamo, "en proceso"));
    }

    public void Nuevo() {

    }

    public void Terminado() {

    }
}
