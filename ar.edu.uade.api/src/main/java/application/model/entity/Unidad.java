package application.model.entity;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Entity
@Table(name = "unidades")
public class Unidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;
    @Column(nullable = false)
    private int piso;
    @Column(nullable = false)
    private int numero;
    @OneToMany(mappedBy = "unidad")
    private List<UsuarioUnidad> usuarios;
    @OneToMany(mappedBy = "unidad")
    private List<Localizado> reclamos;

    public Unidad() {
    }

    public Unidad(Edificio edificio, int piso, int numero, List<UsuarioUnidad> usuarios, List<Localizado> reclamos) {
        this.edificio = edificio;
        this.piso = piso;
        this.numero = numero;
        this.usuarios = usuarios;
        this.reclamos = reclamos;
    }

    public Unidad(long id) {
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
