package app.model.entity;

import app.util.TipoRelacion;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "unidades")
public class Unidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Edificio edificio;
    @Column(nullable = false)
    private int piso;
    @Column(nullable = false)
    private int numero;
    @OneToMany(mappedBy = "unidad", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<UsuarioUnidad> usuarios = new ArrayList<>();
    @OneToMany(mappedBy = "unidad", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Localizado> reclamos = new ArrayList<>();

    public Unidad() {

    }

    public Unidad(Edificio edificio, int piso, int numero) {
        this.edificio = edificio;
        this.piso = piso;
        this.numero = numero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
