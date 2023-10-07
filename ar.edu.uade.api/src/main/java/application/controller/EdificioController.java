package application.controller;

import application.model.entity.*;
import application.model.entity.dto.*;
import application.service.IEdificioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/edificios")
public class EdificioController {
    @Autowired
    private IEdificioService edificioService;

    @PostMapping("/edificio")
    public ResponseEntity<EdificioDTO> create(@RequestBody EdificioDTO edificioDTO) {
        Edificio edificio = convertToEntity(edificioDTO);
        edificioService.create(edificio);
        //edificioDTO = convertToDTO(edificio);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @GetMapping(value = "/edificio/parameters")
    public ResponseEntity<?> read(@RequestParam("direccion") String direccion) {
        Edificio edificio = edificioService.readByDireccion(direccion);
        if (edificio == null) {
            String mensaje = "Edificio no encontrado.";
            return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
        }
        //EdificioDTO edificioDTO = convertToDTO(edificio);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping(value = "/all/parameters")
    public List<EdificioDTO> readAll(@RequestParam("username") String username) {
        List<Edificio> edificios = edificioService.readAll(username);
        List<EdificioDTO> response = new ArrayList<>();
        /*
        for (Edificio edificio : edificios) {
            EdificioDTO edificioDTO = convertToDTO(edificio);
            response.add(edificioDTO);
        }

         */
        return response;
    }

    public static EdificioDTO convertToDTO(Edificio edificio) {
        EdificioDTO edificioDTO = new EdificioDTO(
                edificio.getDireccion()
        );

        for (Unidad unidad : edificio.getUnidades()) {
            edificioDTO.getUnidades().add(convertToDTO(unidad));
        }

        return edificioDTO;
    }

    public static Edificio convertToEntity(EdificioDTO e){
        Edificio edificio = new Edificio(e.getDireccion());
        for(UnidadDTO u:e.getUnidades()){
            Unidad unidad = convertToEntity(u);
            edificio.getUnidades().add(unidad);
        }
        return edificio;
    }

    public static Unidad convertToEntity(UnidadDTO u){
        return new Unidad(u.getPiso(),u.getNumero());
    }

    public static UnidadDTO convertToDTO(Unidad u){
        UnidadDTO unidad = new UnidadDTO(u.getPiso(),u.getNumero());
        for(Localizado l: u.getReclamos()){
            unidad.getReclamos().add((LocalizadoDTO) ReclamoController.convertToDTO(l));
        }
        return unidad;
    }
}
