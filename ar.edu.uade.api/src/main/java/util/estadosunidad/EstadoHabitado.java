package util.estadosunidad;

import pojo.Reclamo;
import pojo.Unidad;
import util.estadosreclamo.EstadoAbierto;

public class EstadoHabitado extends EstadoUnidad {
    public EstadoHabitado(Unidad unidad){
        super(unidad);
    }
    public void Habitado(){

    }
    public void Deshabitado(){
        unidad.setEstado(new EstadoDeshabitado(unidad));
    }
    public void Alquilado(){

    }
}
