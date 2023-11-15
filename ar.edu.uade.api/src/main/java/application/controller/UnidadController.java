package application.controller;

import application.model.entity.*;
import application.model.entity.dto.*;
import application.service.IEdificioService;
import application.service.IUnidadService;
import application.service.IUsuarioService;
import application.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/unidades")
public class UnidadController {
    @Autowired
    private IUnidadService unidadService;
    @Autowired
    private IEdificioService edificioService;
    @Autowired
    private IUsuarioService usuarioService;
    @PostMapping("/CrearUnidad/parameters")
    public ResponseEntity<?> create(@RequestBody UnidadDTO UnidadDTO, @RequestParam("direccion") String direccion, @RequestParam("username") String username) {
        Edificio edificio = edificioService.readByDireccion(direccion);
        Unidad unidad = convertToEntity(UnidadDTO);
        unidadService.create(unidad,edificio,username);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @DeleteMapping("/BorrarUnidad/parameters")
    public ResponseEntity<?> delete(@RequestParam("id") long id, @RequestParam("username") String username) {
        Unidad unidad = edificioService.readUnidad(id);
        unidadService.delete(unidad,username);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @GetMapping("/mostrarUnidades/parameters")
    public List<UnidadDTO> mostrar(@RequestParam("direccion")String direccion, @RequestParam("username") String username) {
        System.out.println("hola");
        Edificio edificio = edificioService.readByDireccion(direccion);

        List<Unidad> unidades = edificio.getUnidades();
        List<Unidad> unidadesRel = usuarioService.verificarRelacion(username, unidades);
        List<UnidadDTO> unidadesDTO = convertToDTO(unidadesRel);
        System.out.println(unidadesRel.get(0).getNumero());
        return unidadesDTO;
    }

    @GetMapping("/mostrarTodasUnidades/parameters")
    public List<UnidadDTO> mostrarTodas(@RequestParam("direccion")String direccion) {
        System.out.println("hola");
        Edificio edificio = edificioService.readByDireccion(direccion);

        List<Unidad> unidades = edificio.getUnidades();
        List<UnidadDTO> unidadesDTO = convertToDTO(unidades);
        return unidadesDTO;
    }

    public static List<UnidadDTO> convertToDTO(List<Unidad> unidades){
        List<UnidadDTO> unidadesRes = new ArrayList<>();
        for (Unidad unidad:
             unidades) {
            List<LocalizadoDTO> localizadoDTO = new ArrayList<>();
            for (Localizado reclamo:
                 unidad.getReclamos()) {
                List<FotoDTO> fotosDTO = new ArrayList<>();
                for (Foto foto:
                        reclamo.getFotos()) {
                    FotoDTO f = new FotoDTO(foto.getData());
                    fotosDTO.add(f);
                }
                LocalizadoDTO l = new LocalizadoDTO(reclamo.getDescripcion(), fotosDTO, reclamo.getUsuario().getUsername(), reclamo.getUnidad().getId());
                localizadoDTO.add(l);
            }
            UnidadDTO unidadDTO = new UnidadDTO(unidad.getPiso(), unidad.getNumero(), localizadoDTO);
            unidadesRes.add(unidadDTO);
        }
        return unidadesRes;
    }

    public static Unidad convertToEntity(UnidadDTO u){
        return new Unidad(u.getPiso(),u.getNumero());
    }
}
