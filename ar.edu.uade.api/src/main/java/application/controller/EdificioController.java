package application.controller;

import application.model.entity.Edificio;
import application.model.entity.Usuario;
import application.model.entity.dto.EdificioDTO;
import application.model.entity.dto.UsuarioDTO;
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
        Edificio edificio = new Edificio(
                edificioDTO.getDireccion(),
                edificioDTO.getUnidades()
        );
        edificioService.create(edificio);
        edificioDTO = convertToDTO(edificio);
        return new ResponseEntity<>(edificioDTO, HttpStatus.CREATED);
    }

    @GetMapping(value = "/edificio/{id}")
    public ResponseEntity<?> read(@RequestBody EdificioDTO edificioDTO) {
        Edificio edificio = edificioService.readByDireccion(edificio);
        if (edificio == null) {
            String mensaje = "Edificio no encontrado.";
            return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
        }
        EdificioDTO edificioDTO = convertToDTO(edificio);
        return new ResponseEntity<>(edificioDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/edificios")
    public List<EdificioDTO> readAll(UsuarioDTO usuarioDTO) {
        List<Edificio> edificios = edificioService.readAll(usuario);
        List<EdificioDTO> response = new ArrayList<>();
        for (Edificio edificio : edificios) {
            EdificioDTO edificioDTO = convertToDTO(edificio);
            response.add(edificioDTO);
        }
        return response;
    }

    private EdificioDTO convertToDTO(Edificio e){
        return new EdificioDTO(
                e.getId(),
                e.getDireccion(),
                new ArrayList<>(e.getReclamos())
        );
    }

    private Edificio convertToEntity(EdificioDTO e){
        return new Edificio(
                e.getId(),
                e.getDireccion(),
                e.getUnidades(),
                e.getReclamos()
        );
    }
}
