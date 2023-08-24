package util.estadosreclamo;

import pojo.Reclamo;

public class EstadoTerminado extends EstadoReclamo{
    public EstadoTerminado(Reclamo reclamo){
        super(reclamo, "terminado");
    }
    public void Abierto(){System.out.println("El reclamo esta Terminado");}
    public void Anulado(){
        System.out.println("El reclamo esta Terminado");
    }
    public void Desestimado(){
        System.out.println("El reclamo esta Terminado");
    }
    public void EnProceso(){
        System.out.println("El reclamo esta Terminado");
    }
    public void Nuevo(){
        System.out.println("El reclamo esta Terminado");
    }
    public void Terminado(){
        System.out.println("El reclamo ya fue Terminado");
    }
}
