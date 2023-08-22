package modelo;

import javax.persistence.*;
import java.util.List;

public class Unidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int piso;
    private int numero;
    private EstadoUnidad estado;
    private Edificio edificio;
    @ManyToMany(mappedBy = "unidades")
    private List<Usuario> duenios;
    @OneToMany(mappedBy = "unidades")
    private List<Usuario> inquilinos;s
    private List<String> habitantes;

    public Unidad(int id, int piso, int numero, EstadoUnidad estado, List<Usuario> duenios, List<Usuario> inquilinos, List<String> habitantes) {
        this.id = id;
        this.piso = piso;
        this.numero = numero;
        this.estado = estado;
        this.duenios = duenios;
        this.inquilinos = inquilinos;
        this.habitantes = habitantes;
    }
}
