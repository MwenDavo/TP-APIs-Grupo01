package application.model.entity.dto;

import application.model.entity.Edificio;
import application.model.entity.Localizado;
import application.model.entity.UsuarioUnidad;

import java.util.List;

public class UnidadDTO {
    private long id;
    private Edificio edificio;
    private int piso;
    private int numero;
    private List<UsuarioUnidad> usuarios;
    private List<Localizado> reclamos;

    public UnidadDTO(long id, Edificio edificio, int piso, int numero, List<UsuarioUnidad> usuarios, List<Localizado> reclamos) {
        this.id = id;
        this.edificio = edificio;
        this.piso = piso;
        this.numero = numero;
        this.usuarios = usuarios;
        this.reclamos = reclamos;
    }

    public UnidadDTO(long id){
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Edificio getEdificio() {
        return edificio;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
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

    public List<UsuarioUnidad> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<UsuarioUnidad> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Localizado> getReclamos() {
        return reclamos;
    }

    public void setReclamos(List<Localizado> reclamos) {
        this.reclamos = reclamos;
    }
}
