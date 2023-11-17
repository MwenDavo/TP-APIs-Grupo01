package application.controller;

import application.model.entity.Unidad;
import application.model.entity.Usuario;
import application.model.entity.UsuarioUnidad;
import application.model.entity.dto.UnidadDTO;
import application.model.entity.dto.UsuarioDTO;
import application.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping(value = "/all")
    /**
     * para que se ejecute únicamente por el admin
     */
    public List<UsuarioDTO> readAll() {
        List<Usuario> usuarios = usuarioService.readAll();
        List<UsuarioDTO> response = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            UsuarioDTO usuarioDTO = convertToDTO(usuario);
            response.add(usuarioDTO);
        }
        return response;
    }

    @PutMapping("/UpdateUsuario/parameters")
    /**
     * para que se ejecute únicamente por el admin
     */
    public ResponseEntity<?> update(@RequestParam("id") long id, @RequestBody UsuarioDTO usuarioDTO,@RequestParam("username") String username) {
        Usuario usuario = convertToEntity(usuarioDTO);
        if (usuarioService.read(id) == null) {
            String mensaje = "Usuario no encontrado.";
            return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
        }
        usuarioService.update(id, usuario,username);
        usuarioDTO = convertToDTO(usuario);
        return new ResponseEntity<>(usuarioDTO, HttpStatus.OK);
    }

    @DeleteMapping("/DeleteUsuario/parameters")
    /**
     * para que se ejecute únicamente por el admin
     */
    public ResponseEntity<?> delete(@RequestParam("id") long id,@RequestParam("username") String username) {
        if (usuarioService.read(id) == null) {
            String mensaje = "Usuario no encontrado.";
            return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
        }
        usuarioService.delete(id, username);
        String mensaje = "Usuario eliminado.";
        return new ResponseEntity<>(mensaje, HttpStatus.NO_CONTENT);
    }

    public static Usuario convertToEntity(UsuarioDTO usuarioDTO) {
        return new Usuario(
                usuarioDTO.getUsername(),
                usuarioDTO.getPassword(),
                usuarioDTO.getTipoUsuario(),
                usuarioDTO.getDni(),
                usuarioDTO.getNombre(),
                usuarioDTO.getTelefono()
        );
    }

    public static UsuarioDTO convertToDTO(Usuario usuario) {
        List<UnidadDTO> unidades = new ArrayList<>();
        for (UsuarioUnidad usuarioUnidad : usuario.getUnidades()) {
            unidades.add(EdificioController.convertToDTO(usuarioUnidad.getUnidad()));
        }
        return new UsuarioDTO(
                usuario.getUsername(),
                usuario.getDni(),
                usuario.getNombre(),
                usuario.getTelefono(),
                usuario.getTipoUsuario(),
                unidades
        );
    }

    @GetMapping(value = "/GetUsuario/parameters")
    /**
     * para que se ejecute únicamente por el admin
     */
    public ResponseEntity<?> buscarPorUsername(@RequestParam("username") String username){
        Usuario respuesta = usuarioService.readByUsername(username);
        if(respuesta != null){
            return new ResponseEntity<>(convertToDTO(respuesta),HttpStatus.OK);
        }
        String mensaje = "Usuario no encontrado.";
        return new ResponseEntity<>(mensaje,HttpStatus.NOT_FOUND);
    }

    @PutMapping("/asignar/parameters") //TODO INCLUIR RELACION PROPIETARIO/INQUILINO
    public ResponseEntity<?> asignarUnidad(
            @RequestParam("id_usuario") long idUsuario,
            @RequestParam("id_unidad") long idUnidad,
            @RequestParam("relacion") String relacion
    ) {
        usuarioService.asignarUnidad(idUsuario, idUnidad, relacion);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PutMapping("/desasignar/parameters")
    public ResponseEntity<?> desasignarUnidad(
            @RequestParam("id_usuario") long idUsuario,
            @RequestParam("id_unidad") long idUnidad
    ) {
        usuarioService.desasignarUnidad(idUsuario, idUnidad);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
