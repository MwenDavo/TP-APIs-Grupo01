package application.controller;

import application.service.IAsignacionService;
import application.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/asignacion")
public class AsignacionController {
    @Autowired
    private IUsuarioService usuarioService;
    @Autowired
    private IAsignacionService asignacionService;

    @PutMapping("/asignar/parameters")
    /**
     * para que se ejecute únicamente por el admin
     */
    public ResponseEntity<?> asignarUnidad(
            @RequestParam("id_usuario") long idUsuario,
            @RequestParam("id_unidad") long idUnidad,
            @RequestParam("relacion") String relacion
    ) {
        asignacionService.asignarUnidad(idUsuario, idUnidad, relacion);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PutMapping("/desasignar/parameters")
    /**
     * para que se ejecute únicamente por el admin
     */
    public ResponseEntity<?> desasignarUnidad(
            @RequestParam("id_usuario") long idUsuario,
            @RequestParam("id_unidad") long idUnidad
    ) {
        asignacionService.desasignarUnidad(idUsuario, idUnidad);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
