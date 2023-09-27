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

    @GetMapping(value = "/reclamo")
    public ResponseEntity<?> read(@RequestBody ReclamoDTO reclamoDTO) {
        Reclamo reclamo = reclamoService.read(reclamoDTO);
        if (reclamo == null) {
            String mensaje = "Edificio no encontrado.";
            return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
        }
        ReclamoDTO reclamoDTO = convertToDTO(reclamo);
        return new ResponseEntity<>(reclamoDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/reclamos")
    public List<ReclamoDTO> readAll() {
        List<Reclamo> reclamos = reclamoService.readAll();
        List<ReclamoDTO> response = new ArrayList<>();
        for (Reclamo reclamo : reclamos) {
            ReclamoDTO edificioDTO = convertToDTO(reclamo);
            response.add(reclamoDTO);
        }
        return response;
    }

    @PutMapping("/reclamo")
    public ResponseEntity<?> update(@RequestBody ReclamoDTO reclamoDTO) {
        if (reclamoService.read(id) == null) {
            String mensaje = "Edificio no encontrado.";
            return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
        }
        Edificio edificio = convertToEntity(reclamoDTO);
        reclamoService.update(id, reclamo);
        reclamoDTO = convertToDTO(reclamo);
        return new ResponseEntity<>(reclamoDTO, HttpStatus.OK);
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