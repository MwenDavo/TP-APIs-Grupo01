package application.model.entity.dto;

import application.model.entity.Edificio;
import application.model.entity.Localizado;
import application.model.entity.UsuarioUnidad;

import java.util.List;

public class UnidadDTO {
    private int piso;
    private int numero;
    private List<LocalizadoDTO> reclamos;

    public UnidadDTO() {
    }

    public UnidadDTO(int piso, int numero) {
        this.piso = piso;
        this.numero = numero;
    }

    public UnidadDTO(int piso, int numero, List<LocalizadoDTO> reclamos) {
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
}
