import app.model.dao.*;
import app.model.entity.*;
import app.util.EstadoReclamo;
import app.util.EstadoUnidad;
import app.util.TipoRelacion;
import app.util.TipoUsuario;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;


public class Test {
    @org.junit.jupiter.api.Test
    void test() {
        DaoEdificio daoEdificio = DaoEdificioMySQL.getInstance();
        DaoUsuario daoUsuario = DaoUsuarioMySQL.getInstance();
        DaoReclamo daoReclamo = DaoReclamoMySQL.getInstance();

        Edificio edificio = new Edificio("Gral. José de San Martín 1622", new ArrayList<Unidad>(), new ArrayList<General>());

        Unidad unidad1 = new Unidad(edificio, 0, 1, new ArrayList<UsuarioUnidad>(), new ArrayList<Localizado>());
        Unidad unidad2 = new Unidad(edificio, 1, 1, new ArrayList<UsuarioUnidad>(), new ArrayList<Localizado>());
        Unidad unidad3 = new Unidad(edificio, 1, 2, new ArrayList<UsuarioUnidad>(), new ArrayList<Localizado>());

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

        String[] nombres = new String[]{usuario1.getNombre(), usuario2.getNombre(), usuario3.getNombre()};
        List<Usuario> usuarios = daoUsuario.getAll();

        for (int i = 0; i < usuarios.size(); i++) {
            assertEquals(nombres[i], usuarios.get(i).getNombre());
        }

        UsuarioUnidad usuario1Unidad1 = new UsuarioUnidad(usuario1, unidad1, TipoRelacion.PROPIETARIO);
        UsuarioUnidad usuario2Unidad3 = new UsuarioUnidad(usuario2, unidad3, TipoRelacion.PROPIETARIO);
        UsuarioUnidad usuario3Unidad3 = new UsuarioUnidad(usuario3, unidad3, TipoRelacion.INQUILINO);

        usuario1.getUnidades().add(usuario1Unidad1);
        unidad1.getUsuarios().add(usuario1Unidad1);
        daoUsuario.update(usuario1);
        daoEdificio.updateDpto(unidad1);

        usuario2.getUnidades().add(usuario2Unidad3);
        unidad3.getUsuarios().add(usuario2Unidad3);
        daoUsuario.update(usuario2);
        daoEdificio.updateDpto(unidad3);

        usuario3.getUnidades().add(usuario3Unidad3);
        unidad3.getUsuarios().add(usuario3Unidad3);
        daoUsuario.update(usuario3);
        daoEdificio.updateDpto(unidad3);

        daoUsuario.delete(usuario1);

        daoUsuario.sacarUnidad(usuario3, unidad3);

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
        //TODO hay que arreglar las operaciones a la base de datos con LogReclamo y Reclamo (inconsistencias)
        LogEstadoReclamo logEstado = new LogEstadoReclamo(general,123123,"ABIERTO"," ");
        general.setEstado(EstadoReclamo.ABIERTO);


        daoReclamo.update(general,logEstado);

        EstadoReclamo[] estados = new EstadoReclamo[]{general.getEstado(), localizado.getEstado()};
        List<Reclamo> reclamos = daoReclamo.getAll();

        for (int i = 0; i < reclamos.size(); i++) {
            assertEquals(estados[i], reclamos.get(i).getEstado());
        }

        for (Reclamo reclamo :
                daoReclamo.getByState(EstadoReclamo.NUEVO)) {
            assertEquals(EstadoReclamo.NUEVO, reclamo.getEstado());
        }

        List<Edificio> edificioList = daoEdificio.getAll();

        for (Edificio e:
             edificioList) {
            List<Unidad> unidadList = e.getUnidades();

            for (Unidad u:
                 unidadList) {
                List<UsuarioUnidad> j = u.getUsuarios();
                System.out.println("hola");

            }
        }

    }

}
