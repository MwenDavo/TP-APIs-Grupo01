package pojo.estadosreclamo;

import pojo.Reclamo;

public class EstadoAbierto extends EstadoReclamo{
    public EstadoAbierto(Reclamo reclamo){
        super(reclamo);
    }
    public void Abierto(){
        System.out.println("El reclamo ya estaba en Abierto");
    }
    public void Anulado(){
        reclamo.setEstado(new EstadoAnulado(reclamo));
        reclamo.historial.add("El estado paso de Abierto a Anulado. Porque...");
    }
    public void Desestimado(){
        reclamo.setEstado(new EstadoDesestimado(reclamo));
        reclamo.historial.add("El estado paso de Abierto a Desestimado. Porque...");
    }
    public void EnProceso(){
        reclamo.setEstado(new EstadoEnProceso(reclamo));
        reclamo.historial.add("El estado paso de Abierto a en Proceso. Porque...");
    }
    public void Nuevo(){
        System.out.println("El estado ya fue creado");
    }
    public void Terminado(){
        reclamo.setEstado(new EstadoTerminado(reclamo));
        reclamo.historial.add("El estado paso de Abierto a Terminado. Porque...");
    }
}
