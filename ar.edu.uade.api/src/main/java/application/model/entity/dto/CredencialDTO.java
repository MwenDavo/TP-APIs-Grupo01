package application.model.entity.dto;

public class CredencialDTO {
    private UsuarioDTO usuarioDTO;
    private String token;

    public CredencialDTO(UsuarioDTO usuarioDTO, String token) {
        this.usuarioDTO = usuarioDTO;
        this.token = token;
    }

    public UsuarioDTO getUsuarioDTO() {
        return usuarioDTO;
    }

    public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
        this.usuarioDTO = usuarioDTO;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
