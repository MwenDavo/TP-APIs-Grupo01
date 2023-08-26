package util.estadosreclamo;

import pojo.Reclamo;

public class EstadoNuevo extends EstadoReclamo{
    public EstadoNuevo(Reclamo reclamo){
        super(reclamo);
    }
    public void Abierto(){
        reclamo.setEstado(new EstadoAbierto(reclamo));

    }
    public void Anulado(){

    }
    public void Desestimado(){

    }
    public void EnProceso(){

    }
    public void Nuevo(){

    }
    public void Terminado(){

    }
}
