package modelo;

import javax.persistence.*;
import java.util.List;
//TODO terminar herencias
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private int dni;
    private String telefono;
    private String usuario;
    private String contra;
    @OneToMany(mappedBy = "usuario")
    private List<Reclamo> reclamos;
    @OneToMany(mappedBy = "usuario")
    private List<Unidad> unidades;

}
