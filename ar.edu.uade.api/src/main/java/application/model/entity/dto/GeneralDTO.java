package application.model.entity.dto;

import application.model.entity.Edificio;
import application.model.entity.Foto;
import application.model.entity.Log;
import application.model.entity.Usuario;
import application.model.util.EstadoReclamo;

import java.util.ArrayList;
import java.util.List;

public class GeneralDTO extends ReclamoDTO{
    private String direccionEdificio;

    public GeneralDTO(){
        super();
    }

    public GeneralDTO(String descripcion, List<FotoDTO> fotos, String username, String direccionEdificio) {
        super(descripcion, fotos, username);
        this.direccionEdificio = direccionEdificio;
    }

    public GeneralDTO(String descripcion, List<FotoDTO> fotos, EstadoReclamo estadoReclamo, List<LogDTO> historial) {
        super(descripcion, fotos, estadoReclamo, historial);
    }

    public GeneralDTO(EstadoReclamo estadoReclamo) {
        super(estadoReclamo);
    }

    public String getdireccionEdificio() {
        return direccionEdificio;
    }

    public void setdireccionEdificio(String direccionEdificio) {
        this.direccionEdificio = direccionEdificio;
    }

}
