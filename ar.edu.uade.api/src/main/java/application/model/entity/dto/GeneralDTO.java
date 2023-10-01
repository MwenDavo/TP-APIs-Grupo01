package application.model.entity.dto;

import application.model.entity.Edificio;
import application.model.entity.Foto;
import application.model.entity.Log;
import application.model.entity.Usuario;
import application.model.util.EstadoReclamo;

import java.util.ArrayList;
import java.util.List;

public class GeneralDTO extends ReclamoDTO{
    private Edificio edificio; //TODO CHEQUEAR CORRECTA IMPLEMENTACION DE DTOS, POR EJEMPLO EN GENERALDTO SE ESTA UTILIZANDO UN EDIFICIO COMUN Y NO UN EDIFICIODTO

    public GeneralDTO(long id, String descripcion, List<FotoDTO> fotos, Usuario usuario, EstadoReclamo estadoReclamo, List<LogDTO> historial, Edificio edificio) {
        super(id, descripcion, fotos, usuario, estadoReclamo, historial);
        this.edificio = edificio;
    }

    public Edificio getEdificio() {
        return edificio;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }



}
