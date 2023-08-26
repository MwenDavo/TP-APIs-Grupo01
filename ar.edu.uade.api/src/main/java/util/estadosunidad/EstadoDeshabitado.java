package util.estadosunidad;

import pojo.Unidad;

public class EstadoDeshabitado extends EstadoUnidad{
    public EstadoDeshabitado(Unidad unidad){
        super(unidad);
    }
    public void Habitado(){
        unidad.setEstado(new EstadoHabitado(unidad));
    }
    public void Deshabitado(){

    }
    public void Alquilado(){
        unidad.setEstado(new EstadoAlquilado(unidad));
    }
}
