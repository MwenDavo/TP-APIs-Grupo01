package modelo;

import modelo.estadosreclamo.EstadoReclamo;

import java.util.List;

public class Reclamo {
    private int id;
    private Edificio edificio;
    private String descripcion;
    private List<Foto> fotos;
    private Usuario usuario;
    private EstadoReclamo estado;
    private Estrategia_Reclamo estrategia;
    public List<String> historial;

    public EstadoReclamo getEstado() {
        return estado;
    }
    public void setEstado(EstadoReclamo estado) {
        this.estado = estado;
    }
}
