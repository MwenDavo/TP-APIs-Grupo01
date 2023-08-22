package modelo;

import java.util.List;

public class Edificio {
    private int id;
    private List<Unidad> unidades;
    private String direccion;
    private String administrador;
    private List<Reclamo> reclamo;

    public Edificio(int id, List<Unidad> unidades, String direccion, String administrador, List<Reclamo> reclamo) {
        this.id = id;
        this.unidades = unidades;
        this.direccion = direccion;
        this.administrador = administrador;
        this.reclamo = reclamo;
    }
}
