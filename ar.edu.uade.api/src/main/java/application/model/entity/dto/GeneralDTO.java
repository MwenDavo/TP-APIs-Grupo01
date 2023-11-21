package application.model.entity.dto;

import application.model.util.EstadoReclamo;

import java.util.List;

public class GeneralDTO extends ReclamoDTO{
    private String direccionEdificio;

    public GeneralDTO(){
        super();
    }

    public GeneralDTO(String descripcion, String username, String direccionEdificio) {
        super(descripcion, username);
        this.direccionEdificio = direccionEdificio;
    }

    public GeneralDTO(long id, String descripcion/*, List<FotoDTO> fotos*/, EstadoReclamo estadoReclamo, List<LogDTO> historial) {
        super(id, descripcion, /*fotos,*/ estadoReclamo, historial);
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
