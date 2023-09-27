package application.controller;

import application.model.entity.Edificio;
import application.model.entity.dto.EdificioDTO;
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
        edificioDTO = convertToDTO(edificio);
        return new ResponseEntity<>(edificioDTO, HttpStatus.CREATED);
    }

    @GetMapping(value = "/edificio/{id}")
    public ResponseEntity<?> read(@PathVariable long id) {
        Edificio edificio = edificioService.read(id);
        if (edificio == null) {
            String mensaje = "Edificio no encontrado.";
            return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
        }
        EdificioDTO edificioDTO = convertToDTO(edificio);
        return new ResponseEntity<>(edificioDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/edificio/edificioParameters")
    public ResponseEntity<?> readParameterized(@RequestParam("id") long id) {
        Edificio edificio = edificioService.read(id);
        if (edificio == null) {
            String mensaje = "Edificio no encontrado.";
            return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
        }
        EdificioDTO edificioDTO = convertToDTO(edificio);
        return new ResponseEntity<>(edificioDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/edificios")
    public List<EdificioDTO> readAll(UsuarioDTO usuarioDTO) {
        List<Edificio> edificios = edificioService.readAll();
        List<EdificioDTO> response = new ArrayList<>();
        for (Edificio edificio : edificios) {
            EdificioDTO edificioDTO = convertToDTO(edificio);
            response.add(edificioDTO);
        }
        return response;
    }

    @PutMapping("/edificios/{id}")
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody EdificioDTO edificioDTO) {
        if (edificioService.read(id) == null) {
            String mensaje = "Edificio no encontrado.";
            return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
        }
        Edificio edificio = convertToEntity(edificioDTO);
        edificioService.update(id, edificio);
        edificioDTO = convertToDTO(edificio);
        return new ResponseEntity<>(edificioDTO, HttpStatus.OK);
    }

    @PutMapping("/edificios/edificioParameters")
    public ResponseEntity<?> updateParameterized(@RequestParam("id") long id, @RequestBody EdificioDTO edificioDTO) {
        if (edificioService.read(id) == null) {
            String mensaje = "Edificio no encontrado.";
            return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
        }
        Edificio edificio = convertToEntity(edificioDTO);
        edificioService.update(id, edificio);
        edificioDTO = convertToDTO(edificio);
        return new ResponseEntity<>(edificioDTO, HttpStatus.OK);
    }

    @DeleteMapping("/edificios/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        Edificio edificio = edificioService.read(id);
        if (edificio == null) {
            String mensaje = "Edificio no encontrado.";
            return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
        }
        edificioService.delete(edificio);
        String mensaje = "Edificio eliminado.";
        return new ResponseEntity<>(mensaje, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/edificios/edificioParameters")
    public ResponseEntity<?> deleteParameterized(@RequestParam("id") long id) {
        Edificio edificio = edificioService.read(id);
        if (edificio == null) {
            String mensaje = "Edificio no encontrado.";
            return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
        }
        edificioService.delete(edificio);
        String mensaje = "Edificio eliminado.";
        return new ResponseEntity<>(mensaje, HttpStatus.NO_CONTENT);
    }

    private EdificioDTO convertToDTO(Edificio edificio) {
        return new EdificioDTO(
                edificio.getDireccion(),
                edificio.getUnidades(),
                edificio.getReclamos()
        );
    }


    private Edificio convertToEntity(EdificioDTO edificioDTO) {
        return new Edificio(
                edificioDTO.getDireccion(),
                edificioDTO.getUnidades(),
                edificioDTO.getReclamos()
                );
    }


}
