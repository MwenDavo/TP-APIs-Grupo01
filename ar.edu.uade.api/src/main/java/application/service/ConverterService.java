package application.service;

import application.model.entity.*;
import application.model.entity.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ConverterService implements IConverterService{

    @Autowired
    private IReclamoService reclamoService;

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private IEdificioService edificioService;


    @Override
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
    @Override
    public Edificio convertToEntity(EdificioDTO e) {

        Edificio edificio = new Edificio(e.getDireccion());

        for(UnidadDTO u : e.getUnidades()){

            Unidad unidad = convertToEntity(u);

            edificio.getUnidades().add(unidad);
        }

        return edificio;
    }
    @Override
    public Unidad convertToEntity(UnidadDTO u){

        return new Unidad(u.getPiso(),u.getNumero());
    }
    @Override
    public General convertToEntity(GeneralDTO generalDTO) throws IOException {

        General g = new General(
                generalDTO.getDescripcion(),
                null, //todo convert to entity con fotos
                usuarioService.readByUsername(generalDTO.getUsername()),
                edificioService.readByDireccion(generalDTO.getdireccionEdificio())
        );

        /*
        List<Foto> listaFotos = g.getFotos();
        for (Foto f: listaFotos) {
            f.setReclamo(g);
        }*/

        return g;
    }
    @Override
    public Localizado convertToEntity(LocalizadoDTO localizadoDTO) throws IOException {
        Localizado l = new Localizado(
                localizadoDTO.getDescripcion(),
                null, //todo convert to entity con fotos 2
                usuarioService.readByUsername(localizadoDTO.getUsername()),
                edificioService.readUnidad(localizadoDTO.getIdUnidad())
        );
        /*
         List<Foto> listaFotos = l.getFotos();
        for (Foto f: listaFotos) {
            f.setReclamo(l);
       }
         */

        return l;
    }
    @Override
    public List<Foto> convertToEntityf(List<FotoDTO> fotos) throws IOException {
        List<Foto> fotos1 = new ArrayList<>();
        for (FotoDTO f: fotos) {
            Foto foto = new Foto(f.getData().getBytes());
            fotos1.add(foto);
        }
        return fotos1;
    }
    @Override
    public Log convertToEntity(LogDTO logDTO) {

        return new Log(
                logDTO.getEstadoReclamo(),
                logDTO.getDescripcion()
        );
    }
    @Override
    public UsuarioDTO convertToDTO(Usuario usuario) throws IOException {

        List<UnidadDTO> unidades = new ArrayList<>();


        /*for (UsuarioUnidad usuarioUnidad : usuario.getUnidades()) {

            unidades.add(convertToDTO(usuarioUnidad.getUnidad()));
        }*/

        return new UsuarioDTO(
                usuario.getId(),
                usuario.getUsername(),
                usuario.getDni(),
                usuario.getNombre(),
                usuario.getTelefono(),
                usuario.getTipoUsuario(),
                null //todo unidades eliminadas
        );
    }
    @Override
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
        edificioDTO.setId(edificio.getId());
        return edificioDTO;
    }
    @Override
    public UnidadDTO convertToDTO(Unidad u) throws IOException {

        UnidadDTO unidad = new UnidadDTO(u.getPiso(),u.getNumero());
        List<UsuarioDTO> usuariosadded = new ArrayList<>();
        for (UsuarioUnidad user: u.getUsuarios()){
            usuariosadded.add(convertToDTO(user.getUsuario()));
        }
        unidad.setUsuarios(usuariosadded);

        for(Localizado l: u.getReclamos()){

            unidad.getReclamos().add(convertToDTO(l));
        }
        unidad.setId(u.getId());
        return unidad;
    }
    @Override
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
    @Override
    public GeneralDTO convertToDTO(General general) throws IOException {

        List<LogDTO> logDTOs = new ArrayList<>();

        for (Log log:
                general.getHistorial()) {

            logDTOs.add(convertToDTO(log));
        }

        return new GeneralDTO(
                general.getId(),
                general.getDescripcion(),
                null, //todo FOTOS
                general.getEstadoReclamo(),
                logDTOs
        );
    }
    @Override
    public LocalizadoDTO convertToDTO(Localizado localizado) throws IOException {

        List<LogDTO> logDTOs = new ArrayList<>();

        for (Log log:
                localizado.getHistorial()) {

            logDTOs.add(convertToDTO(log));
        }

        return new LocalizadoDTO(
                localizado.getId(),
                localizado.getDescripcion(),
                null, //todo FOTOS 2
                localizado.getEstadoReclamo(),
                logDTOs
        );
    }
    @Override
    public List<FotoDTO> convertToDTOf(List<Foto> fotos) throws IOException {
        List<FotoDTO> fotosdto = new ArrayList<>();
        int count = 0;
        /*for (Foto f:fotos) {
            MultipartFile multiPartFile = new MockMultipartFile("foto"+ count,f.getData());
            System.out.println(multiPartFile.getBytes());
            FotoDTO fotoDTO = new FotoDTO(multiPartFile);
            fotosdto.add(fotoDTO);
            count++;
        }*/
        return fotosdto;
    }
    @Override
    public LogDTO convertToDTO(Log log) {

        return new LogDTO(
                log.getId(),
                log.getFechaHora(),
                log.getEstadoReclamo(),
                log.getDescripcion()
        );
    }
}
