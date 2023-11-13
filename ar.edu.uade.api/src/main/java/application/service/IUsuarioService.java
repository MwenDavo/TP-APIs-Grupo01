package application.service;

import application.model.entity.Unidad;
import application.model.entity.Usuario;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IUsuarioService {
    void create(Usuario usuario, String username);
    Usuario read(long id);
    Usuario readByUsername(String usuario);
    Usuario readByUsernameAndPassword(Usuario usuario);
    List<Usuario> readAll();
    void update(long id, Usuario usuario, String username);
    void delete(long id, String username);

    //TODO modificar interfaz
    void asignarUnidad(long idUsuario, long idUnidad, String relacion);

    //TODO modificar interfaz
    @Transactional
    void desasignarUnidad(long idUsuario, long idUnidad);

    List<Unidad> verificarRelacion(String username, List<Unidad> unidades);
}
