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
    private IConverterService converterService;

    @PostMapping("/createGeneral")
    public ResponseEntity<?> create(@RequestBody GeneralDTO generalDTO/*,
                                    @RequestPart("fotos") MultipartFile[] fotos*/) throws IOException {

        General general = converterService.convertToEntity(generalDTO);

        reclamoService.create(general);
        System.out.println("ID:" + general.getId());

        return new ResponseEntity<>(general.getId(), HttpStatus.CREATED);
    }

    @PostMapping("/createLocalizado")
    public ResponseEntity<?> create(@RequestBody LocalizadoDTO localizadoDTO/*,
                                    @RequestPart("fotos") MultipartFile[] fotos*/) throws IOException {

        Localizado localizado = converterService.convertToEntity(localizadoDTO);

        reclamoService.create(localizado);
        System.out.println(localizado.getDescripcion());
        return new ResponseEntity<>(localizado.getId(), HttpStatus.CREATED);
    }

    @GetMapping(value = "/readByDescripcion/parameters")
    public ResponseEntity<?> readByDescripcion(@RequestParam("desc") String desc) throws IOException {
        List<Reclamo> reclamos = reclamoService.readByDescripcion(desc);
        if (reclamos == null) {

            return new ResponseEntity<>("No se encontraron reclamos con descripcion que contengan esas frases.", HttpStatus.NOT_FOUND);
        }

        List<ReclamoDTO> response = new ArrayList<ReclamoDTO>();
        reclamos.forEach(reclamo -> {
            response.add(converterService.convertToDTO(reclamo));
        });

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/subirLocalizado")
    public ResponseEntity<String> uploadLocalizado(@RequestParam("foto") MultipartFile archivo, @RequestParam("id")Long id){
        try {
            Foto foto = new Foto();
            foto.setData(archivo.getBytes());
            reclamoService.cargarFotoLocalizado(id,foto);
            return ResponseEntity.ok("Imagen subida exitosamente");

        }
        catch (IOException e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al subir la imagen");
        }
    }

    @PostMapping("/subirGeneral")
    public ResponseEntity<String> uploadGeneral(@RequestParam("foto") MultipartFile archivo, @RequestParam("id")Long id){
        try {
            Foto foto = new Foto();
            foto.setData(archivo.getBytes());
            reclamoService.cargarFotoGeneral(id,foto);
            return ResponseEntity.ok("Imagen subida exitosamente");

        }
        catch (IOException e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al subir la imagen");
        }
    }


    @GetMapping(value = "/readGeneral/parameters")
    public ResponseEntity<?> readGeneral(@RequestParam("id") long id) throws IOException {

        General general = reclamoService.readGeneral(id);

        if (general == null) {

            return new ResponseEntity<>("No se encontró el reclamo general.", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(converterService.convertToDTO(general), HttpStatus.OK);
    }

    @GetMapping("/readLocalizado/parameters")
    public ResponseEntity<?> readLocalizado(@RequestParam("id") long id) throws IOException {

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