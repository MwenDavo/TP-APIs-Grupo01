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

    @PostMapping("/reclamoGeneral") //TODO cambiar el DTO
    public ResponseEntity<ReclamoDTO> createReclamoGeneral(@RequestBody ReclamoDTO reclamoDTO) {
        Reclamo reclamo = convertToEntity(reclamoDTO);
        reclamoService.createReclamoGeneral(reclamo);
        reclamoDTO = convertToDTO(reclamo);
        return new ResponseEntity<>(reclamoDTO, HttpStatus.CREATED);
    }

    @PostMapping("/reclamoLocalizado") //TODO cambiar el DTO
    public ResponseEntity<ReclamoDTO> createReclamoLocalizado(@RequestBody ReclamoDTO reclamoDTO) {
        Reclamo reclamo = convertToEntity(reclamoDTO);
        reclamoService.createReclamoLocalizado(reclamo);
        reclamoDTO = convertToDTO(reclamo);
        return new ResponseEntity<>(reclamoDTO, HttpStatus.CREATED);
    }

    @GetMapping(value = "/reclamo")
    public ResponseEntity<?> read(@RequestBody ReclamoDTO rDTO) {
        Reclamo reclamo = reclamoService.read(convertToEntity(rDTO));
        if (reclamo == null) {
            String mensaje = "Reclamo no encontrado.";
            return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
        }
        ReclamoDTO reclamoDTO = convertToDTO(reclamo);
        return new ResponseEntity<>(reclamoDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/byEstado")
    public List<ReclamoDTO> readByEstadoReclamo(@RequestBody ReclamoDTO reclamoDTO) {
        Reclamo reclamo = convertToEntity(reclamoDTO);
        List<Reclamo> reclamos = reclamoService.readByEstadoReclamo(reclamo);
        List<ReclamoDTO> response = new ArrayList<>();
        for (Reclamo r : reclamos) {
            ReclamoDTO reclamoDto = convertToDTO(r);
            response.add(reclamoDto);
        }
        return response;
    }

    @GetMapping(value = "/all")
    public List<ReclamoDTO> readAll() {
        List<Reclamo> reclamos = reclamoService.readAll();
        List<ReclamoDTO> response = new ArrayList<>();
        for (Reclamo reclamo : reclamos) {
            ReclamoDTO reclamoDto = convertToDTO(reclamo);
            response.add(reclamoDto);
        }
        return response;
    }

    @PutMapping("/reclamo")
    public ResponseEntity<?> update(@RequestBody ReclamoDTO rDTO) {
        Reclamo reclamo = convertToEntity(rDTO);
        if (reclamoService.read(reclamo) == null) {
            String mensaje = "Reclamo no encontrado.";
            return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
        }
        reclamoService.update(reclamo);
        ReclamoDTO reclamoDTO = convertToDTO(reclamo);
        return new ResponseEntity<>(reclamoDTO, HttpStatus.OK);
    }

    public static ReclamoDTO convertToDTO(Reclamo reclamo) {
        return new ReclamoDTO(
                reclamo.getId(),
                reclamo.getDescripcion(),
                reclamo.getFotos(),
                reclamo.getEstadoReclamo()
        );
    }

    public static Reclamo convertToEntity(ReclamoDTO reclamoDTO) {
        return new Reclamo(
                reclamoDTO.getDescripcion(),
                reclamoDTO.getFotos(),
                reclamoDTO.getUsuario(),
                reclamoDTO.getEstadoReclamo(),
                reclamoDTO.getHistorial()
        );
    }


}