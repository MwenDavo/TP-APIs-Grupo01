package application.model.dao;

import application.model.entity.Edificio;
import application.model.entity.Unidad;
import application.model.entity.UsuarioUnidad;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IEdificioDAO {
    void create(Edificio edificio);
    void createUnidad(Unidad unidad, Edificio edificio);
    Edificio read(long id);
    Edificio readByDireccion(String direccion);
    List<Edificio> readAll();
    Unidad readUnidad(long id);
    void borrarRelacion(UsuarioUnidad usuarioUnidad);
    void deleteUnidad(Unidad unidad);

}
