package application.service;

import application.model.dao.IReclamoDAO;
import application.model.entity.*;
import application.model.util.EstadoReclamo;
import application.model.util.TipoRelacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReclamoService implements IReclamoService {
    @Autowired
    private IReclamoDAO reclamoDAO;

    @Override
    public void createReclamoGeneral(General reclamo) {
        if (cargarEnGeneral(reclamo)) {
            reclamoDAO.create(reclamo);
        }
    }

    @Override
    public void createReclamoLocalizado(Localizado reclamo) {
        if (cargarEnLocalizado(reclamo)) {
            reclamoDAO.create(reclamo);
        }
    }

    @Override
    public Reclamo read(Reclamo reclamo) {
        return reclamoDAO.read(reclamo.getId());
    }

    @Override
    public List<Reclamo> readByEstadoReclamo(Reclamo reclamo) {
        return reclamoDAO.readByEstadoReclamo(reclamo.getEstadoReclamo());
    }

    @Override
    public List<Reclamo> readAll() {
        return reclamoDAO.readAll();
    }

    @Override
    public void update(Reclamo reclamo) {
        if (validarUpdate(reclamo)) {
            reclamoDAO.update(reclamo);
        }
    }


    public boolean cargarEnGeneral (General reclamo){
        Edificio edificio = reclamo.getEdificio();
        for (Unidad unidad : edificio.getUnidades()) {
            for (UsuarioUnidad usuarioUnidad : unidad.getUsuarios()) {
                if (reclamo.getUsuario().getId() == usuarioUnidad.getUsuario().getId()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean cargarEnLocalizado (Localizado reclamo){
        Unidad unidad = reclamo.getUnidad();
        if (unidad.getUsuarios().size() == 2) {
            for (UsuarioUnidad usuarioUnidad : unidad.getUsuarios()) {
                if (reclamo.getUsuario().getId() == usuarioUnidad.getUsuario().getId()) {
                    return usuarioUnidad.getTipoRelacion() == TipoRelacion.INQUILINO;
                }
            }
        }
        if (unidad.getUsuarios().size() == 1) {
            for (UsuarioUnidad usuarioUnidad : unidad.getUsuarios()) {
                if (reclamo.getUsuario().getId() == usuarioUnidad.getUsuario().getId()) {
                    return usuarioUnidad.getTipoRelacion() == TipoRelacion.PROPIETARIO;
                }
            }
        }
        return false;
    }

    public boolean validarUpdate(Reclamo reclamo) {
        boolean validez;
        if (reclamo.getEstadoReclamo() == EstadoReclamo.DESESTIMADO
                || reclamo.getEstadoReclamo() == EstadoReclamo.ANULADO
                || reclamo.getEstadoReclamo() == EstadoReclamo.TERMINADO) {
            validez = false;
        } else {
            validez = true;
        }
        return validez;
    }
}
