package application.service;

import application.model.entity.Usuario;

public interface ICorreoService {

    void enviarCorreoContraseñaProvisoria(String email, String contraseñaProvisoria);
}
