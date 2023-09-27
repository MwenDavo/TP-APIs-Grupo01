package application.model.entity.dto;

import application.model.entity.General;
import application.model.entity.Unidad;

import java.util.ArrayList;
import java.util.List;

public class EdificioDTO {
    private long id;
    private String direccion;
    private List<Unidad> unidades = new ArrayList<>();
    private List<General> reclamos = new ArrayList<>();

    public EdificioDTO() {
    }

    public EdificioDTO(long id, String direccion, List<Unidad> unidades, List<General> reclamos) {
        this.id = id;
        this.direccion = direccion;
        this.unidades = unidades;
        this.reclamos = reclamos;
    }

    public EdificioDTO(long id, String direccion, List<General> reclamos) {
        this.id = id;
        this.direccion = direccion;
        this.reclamos = reclamos;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
