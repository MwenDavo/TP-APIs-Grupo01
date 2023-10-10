package application.controller;

import application.model.entity.Edificio;
import application.model.entity.Unidad;
import application.model.entity.dto.EdificioDTO;
import application.model.entity.dto.UnidadDTO;
import application.service.IEdificioService;
import application.service.IUnidadService;
import application.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/unidades")
public class UnidadController {
    @Autowired
    private IUnidadService unidadService;
    @Autowired
    private IEdificioService edificioService;
    @PostMapping("/CrearUnidad/parameters")
    public ResponseEntity<?> create(@RequestBody UnidadDTO UnidadDTO, @RequestParam("direccion") String direccion, @RequestParam("username") String username) {
        Edificio edificio = edificioService.readByDireccion(direccion);
        Unidad unidad = convertToEntity(UnidadDTO);
        unidadService.create(unidad,edificio,username);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @DeleteMapping("/BorrarUnidad/parameters")
    public ResponseEntity<?> delete(@RequestParam("id") long id, @RequestParam("username") String username) {
        Unidad unidad = edificioService.readUnidad(id);
        unidadService.delete(unidad,username);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    public static Unidad convertToEntity(UnidadDTO u){
        return new Unidad(u.getPiso(),u.getNumero());
    }
}
