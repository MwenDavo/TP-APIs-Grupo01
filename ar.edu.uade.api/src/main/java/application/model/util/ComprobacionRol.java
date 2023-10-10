package application.model.util;

import application.model.entity.Usuario;

public class ComprobacionRol {

    public static boolean comprobarAdmin(Usuario usuario){
        return usuario.getTipoUsuario() == TipoUsuario.ADMIN;
    }
}
