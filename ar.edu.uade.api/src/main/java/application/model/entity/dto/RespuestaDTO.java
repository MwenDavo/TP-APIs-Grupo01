package application.model.entity.dto;

public class RespuestaDTO {
    private long id;
    private String direccion;
    private String username;

    public RespuestaDTO(long id, String direccion, String username) {
        this.id = id;
        this.direccion = direccion;
        this.username = username;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
