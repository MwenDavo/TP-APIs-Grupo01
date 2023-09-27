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

    @GetMapping(value = "/usuarios")
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

    @PutMapping("/usuario/{id}")
    /**
     * para que se ejecute únicamente por el admin
     */
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody UsuarioDTO usuarioDTO) {
        if (usuarioService.read(id) == null) {
            String mensaje = "Edificio no encontrado.";
            return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
        }
        Usuario usuario = convertToEntity(usuarioDTO);
        usuarioService.update(id, usuario);
        usuarioDTO = convertToDTO(usuario);
        return new ResponseEntity<>(usuarioDTO, HttpStatus.OK);
    }

    @PutMapping("/usuario/edificioParameters")
    /**
     * para que se ejecute únicamente por el admin
     */
    public ResponseEntity<?> updateParameterized(@RequestParam("id") long id, @RequestBody UsuarioDTO usuarioDTO) {
        if (usuarioService.read(id) == null) {
            String mensaje = "Edificio no encontrado.";
            return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
        }
        Usuario usuario = convertToEntity(usuarioDTO);
        usuarioService.update(id, usuario);
        usuarioDTO = convertToDTO(usuario);
        return new ResponseEntity<>(usuarioDTO, HttpStatus.OK);
    }

    @DeleteMapping("/usuario/{id}")
    /**
     * para que se ejecute únicamente por el admin
     */
    public ResponseEntity<?> delete(@PathVariable long id) {
        Usuario usuario = usuarioService.read(id);
        if (usuario == null) {
            String mensaje = "Edificio no encontrado.";
            return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
        }
        usuarioService.delete(usuario);
        String mensaje = "Edificio eliminado.";
        return new ResponseEntity<>(mensaje, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/usuario/edificioParameters")
    /**
     * para que se ejecute únicamente por el admin
     */
    public ResponseEntity<?> deleteParameterized(@RequestParam("id") long id) {
        Usuario usuario = usuarioService.read(id);
        if (usuario == null) {
            String mensaje = "Edificio no encontrado.";
            return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
        }
        usuarioService.delete(usuario);
        String mensaje = "Edificio eliminado.";
        return new ResponseEntity<>(mensaje, HttpStatus.NO_CONTENT);
    }

    private Usuario convertToEntity(UsuarioDTO usuarioDTO) {
        return new Usuario(
                usuarioDTO.getUsername(),
                usuarioDTO.getPassword(),
                usuarioDTO.getDni(),
                usuarioDTO.getNombre(),
                usuarioDTO.getTelefono()
        );
    }

    private UsuarioDTO convertToDTO(Usuario usuario) {
        return null;
    }
}
