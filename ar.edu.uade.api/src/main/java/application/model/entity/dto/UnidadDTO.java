package application.model.entity.dto;

import application.model.entity.Edificio;
import application.model.entity.Localizado;
import application.model.entity.UsuarioUnidad;

import java.util.ArrayList;
import java.util.List;

public class UnidadDTO {
    private long id;
    private int piso;
    private int numero;
    private List<LocalizadoDTO> reclamos = new ArrayList<>();

    private List<UsuarioDTO> usuarios = new ArrayList<>();

    public UnidadDTO() {
    }

    public UnidadDTO(int piso, int numero) {
        this.piso = piso;
        this.numero = numero;
    }

    public UnidadDTO(long id, int piso, int numero, List<LocalizadoDTO> reclamos) {
        this.id = id;
        this.piso = piso;
        this.numero = numero;
        this.reclamos = reclamos;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public List<LocalizadoDTO> getReclamos() {
        return reclamos;
    }

    public void setReclamos(List<LocalizadoDTO> reclamos) {
        this.reclamos = reclamos;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<UsuarioDTO> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<UsuarioDTO> usuarios) {
        this.usuarios = usuarios;
    }
}
