package pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

public class Edificio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "edificio")
    private List<Unidad> unidades = new ArrayList<>();
    private String direccion;
    private String administrador;

    @OneToMany
    private List<Reclamo> reclamo = new ArrayList<>();

    public Edificio() {
        super();
    }

    public Edificio(int id, List<Unidad> unidades, String direccion, String administrador, List<Reclamo> reclamo) {
        this.id = id;
        this.unidades = unidades;
        this.direccion = direccion;
        this.administrador = administrador;
        this.reclamo = reclamo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Unidad> getUnidades() {
        return unidades;
    }

    public void setUnidades(List<Unidad> unidades) {
        this.unidades = unidades;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getAdministrador() {
        return administrador;
    }

    public void setAdministrador(String administrador) {
        this.administrador = administrador;
    }

    public List<Reclamo> getReclamo() {
        return reclamo;
    }

    public void setReclamo(List<Reclamo> reclamo) {
        this.reclamo = reclamo;
    }
}
