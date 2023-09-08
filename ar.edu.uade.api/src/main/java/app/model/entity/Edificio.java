package app.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "edificios")
public class Edificio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String direccion;
    @OneToMany(mappedBy = "edificio", cascade = CascadeType.ALL)
    private List<Unidad> unidades = new ArrayList<>();
    @OneToMany(mappedBy = "edificio", cascade = CascadeType.ALL)
    private List<General> reclamos = new ArrayList<>();

    public Edificio() {

    }

    public Edificio(String direccion, List<Unidad> unidades, List<General> reclamos) {
        this.direccion = direccion;
        this.unidades = unidades;
        this.reclamos = reclamos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @Override
    public String toString() {
        return "Edificio{" +
                "id=" + id +
                ", direccion='" + direccion + '\'' +
                ", unidades=" + unidades +
                ", reclamos=" + reclamos +
                '}';
    }
}