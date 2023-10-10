package application.controller;

import application.model.entity.*;
import application.model.entity.dto.*;
import application.service.IEdificioService;
import application.service.IReclamoService;
import application.service.IUsuarioService;
import application.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.ParameterResolutionDelegate;
import org.springframework.context.annotation.Bean;
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

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private IEdificioService edificioService;

    @PostMapping("/general")
    public ResponseEntity<?> create(@RequestBody GeneralDTO generalDTO) {
        ArrayList<Foto> fotos = new ArrayList<Foto>();
        for(FotoDTO f:generalDTO.getFotos()){
            fotos.add(FotoController.convertToEntity(f));
        }
        System.out.println(generalDTO.getdireccionEdificio());
        General g = new General(
                generalDTO.getDescripcion(),
                fotos,
                usuarioService.readByUsername(generalDTO.getUsername()),
                edificioService.readByDireccion(generalDTO.getdireccionEdificio())
        );
        reclamoService.create(g);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @PostMapping("/localizado")
    public ResponseEntity<?> create(@RequestBody LocalizadoDTO localizadoDTO) {
        ArrayList<Foto> fotos = new ArrayList<Foto>();

        for(FotoDTO f:localizadoDTO.getFotos()){
            fotos.add(FotoController.convertToEntity(f));
        }
        Localizado l = new Localizado(
                localizadoDTO.getDescripcion(),
                fotos,
                usuarioService.readByUsername(localizadoDTO.getUsername()),
                edificioService.readUnidad(localizadoDTO.getUnidad())
        );
        reclamoService.create(l);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @GetMapping(value = "/readGeneral/parameters")
    public ResponseEntity<?> readGeneral(@RequestParam("id") long id) {
        General reclamo = reclamoService.readGeneral(id);
        if (reclamo == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(convertToDTO(reclamo), HttpStatus.OK);
    }

    @GetMapping("/readLocalizado/parameters")
    public ResponseEntity<?> readLocalizado(@RequestParam("id") long id) {
        Localizado reclamo = reclamoService.readLocalizado(id);
        if (reclamo == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(convertToDTO(reclamo), HttpStatus.OK);
    }
    @PutMapping("/updateGeneral/parameters")
    public ResponseEntity<?> updateGeneral(@RequestParam("id") long id, @RequestBody LogDTO logDTO, @RequestParam("username") String username) {
        Log log = convertToEntity(logDTO);
        if (reclamoService.readGeneral(id) == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        reclamoService.updateGeneral(id, log,username);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PutMapping("/updateLocalizado/parameters")
    public ResponseEntity<?> updateLocalizado(@RequestParam("id") long id, @RequestBody LogDTO logDTO,@RequestParam("username") String username) {
        Log log = convertToEntity(logDTO);
        if (reclamoService.readLocalizado(id) == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        reclamoService.updateLocalizado(id, log,username);
        return new ResponseEntity<>(null, HttpStatus.OK);
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

        return generalDTO;
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