package application.service;

import application.controller.EdificioController;
import application.controller.UnidadController;
import application.model.entity.*;
import application.model.entity.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConverterService {

    @Autowired
    private IReclamoService reclamoService;

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private IEdificioService edificioService;



    public Usuario convertToEntity(UsuarioDTO usuarioDTO) {

        return new Usuario(
                usuarioDTO.getUsername(),
                usuarioDTO.getPassword(),
                usuarioDTO.getTipoUsuario(),
                usuarioDTO.getDni(),
                usuarioDTO.getNombre(),
                usuarioDTO.getTelefono()
        );
    }

    public Edificio convertToEntity(EdificioDTO e) {

        Edificio edificio = new Edificio(e.getDireccion());

        for(UnidadDTO u : e.getUnidades()){

            Unidad unidad = convertToEntity(u);

            edificio.getUnidades().add(unidad);
        }

        return edificio;
    }

    public Unidad convertToEntity(UnidadDTO u){

        return new Unidad(u.getPiso(),u.getNumero());
    }

    public General convertToEntity(GeneralDTO generalDTO) {

        return new General(
                generalDTO.getDescripcion(),
                generalDTO.getFotos(),
                usuarioService.readByUsername(generalDTO.getUsername()),
                edificioService.readByDireccion(generalDTO.getdireccionEdificio())
        );
    }

    public Localizado convertToEntity(LocalizadoDTO localizadoDTO) {

        return new Localizado(
                localizadoDTO.getDescripcion(),
                localizadoDTO.getFotos(),
                usuarioService.readByUsername(localizadoDTO.getUsername()),
                edificioService.readUnidad(localizadoDTO.getUnidad())
        );
    }

    public Log convertToEntity(LogDTO logDTO) {

        return new Log(
                logDTO.getEstadoReclamo(),
                logDTO.getDescripcion()
        );
    }

    public UsuarioDTO convertToDTO(Usuario usuario) {

        List<UnidadDTO> unidades = new ArrayList<>();

        for (UsuarioUnidad usuarioUnidad : usuario.getUnidades()) {

            unidades.add(convertToDTO(usuarioUnidad.getUnidad()));
        }

        return new UsuarioDTO(
                usuario.getId(),
                usuario.getUsername(),
                usuario.getDni(),
                usuario.getNombre(),
                usuario.getTelefono(),
                usuario.getTipoUsuario(),
                unidades
        );
    }

    public EdificioDTO convertToDTO(Edificio edificio) {

        EdificioDTO edificioDTO = new EdificioDTO(

                edificio.getDireccion()
        );

        for (Unidad unidad : edificio.getUnidades()) {

            edificioDTO.getUnidades().add(convertToDTO(unidad));
        }

        for (General general : edificio.getReclamos()){

            edificioDTO.getReclamos().add(convertToDTO(general));
        }

        return edificioDTO;
    }

    public UnidadDTO convertToDTO(Unidad u) {

        UnidadDTO unidad = new UnidadDTO(u.getPiso(),u.getNumero());

        for(Localizado l: u.getReclamos()){

            unidad.getReclamos().add((LocalizadoDTO) convertToDTO(l));
        }

        return unidad;
    }

    public List<UnidadDTO> convertToDTO(List<Unidad> unidades) {

        List<UnidadDTO> unidadesRes = new ArrayList<>();

        for (Unidad unidad:
                unidades) {

            List<LocalizadoDTO> localizadoDTO = new ArrayList<>();

            for (Localizado reclamo:
                    unidad.getReclamos()) {

                LocalizadoDTO l = new LocalizadoDTO(reclamo.getDescripcion(),
                        reclamo.getFotos(),
                        reclamo.getUsuario().getUsername(),
                        reclamo.getUnidad().getId()
                );

                localizadoDTO.add(l);
            }

            UnidadDTO unidadDTO = new UnidadDTO(
                    unidad.getId(),
                    unidad.getPiso(),
                    unidad.getNumero(),
                    localizadoDTO
            );

            unidadesRes.add(unidadDTO);
        }

        return unidadesRes;
    }

    public GeneralDTO convertToDTO(General general) {

        List<LogDTO> logDTOs = new ArrayList<>();

        for (Log log:
                general.getHistorial()) {

            logDTOs.add(convertToDTO(log));
        }

        return new GeneralDTO(
                general.getId(),
                general.getDescripcion(),
                general.getFotos(),
                general.getEstadoReclamo(),
                logDTOs
        );
    }

    public LocalizadoDTO convertToDTO(Localizado localizado) {

        List<LogDTO> logDTOs = new ArrayList<>();

        for (Log log:
                localizado.getHistorial()) {

            logDTOs.add(convertToDTO(log));
        }

        return new LocalizadoDTO(
                localizado.getId(),
                localizado.getDescripcion(),
                localizado.getFotos(),
                localizado.getEstadoReclamo(),
                logDTOs
        );
    }

    public LogDTO convertToDTO(Log log) {

        return new LogDTO(
                log.getId(),
                log.getFechaHora(),
                log.getEstadoReclamo(),
                log.getDescripcion()
        );
    }
}
