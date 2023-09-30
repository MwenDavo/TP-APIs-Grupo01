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


    public void create(General reclamo) {
        if (allowCreate(reclamo)) {
            reclamoDAO.create(reclamo);
        }
    }

    public void create(Localizado reclamo) {
        if (allowCreate(reclamo)) {
            reclamoDAO.create(reclamo);
        }
    }

    public General read(General reclamo) {
        return reclamoDAO.read(reclamo);
    }

    public Localizado read(Localizado reclamo) {
        return reclamoDAO.read(reclamo);
    }

    /*
    @Deprecated
    public List<Reclamo> readByEstadoReclamo(Reclamo reclamo) {
        return reclamoDAO.readByEstadoReclamo(reclamo.getEstadoReclamo());
    }

     */

    public void update(General reclamo) {
        if (allowUpdate(reclamo)) {
            reclamoDAO.update(reclamo);
        }
    }

    public void update(Localizado reclamo) {
        if (allowUpdate(reclamo)) {
            reclamoDAO.update(reclamo);
        }
    }

    public boolean allowCreate(General reclamo){
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

    public boolean allowCreate(Localizado reclamo){
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

    public boolean allowUpdate(Reclamo reclamo) {
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
