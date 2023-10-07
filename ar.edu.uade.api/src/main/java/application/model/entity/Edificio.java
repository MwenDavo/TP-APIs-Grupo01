package application.model.entity;

import application.model.entity.dto.GeneralDTO;
import application.model.entity.dto.UnidadDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "edificios")
public class Edificio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, unique = true)
    private String direccion;
    @OneToMany(mappedBy = "edificio", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Unidad> unidades;
    @OneToMany(mappedBy = "edificio", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<General> reclamos = new ArrayList<>();

    public Edificio() {
    }


    public Edificio(long id, String direccion, List<Unidad> unidades, List<General> reclamos) {
        this.id = id;
        this.direccion = direccion;
        this.unidades = unidades;
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
