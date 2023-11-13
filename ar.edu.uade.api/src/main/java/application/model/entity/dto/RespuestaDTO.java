package application.model.entity.dto;

public class RespuestaDTO {
    private String direccion;
    private String username;

    public RespuestaDTO(String direccion, String username) {
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
}
