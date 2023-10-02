package application.controller;

import application.model.entity.Usuario;
import application.model.entity.dto.UsuarioDTO;
import application.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PutMapping("/usuario/parameters")
    /**
     * para que se ejecute únicamente por el admin
     */
    public ResponseEntity<?> update(@RequestParam("id") long id, @RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = convertToEntity(usuarioDTO);
        if (usuarioService.read(id) == null) {
            String mensaje = "Usuario no encontrado.";
            return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
        }
        usuarioService.update(id, usuario);
        usuarioDTO = convertToDTO(usuario);
        return new ResponseEntity<>(usuarioDTO, HttpStatus.OK);
    }

    @DeleteMapping("/usuario/parameters")
    /**
     * para que se ejecute únicamente por el admin
     */
    public ResponseEntity<?> delete(@RequestParam("id") long id) {
        if (usuarioService.read(id) == null) {
            String mensaje = "Usuario no encontrado.";
            return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
        }
        usuarioService.delete(id);
        String mensaje = "Usuario eliminado.";
        return new ResponseEntity<>(mensaje, HttpStatus.NO_CONTENT);
    }

    public static Usuario convertToEntity(UsuarioDTO usuarioDTO) {
        return new Usuario(
                usuarioDTO.getUsername(),
                usuarioDTO.getPassword(),
                usuarioDTO.getDni(),
                usuarioDTO.getNombre(),
                usuarioDTO.getTelefono()
        );
    }

    public static UsuarioDTO convertToDTO(Usuario usuario) {
        return new UsuarioDTO(usuario.getUsername(),usuario.getPassword(),usuario.getDni(),usuario.getNombre(),usuario.getTelefono());
    }

    @GetMapping(value = "/usuario/parameters")
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
}
