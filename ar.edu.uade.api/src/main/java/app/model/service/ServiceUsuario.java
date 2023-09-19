package app.model.service;

import app.model.dao.DaoUsuario;
import app.model.entity.Unidad;
import app.model.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceUsuario implements IServiceUsuario {
    @Autowired
    private DaoUsuario dao;

    @Override
    public void create(Usuario usuario) {

    }

    @Override
    public Usuario read(Usuario usuario) {
        return null;
    }

    @Override
    public List<Usuario> readAll() {

        return dao.readAll();
    }

    @Override
    public void update(Usuario usuario) {

    }

    @Override
    public void updateUnidades(Usuario usuario, Unidad unidad) {

    }
}
