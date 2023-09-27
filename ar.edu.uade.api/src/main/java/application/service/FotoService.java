package application.service;

import application.model.dao.IFotoRepository;
import application.model.entity.Foto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FotoService implements IFotoService {
    @Autowired
    private IFotoRepository fotoRepository;

    @Override
    public void create(Foto foto) {
        fotoRepository.save(foto);
    }

    @Override
    public Foto read(long id) {
        Optional<Foto> foto = fotoRepository.findById(id);
        return foto.orElse(null);
    }
}
