package application.model.entity.dto;

import application.model.entity.Edificio;
import application.model.entity.Foto;
import application.model.entity.Log;
import application.model.entity.Usuario;
import application.model.util.EstadoReclamo;

import java.util.ArrayList;
import java.util.List;

public class GeneralDTO extends ReclamoDTO{
    private EdificioDTO edificio;

    public GeneralDTO(){
        super();
    }

    public GeneralDTO(String descripcion, List<FotoDTO> fotos, UsuarioDTO usuario, EdificioDTO edificio) {
        super(descripcion, fotos, usuario);
        this.edificio = edificio;
    }

    public GeneralDTO(String descripcion, List<FotoDTO> fotos, EstadoReclamo estadoReclamo, List<LogDTO> historial) {
        super(descripcion, fotos, estadoReclamo, historial);
    }

    public GeneralDTO(EstadoReclamo estadoReclamo) {
        super(estadoReclamo);
    }

    public EdificioDTO getEdificio() {
        return edificio;
    }

    public void setEdificio(EdificioDTO edificio) {
        this.edificio = edificio;
    }

}
