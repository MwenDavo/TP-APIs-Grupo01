package util.estadosunidad;

import pojo.Unidad;

public class EstadoAlquilado extends EstadoUnidad{
    public EstadoAlquilado(Unidad unidad){
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
