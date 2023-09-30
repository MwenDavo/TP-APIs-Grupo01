package application.controller;

import application.model.entity.Unidad;
import application.model.entity.Usuario;
import application.model.entity.dto.UnidadDTO;
import application.model.entity.dto.UsuarioDTO;
import application.model.util.TipoRelacion;
import application.service.IAsignacionService;
import application.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/asignacion")
public class AsignacionController {
    @Autowired
    private IUsuarioService usuarioService;
    @Autowired
    private IAsignacionService asignacionService;

    @PutMapping("/asignar")
    /**
     * para que se ejecute únicamente por el admin
     */
    public ResponseEntity<?> asignarUnidad(@RequestBody UsuarioDTO usuarioDTO, UnidadDTO unidadDTO, TipoRelacion tipoRelacion) {
        Usuario usuario = UsuarioController.convertToEntity(usuarioDTO);
        Unidad unidad = EdificioController.convertUnidadToEntity(unidadDTO);
        if (usuarioService.read(usuario) == null) {
            String mensaje = "Usuario no encontrado.";
            return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
        }
        asignacionService.asignarUnidad(usuario, unidad, tipoRelacion);
        usuarioDTO = UsuarioController.convertToDTO(usuario);
        return new ResponseEntity<>(usuarioDTO, HttpStatus.OK);
    }

    @PutMapping("/desasignar")
    /**
     * para que se ejecute únicamente por el admin
     */
    public ResponseEntity<?> desasignarUnidad(@RequestBody UsuarioDTO usuarioDTO, UnidadDTO unidadDTO) {
        Usuario usuario = UsuarioController.convertToEntity(usuarioDTO);
        Unidad unidad = EdificioController.convertUnidadToEntity(unidadDTO);
        if (usuarioService.read(usuario) == null) {
            String mensaje = "Usuario no encontrado.";
            return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
        }
        asignacionService.desasignarUnidad(usuario, unidad);
        usuarioDTO = UsuarioController.convertToDTO(usuario);
        return new ResponseEntity<>(usuarioDTO, HttpStatus.OK);
    }
}
