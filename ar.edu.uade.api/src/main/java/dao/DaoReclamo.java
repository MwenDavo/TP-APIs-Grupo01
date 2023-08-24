package dao;

import pojo.Edificio;
import pojo.Reclamo;
import pojo.Usuario;

import java.util.List;

public interface DaoReclamo {
    List<Reclamo> getByState(String tipo);

    List<Reclamo> getByEdificio(Edificio edificio);

    List<Reclamo> getByUsuario(Usuario usuario);

    void save(Reclamo reclamo);

    void update(Reclamo reclamo);

    void delete(Reclamo reclamo);
}
