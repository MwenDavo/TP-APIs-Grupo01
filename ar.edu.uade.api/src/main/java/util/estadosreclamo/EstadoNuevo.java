package util.estadosreclamo;

import pojo.Reclamo;

public class EstadoNuevo extends EstadoReclamo{
    public EstadoNuevo(Reclamo reclamo){
        super(reclamo, "nuevo");
    }
    public void Abierto(){
        reclamo.setEstado(new EstadoAbierto(reclamo));
        reclamo.historial.add("El estado paso de Nuevo a Abierto. Porque...");

    }
    public void Anulado(){
        reclamo.setEstado(new EstadoAnulado(reclamo));
        reclamo.historial.add("El estado paso de Nuevo a Anulado. Porque...");
    }
    public void Desestimado(){
        System.out.println("El reclamo aun no fue aceptado");
    }
    public void EnProceso(){
        System.out.println("El reclamo aun no fue aceptado");
    }
    public void Nuevo(){
        System.out.println("El reclamo ya fue creado");
    }
    public void Terminado(){
        System.out.println("El reclamo aun no fue aceptado");
    }
}
