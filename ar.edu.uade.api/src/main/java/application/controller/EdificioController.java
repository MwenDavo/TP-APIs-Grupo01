package application.controller;

import application.model.entity.*;
import application.model.entity.dto.*;
import application.service.ConverterService;
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

    @Autowired
    private ConverterService converterService;

    @PostMapping("/edificio/parameters")
    public ResponseEntity<?> create(@RequestBody EdificioDTO edificioDTO,
                                              @RequestParam("username") String username) {

        Edificio edificio = converterService.convertToEntity(edificioDTO);

        edificioService.create(edificio,username);

        return new ResponseEntity<>("Se persistió el edificio.", HttpStatus.CREATED);
    }

    @GetMapping(value = "/all/parameters")
    public List<EdificioDTO> readAll(@RequestParam("username") String username) {

        List<Edificio> edificios = edificioService.readAll(username);

        List<EdificioDTO> response = new ArrayList<>();

        for (Edificio edificio : edificios) {

            EdificioDTO edificioDTO = converterService.convertToDTO(edificio);

            response.add(edificioDTO);
        }

        return response;
    }
}
