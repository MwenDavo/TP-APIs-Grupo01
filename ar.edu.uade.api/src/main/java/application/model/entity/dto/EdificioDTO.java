package application.model.entity.dto;

import application.model.entity.General;
import application.model.entity.Unidad;

import java.util.List;

public class UsuarioDTO {
    private String direccion;
    private List<Unidad> unidades;
    private List<General> reclamos;

    public EdificioDTO() {
    }

    public EdificioDTO(String direccion, List<Unidad> unidades, List<General> reclamos) {
        this.direccion = direccion;
        this.unidades = unidades;
        this.reclamos = reclamos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Unidad> getUnidades() {
        return unidades;
    }

    public void setUnidades(List<Unidad> unidades) {
        this.unidades = unidades;
    }

    public List<General> getReclamos() {
        return reclamos;
    }

    public void setReclamos(List<General> reclamos) {
        this.reclamos = reclamos;
    }
}
