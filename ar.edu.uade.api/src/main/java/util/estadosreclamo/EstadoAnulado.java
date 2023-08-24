package util.estadosreclamo;

import pojo.Reclamo;

public class EstadoAnulado extends EstadoReclamo{
    public EstadoAnulado(Reclamo reclamo){
        super(reclamo, "anulado");
    }
    public void Abierto(){
        System.out.println("El reclamo esta Anulado");
    }
    public void Anulado(){
        System.out.println("El reclamo ya estaba Anulado");
    }
    public void Desestimado(){
        System.out.println("El reclamo esta Anulado");
    }
    public void EnProceso(){
        System.out.println("El reclamo esta Anulado");
    }
    public void Nuevo(){
        System.out.println("El reclamo esta Anulado");
    }
    public void Terminado(){
        System.out.println("El reclamo esta Anulado");
    }
}
