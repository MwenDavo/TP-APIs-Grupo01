package application.service;

import application.model.dao.IEdificioDAO;
import application.model.entity.Edificio;
import application.model.entity.dto.UsuarioDTO;
import application.model.util.TipoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EdificioService implements IEdificioService {
    @Autowired
    private IEdificioDAO dao;

    @Override
    public void create(Edificio edificio) {
        dao.create(edificio);
    }

    @Override
    public Edificio read(long id) {
        return dao.read(id);
    }

    @Override
    public List<Edificio> readAll() {

        return dao.readAll();
    }
}
