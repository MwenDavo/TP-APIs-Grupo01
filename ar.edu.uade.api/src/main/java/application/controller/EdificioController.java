package application.controller;

import application.model.entity.*;
import application.model.entity.dto.*;
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
        Edificio edificio = convertToEntity(edificioDTO);
        edificioService.create(edificio);
        edificioDTO = convertToDTO(edificio);
        return new ResponseEntity<>(edificioDTO, HttpStatus.CREATED);
    }

    @GetMapping(value = "/edificio")
    public ResponseEntity<?> read(@RequestBody EdificioDTO eDTO) {
        Edificio e = convertToEntity(eDTO);
        Edificio edificio = edificioService.readByDireccion(e);
        if (edificio == null) {
            String mensaje = "Edificio no encontrado.";
            return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
        }
        EdificioDTO edificioDTO = convertToDTO(edificio);
        return new ResponseEntity<>(edificioDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public List<EdificioDTO> readAll(UsuarioDTO usuarioDTO) {
        Usuario usuario = UsuarioController. convertToEntity(usuarioDTO);
        List<Edificio> edificios = edificioService.readAll(usuario);
        List<EdificioDTO> response = new ArrayList<>();
        for (Edificio edificio : edificios) {
            EdificioDTO edificioDTO = convertToDTO(edificio);
            response.add(edificioDTO);
        }
        return response;
    }

    public static EdificioDTO convertToDTO(Edificio e){
        return new EdificioDTO(
                e.getId(),
                e.getDireccion(),
                convertToDTOSGeneral(e.getReclamos()) //TODO en todos los DTO que haya una relacion con otro objeto, convertir ese objeto a DTO con un metodo similar al usado en ReclamoController
        );
    }

    public static List<GeneralDTO> convertToDTOSGeneral(List<General> reclamos){
        List<GeneralDTO> devolucion = new ArrayList<>();
        for (General r:reclamos){
            GeneralDTO rC = convertToDTO(r);
            devolucion.add(rC);
        }
        return  devolucion;

    }

    public static Edificio convertToEntity(EdificioDTO e){
        List<Unidad> listaUnidades = new ArrayList<>();
        for(UnidadDTO u:e.getUnidades()){
            Unidad unid = convertUnidadDTOToEntity(u);
            listaUnidades.add(unid);
        }
        return new Edificio(
                e.getId(),
                e.getDireccion(),
                listaUnidades,
                convertToEntitiesGeneral(e.getReclamos())
        );
    }

    public static Unidad convertUnidadDTOToEntity(UnidadDTO u){
        return new Unidad(
          u.getId()
        );
    }

    public static GeneralDTO convertToDTO (General general){
        return new GeneralDTO(
                general.getId(),
                general.getDescripcion(),
                convertToDTOSFotos(general.getFotos()),
                general.getUsuario(),
                general.getEstadoReclamo(),
                convertToDTOSLogs(general.getHistorial()),
                general.getEdificio()
        );
    }

    public static List<General> convertToEntitiesGeneral(List<GeneralDTO> lg){
        List<General> dev = new ArrayList<>();
        for(GeneralDTO g:lg){
            General gC  = new General(
                    g.getDescripcion(),
                    converToEntitiesFotos(g.getFotos()),
                    g.getUsuario(),
                    g.getEdificio()
            );
            dev.add(gC);

        }
        return dev;
    }

    private static List<Foto> converToEntitiesFotos(List<FotoDTO> fotos) {
        List<Foto> Fotos = new ArrayList<>();
        for (FotoDTO f: fotos){
            Foto fC = new Foto(
                    f.getData()
            );
            Fotos.add(fC);
        }
        return Fotos;
    }

    public static List<FotoDTO> convertToDTOSFotos(List<Foto> fOT){
        List<FotoDTO> Fotos = new ArrayList<>();
        for (Foto f: fOT) {
            FotoDTO fotoC = convertToDTO(f);
            Fotos.add(fotoC);

        }
        return Fotos;
    }

    public static FotoDTO convertToDTO(Foto foto) {
        return new FotoDTO(
                foto.getData()
        );
    }

    public static List<LogDTO> convertToDTOSLogs(List<Log> logs){
        List<LogDTO> logsDevolucion = new ArrayList<>();
        for(Log l: logs){
            LogDTO logC = convertToDTO(l);
            logsDevolucion.add(logC);
        }
        return  logsDevolucion;
    }

    private static LogDTO convertToDTO(Log l) {
        return new LogDTO(
                l.getFechaHora(),
                l.getEstadoReclamo(),
                l.getDescripcion()
        );

    }

    //TODO CHEQUEAR CORRECTA IMPLEMENTACION DE DTOS, POR EJEMPLO EN GENERALDTO SE ESTA UTILIZANDO UN EDIFICIO COMUN Y NO UN EDIFICIODTO


}
