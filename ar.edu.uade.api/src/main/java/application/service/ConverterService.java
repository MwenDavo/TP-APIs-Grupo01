package application.service;

import application.model.entity.*;
import application.model.entity.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    public General convertToEntity(GeneralDTO generalDTO) throws IOException {

        General g = new General(
                generalDTO.getDescripcion(),
                convertToEntityf(generalDTO.getFotos()),
                usuarioService.readByUsername(generalDTO.getUsername()),
                edificioService.readByDireccion(generalDTO.getdireccionEdificio())
        );

        List<Foto> listaFotos = g.getFotos();
        for (Foto f: listaFotos) {
            f.setReclamo(g);
        }

        return g;
    }

    public Localizado convertToEntity(LocalizadoDTO localizadoDTO) throws IOException {
        Localizado l = new Localizado(
                localizadoDTO.getDescripcion(),
                convertToEntityf(localizadoDTO.getFotos()),
                usuarioService.readByUsername(localizadoDTO.getUsername()),
                edificioService.readUnidad(localizadoDTO.getIdUnidad())
        );
         List<Foto> listaFotos = l.getFotos();
        for (Foto f: listaFotos) {
            f.setReclamo(l);
        }

        return l;
    }

    public List<Foto> convertToEntityf(List<FotoDTO> fotos) throws IOException {
        List<Foto> fotos1 = new ArrayList<>();
        for (FotoDTO f: fotos) {
            Foto foto = new Foto(f.getData().getBytes());
            fotos1.add(foto);
        }
        return fotos1;
    }

    public Log convertToEntity(LogDTO logDTO) {

        return new Log(
                logDTO.getEstadoReclamo(),
                logDTO.getDescripcion()
        );
    }

    public UsuarioDTO convertToDTO(Usuario usuario) throws IOException {

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

    public EdificioDTO convertToDTO(Edificio edificio) throws IOException {

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

    public UnidadDTO convertToDTO(Unidad u) throws IOException {

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

    public GeneralDTO convertToDTO(General general) throws IOException {

        List<LogDTO> logDTOs = new ArrayList<>();

        for (Log log:
                general.getHistorial()) {

            logDTOs.add(convertToDTO(log));
        }

        return new GeneralDTO(
                general.getId(),
                general.getDescripcion(),
                convertToDTOf(general.getFotos()),
                general.getEstadoReclamo(),
                logDTOs
        );
    }

    public LocalizadoDTO convertToDTO(Localizado localizado) throws IOException {

        List<LogDTO> logDTOs = new ArrayList<>();

        for (Log log:
                localizado.getHistorial()) {

            logDTOs.add(convertToDTO(log));
        }

        return new LocalizadoDTO(
                localizado.getId(),
                localizado.getDescripcion(),
                convertToDTOf(localizado.getFotos()),
                localizado.getEstadoReclamo(),
                logDTOs
        );
    }

    public List<FotoDTO> convertToDTOf(List<Foto> fotos) throws IOException {
        List<FotoDTO> fotosdto = new ArrayList<>();
        int count = 0;
        for (Foto f:fotos) {
            MultipartFile multiPartFile = new MockMultipartFile("foto"+ count,f.getData());
            System.out.println(multiPartFile.getBytes());
            FotoDTO fotoDTO = new FotoDTO(multiPartFile);
            fotosdto.add(fotoDTO);
            count++;
        }
        return fotosdto;
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
