package application.controller;

import application.model.entity.*;
import application.model.entity.dto.FotoDTO;
import application.model.entity.dto.GeneralDTO;
import application.model.entity.dto.LocalizadoDTO;
import application.model.entity.dto.LogDTO;
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

    @PostMapping("/general")
    public ResponseEntity<?> create(@RequestBody GeneralDTO generalDTO) {
        reclamoService.create(convertToEntity(generalDTO));
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @PostMapping("/localizado")
    public ResponseEntity<?> create(@RequestBody LocalizadoDTO localizadoDTO) {
        reclamoService.create(convertToEntity(localizadoDTO));
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @GetMapping(value = "/reclamo/parameters")
    public ResponseEntity<?> read(@RequestParam("id") long id) {
        Reclamo reclamo = reclamoService.read(id);
        if (reclamo == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(convertToDTO(reclamo), HttpStatus.OK);
    }

    @PutMapping("/reclamo/parameters")
    public ResponseEntity<?> update(@RequestParam("id") long id, @RequestBody LogDTO logDTO) {
        Log log = convertToEntity(logDTO);
        if (reclamoService.read(id) == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        reclamoService.update(id, log);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    public static General convertToEntity(GeneralDTO generalDTO) {
        return new General(
                generalDTO.getDescripcion(),
                convertToEntities(generalDTO.getFotos()),
                generalDTO.getUsuario(),
                generalDTO.getEdificio()
        );
    }

    public static Localizado convertToEntity(LocalizadoDTO localizadoDTO) {
        return new Localizado(
                localizadoDTO.getDescripcion(),
                convertToEntities(localizadoDTO.getFotos()),
                localizadoDTO.getUsuario(),
                localizadoDTO.getUnidad()
        );
    }

    public static Log convertToEntity(LogDTO logDTO) {
        return new Log(
                logDTO.getEstadoReclamo(),
                logDTO.getDescripcion()
        );
    }

    public static GeneralDTO convertToDTO(General general) {
        ArrayList<FotoDTO> fotos = new ArrayList<FotoDTO>();
        for (Foto foto : general.getFotos()) {
            fotos.add(FotoController.convertToDTO(foto));
        }
        ArrayList<LogDTO> logs = new ArrayList<LogDTO>();
        for (Log log : general.getHistorial()) {
            logs.add(convertToDTO(log));
        }
        GeneralDTO generalDTO = new GeneralDTO(
                general.getDescripcion(),
                fotos,
                general.getEstadoReclamo(),
                logs
        );
        for (Foto foto : reclamo.getFotos()) {
            reclamoDTO.getFotos().add(convertToDTO(foto));
        }
        for (Log log : reclamo.getHistorial()) {
            reclamoDTO.getHistorial().add(convertToDTO(log));
        }
        return reclamoDTO;
    }

    public static LocalizadoDTO convertToDTO(Localizado localizado) {
        ArrayList<FotoDTO> fotos = new ArrayList<FotoDTO>();
        for (Foto foto : localizado.getFotos()) {
            fotos.add(FotoController.convertToDTO(foto));
        }
        ArrayList<LogDTO> logs = new ArrayList<LogDTO>();
        for (Log log : localizado.getHistorial()) {
            logs.add(convertToDTO(log));
        }
        LocalizadoDTO localizadoDTO = new LocalizadoDTO(
                localizado.getDescripcion(),
                fotos,
                localizado.getEstadoReclamo(),
                logs
        );

        return localizadoDTO;
    }

    public static LogDTO convertToDTO(Log log) {
        return new LogDTO(
                log.getFechaHora(),
                log.getEstadoReclamo(),
                log.getDescripcion()
        );
    }
}