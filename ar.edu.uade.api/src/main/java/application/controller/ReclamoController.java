package application.controller;

import application.model.entity.Edificio;
import application.model.entity.General;
import application.model.entity.Localizado;
import application.model.entity.Reclamo;
import application.model.entity.dto.GeneralDTO;
import application.model.entity.dto.LocalizadoDTO;
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
    public ResponseEntity<ReclamoDTO> create(@RequestBody GeneralDTO reclamoDTO) {
        General reclamo = convertToEntity(reclamoDTO);
        reclamoService.create(reclamo);
        reclamoDTO = convertToDTO(reclamo);
        return new ResponseEntity<>(reclamoDTO, HttpStatus.CREATED);
    }

    @PostMapping("/reclamo") //TODO cambiar el DTO
    public ResponseEntity<ReclamoDTO> create(@RequestBody LocalizadoDTO reclamoDTO) {
        Localizado reclamo = convertToEntity(reclamoDTO);
        reclamoService.create(reclamo);
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

    public static ReclamoDTO convertToDTO(General reclamo) {
        return new ReclamoDTO(
                reclamo.getId(),
                reclamo.getDescripcion(),
                reclamo.getFotos(),
                reclamo.getEstadoReclamo()
        );
    }

    public static ReclamoDTO convertToDTO(Localizado reclamo) {
        return new ReclamoDTO(
                reclamo.getId(),
                reclamo.getDescripcion(),
                reclamo.getFotos(),
                reclamo.getEstadoReclamo()
        );
    }

    public static Reclamo convertToEntity(GeneralDTO reclamoDTO) {
        return new Reclamo(
                reclamoDTO.getDescripcion(),
                reclamoDTO.getFotos(),
                reclamoDTO.getUsuario(),
                reclamoDTO.getEstadoReclamo(),
                reclamoDTO.getHistorial()
        );
    }

    public static Reclamo convertToEntity(LocalizadoDTO reclamoDTO) {
        return new Reclamo(
                reclamoDTO.getDescripcion(),
                reclamoDTO.getFotos(),
                reclamoDTO.getUsuario(),
                reclamoDTO.getEstadoReclamo(),
                reclamoDTO.getHistorial()
        );
    }
}