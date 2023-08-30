import app.model.dao.*;
import app.model.entity.*;
import app.util.EstadoReclamo;
import app.util.EstadoUnidad;
import app.util.TipoRelacion;
import app.util.TipoUsuario;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;


public class ReclamoTest {
    @Test
    void test(){
        DaoEdificio daoEdificio = DaoEdificioMySQL.getInstance();
        DaoUsuario daoUsuario = DaoUsuarioMySQL.getInstance();
        DaoReclamo daoReclamo = DaoReclamoMySQL.getInstance();

        Edificio edificio = new Edificio("Gral. José de San Martín 1622", new ArrayList<Unidad>(), new ArrayList<General>());

        Unidad unidad1 = new Unidad(edificio, 0, 1, EstadoUnidad.DESHABITADA, new ArrayList<UsuarioUnidad>(), new ArrayList<Localizado>());
        Unidad unidad2 = new Unidad(edificio, 1, 1, EstadoUnidad.DESHABITADA, new ArrayList<UsuarioUnidad>(), new ArrayList<Localizado>());
        Unidad unidad3 = new Unidad(edificio, 1, 2, EstadoUnidad.DESHABITADA, new ArrayList<UsuarioUnidad>(), new ArrayList<Localizado>());

        List<Unidad> unidadesEdificio = edificio.getUnidades();

        unidadesEdificio.add(unidad1);
        unidadesEdificio.add(unidad2);
        unidadesEdificio.add(unidad3);

        daoEdificio.save(edificio);

        List<Edificio> edificios = daoEdificio.getAll();

        assertEquals(edificio.getDireccion(), edificios.get(0).getDireccion());

        Credencial credencialUsuario1 = new Credencial("Carlitos", "");
        Credencial credencialUsuario2 = new Credencial("Emmix", "");
        Credencial credencialUsuario3 = new Credencial("Juango23", "");

        Usuario usuario1 = new Usuario(TipoUsuario.ADMIN, 37846194, "Carlos Lambustio", 1155439782, new ArrayList<UsuarioUnidad>(), new ArrayList<Reclamo>());
        Usuario usuario2 = new Usuario(TipoUsuario.COMMON, 34156287, "Emilia Villareal", 1149772135, new ArrayList<UsuarioUnidad>(), new ArrayList<Reclamo>());
        Usuario usuario3 = new Usuario(TipoUsuario.COMMON, 40187561, "Juan Gómez", 1122874698, new ArrayList<UsuarioUnidad>(), new ArrayList<Reclamo>());

        daoUsuario.save(credencialUsuario1, usuario1);
        daoUsuario.save(credencialUsuario2, usuario2);
        daoUsuario.save(credencialUsuario3, usuario3);

        assertEquals(usuario1.getNombre(), daoUsuario.get(credencialUsuario1).getNombre());

        String[] nombres = new String[] {usuario1.getNombre(), usuario2.getNombre(), usuario3.getNombre()};
        List<Usuario> usuarios = daoUsuario.getAll();

        for (int i = 0 ; i < usuarios.size() ; i++) {
            assertEquals(nombres[i], usuarios.get(i).getNombre());
        }

        UsuarioUnidad usuario1Unidad1 = new UsuarioUnidad(TipoRelacion.PROPIETARIO, usuario1, unidad1);
        UsuarioUnidad usuario2Unidad3 = new UsuarioUnidad(TipoRelacion.PROPIETARIO, usuario2, unidad3);
        UsuarioUnidad usuario3Unidad3 = new UsuarioUnidad(TipoRelacion.INQUILINO, usuario3, unidad3);

        unidad1.getUsuarios().add(usuario1Unidad1);
        unidad3.getUsuarios().add(usuario2Unidad3);
        unidad3.getUsuarios().add(usuario3Unidad3);

        unidad1.setEstado(EstadoUnidad.HABITADA);
        unidad3.setEstado(EstadoUnidad.ALQUILADA);

        usuario1.getUnidades().add(usuario1Unidad1);
        usuario2.getUnidades().add(usuario2Unidad3);
        usuario3.getUnidades().add(usuario3Unidad3);

        daoEdificio.updateDpto(unidad1);
        daoEdificio.updateDpto(unidad3);

        usuario1.setTelefono(1126676874);

        //TODO al eliminar un Usuario de una Unidad no se actualiza en la tabla intermedia

        //TODO no se puede eliminar un Usuario

        //TODO aún no se comprueba si el Usuario es parte del Edificio o de la Unidad y si es PROPIETARIO o INQUILINO antes de cargar un Reclamo

        General general = new General("No hay luz en las escaleras.", null, usuario3, EstadoReclamo.NUEVO, edificio);
/*
        edificio.getReclamos().add(general);

        daoEdificio.update(edificio);
 */
        daoReclamo.save(general);

        Localizado localizado = new Localizado("Pierde la canilla de la cocina.", null, usuario3, EstadoReclamo.NUEVO, unidad3);
/*
        unidad3.getReclamos().add(general);

        daoEdificio.updateDpto(unidad3);
 */
        daoReclamo.save(localizado);

        //TODO logear el cambio de Estado en Cassandra

        general.setEstado(EstadoReclamo.ABIERTO);

        daoReclamo.update(general);

        EstadoReclamo[] estados = new EstadoReclamo[] {general.getEstado(), localizado.getEstado()};
        List<Reclamo> reclamos = daoReclamo.getAll();

        for (int i = 0 ; i < reclamos.size() ; i++) {
            assertEquals(estados[i], reclamos.get(i).getEstado());
        }

        for (Reclamo reclamo:
             daoReclamo.getByState(EstadoReclamo.NUEVO)) {
            assertEquals(EstadoReclamo.NUEVO, reclamo.getEstado());
        }

        //TODO probar update y delete de DaoEdificio y DaoUsuario
    }
}
