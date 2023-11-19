package application.controller;

import application.model.entity.*;
import application.model.entity.dto.*;
import application.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/reclamos")
public class ReclamoController {

    @Autowired
    private IReclamoService reclamoService;

    @Autowired
    private ConverterService converterService;

    @PostMapping("/createGeneral")
    public ResponseEntity<?> create(@RequestPart("reclamo") GeneralDTO generalDTO,
                                    @RequestPart("fotos") MultipartFile[] fotos) throws IOException {

        List<FotoDTO> fotosLocal =  new ArrayList<>();
        for (MultipartFile f:
                fotos) {
            FotoDTO foto = new FotoDTO(f);
            fotosLocal.add(foto);
        }
        generalDTO.setFotos(fotosLocal);

        General general = converterService.convertToEntity(generalDTO);

        reclamoService.create(general);

        return new ResponseEntity<>("Se persistió el reclamo general.", HttpStatus.CREATED);
    }

    @PostMapping("/createLocalizado")
    public ResponseEntity<?> create(@RequestPart("reclamo") LocalizadoDTO localizadoDTO,
                                    @RequestPart("fotos") MultipartFile[] fotos) throws IOException {
        List<FotoDTO> fotosLocal =  new ArrayList<>();
        for (MultipartFile f:
                fotos) {
            FotoDTO foto = new FotoDTO(f);
            fotosLocal.add(foto);
        }
        System.out.println(fotosLocal);
        localizadoDTO.setFotos(fotosLocal);

        Localizado localizado = converterService.convertToEntity(localizadoDTO);

        reclamoService.create(localizado);

        return new ResponseEntity<>("Se persistió el reclamo localizado", HttpStatus.CREATED);
    }

    @GetMapping(value = "/readGeneral/parameters")
    public ResponseEntity<?> readGeneral(@RequestParam("id") long id) {

        General general = reclamoService.readGeneral(id);

        if (general == null) {

            return new ResponseEntity<>("No se encontró el reclamo general.", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(converterService.convertToDTO(general), HttpStatus.OK);
    }

    @GetMapping("/readLocalizado/parameters")
    public ResponseEntity<?> readLocalizado(@RequestParam("id") long id) {

        Localizado localizado = reclamoService.readLocalizado(id);

        if (localizado == null) {

            return new ResponseEntity<>("No se encontró el reclamo localizado.", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(converterService.convertToDTO(localizado), HttpStatus.OK);
    }
    @PutMapping("/updateGeneral/parameters")
    public ResponseEntity<?> updateGeneral(@RequestParam("id") long id,
                                           @RequestBody LogDTO logDTO,
                                           @RequestParam("username") String username) {

        Log log = converterService.convertToEntity(logDTO);

        if (reclamoService.readGeneral(id) == null) {

            return new ResponseEntity<>("No se encontró el reclamo general.", HttpStatus.NOT_FOUND);
        }

        reclamoService.updateGeneral(id, log, username);

        return new ResponseEntity<>("Se actualizó el reclamo general.", HttpStatus.OK);
    }

    @PutMapping("/updateLocalizado/parameters")
    public ResponseEntity<?> updateLocalizado(@RequestParam("id") long id,
                                              @RequestBody LogDTO logDTO,
                                              @RequestParam("username") String username) {

        Log log = converterService.convertToEntity(logDTO);

        if (reclamoService.readLocalizado(id) == null) {

            return new ResponseEntity<>("No se encontró el reclamo localizado.", HttpStatus.NOT_FOUND);
        }

        reclamoService.updateLocalizado(id, log, username);

        return new ResponseEntity<>("Se actualizó el reclamo localizado.", HttpStatus.OK);
    }


}