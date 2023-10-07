package application.model.entity.dto;

import application.model.entity.General;
import application.model.entity.Unidad;

import java.util.ArrayList;
import java.util.List;

public class EdificioDTO {
    private String direccion;
    private List<UnidadDTO> unidades;
    private List<GeneralDTO> reclamos;

    public EdificioDTO(String direccion, List<UnidadDTO> unidades) {
        this.direccion = direccion;
        this.unidades = unidades;
    }

    public EdificioDTO(String direccion, List<UnidadDTO> unidades, List<GeneralDTO> reclamos) {
        this.direccion = direccion;
        this.unidades = unidades;
        this.reclamos = reclamos;
    }

    public EdificioDTO(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<UnidadDTO> getUnidades() {
        return unidades;
    }

    public void setUnidades(List<UnidadDTO> unidades) {
        this.unidades = unidades;
    }

    public List<GeneralDTO> getReclamos() {
        return reclamos;
    }

    public void setReclamos(List<GeneralDTO> reclamos) {
        this.reclamos = reclamos;
    }
}
