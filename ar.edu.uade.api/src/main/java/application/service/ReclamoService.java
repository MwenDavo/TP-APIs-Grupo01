package application.service;

import application.model.dao.IReclamoDAO;
import application.model.dao.IUsuarioDAO;
import application.model.entity.*;
import application.model.util.ComprobacionRol;
import application.model.util.EstadoReclamo;
import application.model.util.TipoRelacion;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReclamoService implements IReclamoService {
    @Autowired
    private IReclamoDAO reclamoDAO;
    @Autowired
    private IUsuarioDAO usuarioDAO;

    @Override
    public void create(General general) {
        if (allowCreate(general)) {
            reclamoDAO.create(general);
        }
    }

    @Override
    public void create(Localizado localizado) {
        if (allowCreate(localizado)) {
            reclamoDAO.create(localizado);
        }
    }

    public List<Reclamo> readByDescripcion(String desc){
        return reclamoDAO.readByDescripcion(desc);
    }

    @Override
    public Localizado readLocalizado(long id) {
        return reclamoDAO.readLocalizado(id);
    }

    @Override
    public General readGeneral(long id) {
        return reclamoDAO.readGeneral(id);
    }

    @Override
    public void updateLocalizado(long id, Log log, String username) {
        Localizado reclamo = reclamoDAO.readLocalizado(id);
        Usuario usuario = usuarioDAO.readByUsername(username);
        if (ComprobacionRol.comprobarAdmin(usuario)){
            if (allowUpdate(reclamo)) {
                reclamo.setEstadoReclamo(log.getEstadoReclamo());
                reclamo.getHistorial().add(log);
                log.setReclamo(reclamo);
                reclamoDAO.updateLocalizado(reclamo);
            }
        }

    }

    @Override
    @Transactional
    public void updateGeneral(long id, Log log, String username) {
        General reclamo = reclamoDAO.readGeneral(id);
        Usuario usuario = usuarioDAO.readByUsername(username);
        if (ComprobacionRol.comprobarAdmin(usuario)){
            if (allowUpdate(reclamo)) {
                reclamo.setEstadoReclamo(log.getEstadoReclamo());
                reclamo.getHistorial().add(log);
                log.setReclamo(reclamo);
                reclamoDAO.updateGeneral(reclamo);
            }
        }

    }

    @Override
    @Transactional
    public void cargarFotoGeneral(long id, Foto imagen) {
        General reclamo = reclamoDAO.readGeneral(id);
        List<Foto> foto = new ArrayList<>();
        foto.add(imagen);
        if (allowUpdate(reclamo)) {
            reclamo.setFotos(foto);
            reclamoDAO.updateGeneral(reclamo);
        }


    }

    @Override
    @Transactional
    public void cargarFotoLocalizado(long id, Foto imagen) {
        Localizado reclamo = reclamoDAO.readLocalizado(id);
        List<Foto> foto = new ArrayList<>();
        foto.add(imagen);
        if (allowUpdate(reclamo)) {
            reclamo.setFotos(foto);
            reclamoDAO.updateLocalizado(reclamo);
        }


    }

    private boolean allowCreate(General general){
        Edificio edificio = general.getEdificio();
        for (Unidad unidad : edificio.getUnidades()) {
            for (UsuarioUnidad usuarioUnidad : unidad.getUsuarios()) {
                if (general.getUsuario().getId() == usuarioUnidad.getUsuario().getId()) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean allowCreate(Localizado localizado){
        Unidad unidad = localizado.getUnidad();
        if (unidad.getUsuarios().size() == 2) {
            for (UsuarioUnidad usuarioUnidad : unidad.getUsuarios()) {
                if (localizado.getUsuario().getId() == usuarioUnidad.getUsuario().getId()) {
                    return usuarioUnidad.getTipoRelacion() == TipoRelacion.INQUILINO;
                }
            }
        }
        if (unidad.getUsuarios().size() == 1) {
            for (UsuarioUnidad usuarioUnidad : unidad.getUsuarios()) {
                if (localizado.getUsuario().getId() == usuarioUnidad.getUsuario().getId()) {
                    return usuarioUnidad.getTipoRelacion() == TipoRelacion.PROPIETARIO;
                }
            }
        }
        return false;
    }


    private boolean allowUpdate(Reclamo reclamo) {
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
