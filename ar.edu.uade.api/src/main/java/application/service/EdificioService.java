package application.service;

import application.model.dao.IEdificioDAO;
import application.model.entity.Edificio;
import application.model.entity.Usuario;
import application.model.util.TipoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EdificioService implements IEdificioService {
    @Autowired
    private IEdificioDAO edificioDAO;

    @Override
    public void create(Edificio edificio) {
        edificioDAO.create(edificio);
    }

    @Override
    public Edificio read(Edificio edificio) {
        return edificioDAO.read(edificio.getId());
    }

    @Override
    public Edificio readByDireccion(Edificio edificio) {
        return edificioDAO.readByDireccion(edificio.getDireccion());
    }

    @Override
    public List<Edificio> readAll(Usuario usuario) {
        if (usuario.getTipoUsuario() == TipoUsuario.COMMON) {
            return edificioDAO.readByUsuario();
        }
        return edificioDAO.readAll();
    }
}
