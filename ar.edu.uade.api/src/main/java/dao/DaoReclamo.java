package dao;

import pojo.Edificio;
import pojo.Reclamo;
import pojo.Usuario;

import java.util.List;

public interface DaoReclamo {

    List<Reclamo> getByState(String estado);

    @Deprecated
    List<Reclamo> getByEdificio(Edificio edificio);

    @Deprecated
    List<Reclamo> getByUsuario(Usuario usuario);

    List<Reclamo> getAll();

    void save(Reclamo reclamo);

    void update(Reclamo reclamo);

    void delete(Reclamo reclamo);
}
