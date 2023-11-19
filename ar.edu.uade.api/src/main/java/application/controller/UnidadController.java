package application.controller;

import application.model.entity.*;
import application.model.entity.dto.*;
import application.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/unidades")
public class UnidadController {

    @Autowired
    private IUnidadService unidadService;

    @Autowired
    private IEdificioService edificioService;

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private ConverterService converterService;

    @PostMapping("/CrearUnidad/parameters")
    public ResponseEntity<?> create(@RequestBody UnidadDTO UnidadDTO,
                                    @RequestParam("direccion") String direccion,
                                    @RequestParam("username") String username) {

        Unidad unidad = converterService.convertToEntity(UnidadDTO);

        Edificio edificio = edificioService.readByDireccion(direccion);

        unidadService.create(unidad, edificio, username);

        return new ResponseEntity<>("Se persistió la unidad.", HttpStatus.CREATED);
    }

    @DeleteMapping("/BorrarUnidad/parameters")
    public ResponseEntity<?> delete(@RequestParam("id") long id,
                                    @RequestParam("username") String username) {

        Unidad unidad = edificioService.readUnidad(id);

        unidadService.delete(unidad, username);

        return new ResponseEntity<>("Se removió la unidad.", HttpStatus.CREATED);
    }

    @GetMapping("/mostrarUnidades/parameters")
    public List<UnidadDTO> mostrar(@RequestParam("direccion")String direccion,
                                   @RequestParam("username") String username) {

        Edificio edificio = edificioService.readByDireccion(direccion);

        List<Unidad> unidades = edificio.getUnidades();

        List<Unidad> unidadesRel = usuarioService.verificarRelacion(username, unidades);

        return converterService.convertToDTO(unidadesRel);
    }

    @GetMapping("/mostrarTodasUnidades/parameters")
    public List<UnidadDTO> mostrarTodas(@RequestParam("direccion")String direccion) {

        Edificio edificio = edificioService.readByDireccion(direccion);

        List<Unidad> unidades = edificio.getUnidades();

        return converterService.convertToDTO(unidades);
    }
}
