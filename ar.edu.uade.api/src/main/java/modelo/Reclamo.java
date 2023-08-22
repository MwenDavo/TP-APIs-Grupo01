package modelo;

public class Reclamo {
    private int id;
    private Edificio edificio;
    private String descripcion;
    private List<Foto> fotos;
    private Usuario usuario;
    private Estado estado;
    private Estrategia_Reclamo estrategia;
}
