package application.controller;

import application.model.entity.Edificio;
import application.model.entity.Reclamo;
import application.model.entity.dto.ReclamoDTO;
import application.service.IReclamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/reclamos")
public class ReclamoController {
    @Autowired
    private IReclamoService reclamoService;

    @PostMapping("/reclamo")
    public ResponseEntity<ReclamoDTO> create(@RequestBody ReclamoDTO reclamoDTO) {
        Reclamo reclamo = convertToEntity(reclamoDTO);
        reclamoService.create(reclamo);
        reclamoDTO = convertToDTO(reclamo);
        return new ResponseEntity<>(reclamoDTO, HttpStatus.CREATED);
    }

    @GetMapping(value = "/edificio/{id}")
    public ResponseEntity<?> read(@PathVariable long id) {
        Reclamo reclamo = reclamoService.read(id);
        if (reclamo == null) {
            String mensaje = "Edificio no encontrado.";
            return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
        }
        ReclamoDTO reclamoDTO = convertToDTO(reclamo);
        return new ResponseEntity<>(reclamoDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/edificio/edificioParameters")
    public ResponseEntity<?> readParameterized(@RequestParam("id") long id) {
        Reclamo reclamo = reclamoService.read(id);
        if (reclamo == null) {
            String mensaje = "Edificio no encontrado.";
            return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
        }
        ReclamoDTO reclamoDTO = convertToDTO(reclamo);
        return new ResponseEntity<>(reclamoDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/edificios")
    public List<ReclamoDTO> readAll(UsuarioDTO usuarioDTO) {
        List<Reclamo> reclamos = reclamoService.readAll();
        List<ReclamoDTO> response = new ArrayList<>();
        for (Reclamo reclamo : reclamos) {
            ReclamoDTO edificioDTO = convertToDTO(reclamo);
            response.add(reclamoDTO);
        }
        return response;
    }

    @PutMapping("/edificios/{id}")
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody ReclamoDTO reclamoDTO) {
        if (reclamoService.read(id) == null) {
            String mensaje = "Edificio no encontrado.";
            return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
        }
        Edificio edificio = convertToEntity(reclamoDTO);
        reclamoService.update(id, reclamo);
        reclamoDTO = convertToDTO(reclamo);
        return new ResponseEntity<>(reclamoDTO, HttpStatus.OK);
    }

    @PutMapping("/edificios/edificioParameters")
    public ResponseEntity<?> updateParameterized(@RequestParam("id") long id, @RequestBody ReclamoDTO reclamoDTO) {
        if (reclamoService.read(id) == null) {
            String mensaje = "Edificio no encontrado.";
            return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
        }
        Edificio edificio = convertToEntity(reclamoDTO);
        reclamoService.update(id, reclamo);
        reclamoDTO = convertToDTO(reclamo);
        return new ResponseEntity<>(reclamoDTO, HttpStatus.OK);
    }

    @DeleteMapping("/reclamos/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        Reclamo reclamo = reclamoService.read(id);
        if (reclamo == null) {
            String mensaje = "Reclamo no encontrado.";
            return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
        }
        reclamoService.delete(reclamo);
        String mensaje = "Reclamo eliminado.";
        return new ResponseEntity<>(mensaje, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/edificios/edificioParameters")
    public ResponseEntity<?> deleteParameterized(@RequestParam("id") long id) {
        Reclamo reclamo = reclamoService.read(id);
        if (reclamo == null) {
            String mensaje = "Edificio no encontrado.";
            return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
        }
        reclamoService.delete(reclamo);
        String mensaje = "Edificio eliminado.";
        return new ResponseEntity<>(mensaje, HttpStatus.NO_CONTENT);
    }

    private ReclamoDTO convertToDTO(Reclamo reclamo) {
        return new ReclamoDTO(
                reclamo.getId(),
                reclamo.getDescripcion(),
                reclamo.getFotos(),
                reclamo.getEstadoReclamo()
        );
    }

    private Reclamo convertToEntity(ReclamoDTO reclamoDTO) {
        return new Reclamo(
                reclamoDTO.getDescripcion(),
                reclamoDTO.getFotos(),
                reclamoDTO.getUsuario(),
                reclamoDTO.getEstadoReclamo()
        );
    }


}