package modelo;

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

    @OneToMany
    private List<Unidad> unidades = new ArrayList<>();
    private String direccion;
    private String administrador;

    @OneToMany
    private List<Reclamo> reclamo = new ArrayList<>();

    public Edificio(int id, List<Unidad> unidades, String direccion, String administrador, List<Reclamo> reclamo) {
        this.id = id;
        this.unidades = unidades;
        this.direccion = direccion;
        this.administrador = administrador;
        this.reclamo = reclamo;
    }
}
