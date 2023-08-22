package modelo.estadosreclamo;

import modelo.Reclamo;

public class EstadoEnProceso extends EstadoReclamo{
    public EstadoEnProceso(Reclamo reclamo){
        super(reclamo);
    }
    public void Abierto(){
        System.out.println("El reclamo esta en Proceso");
    }
    public void Anulado(){
        reclamo.setEstado(new EstadoAnulado(reclamo));
        reclamo.historial.add("El estado paso de en Proceso a Anulado. Porque...");
    }
    public void Desestimado(){
        reclamo.setEstado(new EstadoDesestimado(reclamo));
        reclamo.historial.add("El estado paso de en Proceso a Desestimado. Porque...");
    }
    public void EnProceso(){
        System.out.println("El reclamo ya se encunetra en Proceso");
    }
    public void Nuevo(){
        System.out.println("El reclamo ya fue creado y esta en proceso");
    }
    public void Terminado(){
        reclamo.setEstado(new EstadoTerminado(reclamo));
        reclamo.historial.add("El estado paso de en Proceso a Terminado. Porque...");
    }
}
