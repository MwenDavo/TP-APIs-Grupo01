package util.estadosreclamo;

import pojo.Reclamo;

public class EstadoDesestimado extends EstadoReclamo{
    public EstadoDesestimado(Reclamo reclamo){
        super(reclamo, "desestimado");
    }
    public void Abierto(){
        System.out.println("El reclamo fue Desestimado");
    }
    public void Anulado(){
        System.out.println("El reclamo fue Desestimado");
    }
    public void Desestimado(){
        System.out.println("El reclamo ya estaba Desestimado");
    }
    public void EnProceso(){
        System.out.println("El reclamo fue Desestimado");
    }
    public void Nuevo(){
        System.out.println("El reclamo fue Desestimado");
    }
    public void Terminado(){
        System.out.println("El reclamo fue Desestimado");
    }
}
