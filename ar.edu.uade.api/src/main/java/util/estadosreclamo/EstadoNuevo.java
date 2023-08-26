package util.estadosreclamo;

import pojo.Reclamo;

public class EstadoNuevo extends EstadoReclamo {

    public EstadoNuevo(Reclamo reclamo, String estado) {
        super(reclamo, estado);
    }

    public void Abierto() {
        reclamo.setEstado(new EstadoAbierto(reclamo, "abierto"));

    }

    public void Anulado() {

    }

    public void Desestimado() {

    }

    public void EnProceso() {

    }

    public void Nuevo() {

    }

    public void Terminado() {

    }
}
