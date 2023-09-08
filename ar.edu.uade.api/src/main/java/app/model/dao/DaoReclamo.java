package app.model.dao;

import app.conexion.ConexionMySQL;
import app.model.entity.Edificio;
import app.model.entity.LogEstadoReclamo;
import app.model.entity.Reclamo;
import app.model.entity.Usuario;
import app.util.EstadoReclamo;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public interface DaoReclamo {

    List<Reclamo> getByState(EstadoReclamo estado);

    @Deprecated
    List<Reclamo> getByEdificio(Edificio edificio);

    @Deprecated
    List<Reclamo> getByUsuario(Usuario usuario);

    List<Reclamo> getAll();

    void save(Reclamo reclamo);

    void update(Reclamo reclamo, LogEstadoReclamo log);

    List<LogEstadoReclamo> getByReclamo(Reclamo reclamo);
}
