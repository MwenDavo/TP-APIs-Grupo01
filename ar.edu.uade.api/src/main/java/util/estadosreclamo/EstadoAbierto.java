package util.estadosreclamo;

import pojo.Reclamo;

public class EstadoAbierto extends EstadoReclamo{
    public EstadoAbierto(Reclamo reclamo){
        super(reclamo);
    }
    public void Abierto(){

    }
    public void Anulado(){

    }
    public void Desestimado(){
        reclamo.setEstado(new EstadoDesestimado(reclamo));
    }
    public void EnProceso(){
        reclamo.setEstado(new EstadoEnProceso(reclamo));
    }
    public void Nuevo(){

    }
    public void Terminado(){

    }
}
