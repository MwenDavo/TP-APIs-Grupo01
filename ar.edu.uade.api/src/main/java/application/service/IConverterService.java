package application.service;

import application.model.entity.*;
import application.model.entity.dto.*;

import java.io.IOException;
import java.util.List;

public interface IConverterService {

    ReclamoDTO convertToDTO(Reclamo r);
    Reclamo convertToEntity(ReclamoDTO r);
    Usuario convertToEntity(UsuarioDTO usuarioDTO);

    Edificio convertToEntity(EdificioDTO e);

    Unidad convertToEntity(UnidadDTO u);

    General convertToEntity(GeneralDTO generalDTO) throws IOException;

    Localizado convertToEntity(LocalizadoDTO localizadoDTO) throws IOException;

    List<Foto> convertToEntityf(List<FotoDTO> fotos) throws IOException;

    Log convertToEntity(LogDTO logDTO);

    UsuarioDTO convertToDTO(Usuario usuario) throws IOException;

    EdificioDTO convertToDTO(Edificio edificio) throws IOException;

    UnidadDTO convertToDTO(Unidad u) throws IOException;

    List<UnidadDTO> convertToDTO(List<Unidad> unidades);

    GeneralDTO convertToDTO(General general) throws IOException;

    LocalizadoDTO convertToDTO(Localizado localizado) throws IOException;

    List<FotoDTO> convertToDTOf(List<Foto> fotos) throws IOException;

    LogDTO convertToDTO(Log log);
}
