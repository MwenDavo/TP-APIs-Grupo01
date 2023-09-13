import app.conexion.ConexionMySQL;
import app.model.dao.*;
import app.model.entity.*;
import app.util.EstadoReclamo;
import app.util.EstadoUsuario;
import app.util.TipoRelacion;
import app.util.TipoUsuario;
import org.hibernate.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class test {
    private DaoEdificio daoEdificio = DaoEdificioMySQL.getInstance();
    private DaoReclamo daoReclamo = DaoReclamoMySQL.getInstance();
    private DaoUsuario daoUsuario = DaoUsuarioMySQL.getInstance();
    private Edificio edificio = null;
    private Unidad unidad = null;

    @BeforeEach
    public void initializing() {

        edificio = new Edificio("Libertad 3088");

        daoEdificio.create(edificio);

        Usuario usuario1 = new Usuario(TipoUsuario.ADMIN, "dgillig", "123", 11421390, "David Gillig", 1142139000);
        Usuario usuario2 = new Usuario(TipoUsuario.COMMON, "afernandez", "123", 11371350, "Ariana Fernández", 137135000);
        Usuario usuario3 = new Usuario(TipoUsuario.COMMON, "mmartin", "123", 11351770, "Máximo Martín", 1135177000);
        Usuario usuario4 = new Usuario(TipoUsuario.COMMON, "tmolina", "123", 11355330, "Tomás Molina", 1135533000);
        Usuario usuario5 = new Usuario(TipoUsuario.COMMON, "avitale", "123", 11439360, "Agustín Vitale", 1143936000);
        Usuario usuario6 = new Usuario(TipoUsuario.COMMON, "mfelau", "123", 11399940, "Matías Felau", 1139994000);
        Usuario usuario7 = new Usuario(TipoUsuario.COMMON, "vmartin", "123", 11406090, "Victoria Martín", 1140609000);

        daoUsuario.create(usuario1);
        daoUsuario.create(usuario2);
        daoUsuario.create(usuario3);
        daoUsuario.create(usuario4);
        daoUsuario.create(usuario5);
        daoUsuario.create(usuario6);
        daoUsuario.create(usuario7);

        Unidad unidad1 = new Unidad(edificio, 0, 1);
        Unidad unidad2 = new Unidad(edificio, 1, 1);
        Unidad unidad3 = new Unidad(edificio, 1, 2);
        Unidad unidad4 = new Unidad(edificio, 2, 1);
        Unidad unidad5 = new Unidad(edificio, 2, 2);

        edificio.getUnidades().add(unidad1);
        edificio.getUnidades().add(unidad2);
        edificio.getUnidades().add(unidad3);
        edificio.getUnidades().add(unidad4);
        edificio.getUnidades().add(unidad5);

        daoEdificio.update(edificio);

        UsuarioUnidad usuarioUnidad1 = new UsuarioUnidad(usuario1, unidad1, TipoRelacion.PROPIETARIO);
        UsuarioUnidad usuarioUnidad2 = new UsuarioUnidad(usuario2, unidad2, TipoRelacion.PROPIETARIO);
        UsuarioUnidad usuarioUnidad3 = new UsuarioUnidad(usuario3, unidad3, TipoRelacion.PROPIETARIO);
        UsuarioUnidad usuarioUnidad4 = new UsuarioUnidad(usuario4, unidad4, TipoRelacion.PROPIETARIO);
        UsuarioUnidad usuarioUnidad5 = new UsuarioUnidad(usuario5, unidad5, TipoRelacion.PROPIETARIO);
        UsuarioUnidad usuarioUnidad6 = new UsuarioUnidad(usuario6, unidad5, TipoRelacion.INQUILINO);

        usuario1.getUnidades().add(usuarioUnidad1);
        usuario2.getUnidades().add(usuarioUnidad2);
        usuario3.getUnidades().add(usuarioUnidad3);
        usuario4.getUnidades().add(usuarioUnidad4);
        usuario5.getUnidades().add(usuarioUnidad5);
        usuario6.getUnidades().add(usuarioUnidad6);

        unidad1.getUsuarios().add(usuarioUnidad1);
        unidad2.getUsuarios().add(usuarioUnidad2);
        unidad3.getUsuarios().add(usuarioUnidad3);
        unidad4.getUsuarios().add(usuarioUnidad4);
        unidad5.getUsuarios().add(usuarioUnidad5);
        unidad5.getUsuarios().add(usuarioUnidad6);

        daoUsuario.update(usuario1);
        daoUsuario.update(usuario2);
        daoUsuario.update(usuario3);
        daoUsuario.update(usuario4);
        daoUsuario.update(usuario5);
        daoUsuario.update(usuario6);

        this.unidad = unidad5;

        daoReclamo.create(new General("este es un reclamo de prueba", null, usuario6, edificio));
    }

    @Test
    @DisplayName("crear un reclamo general exitoso y uno fallido para luego leer")
    /*
        Se cumple con los siguientes requerimientos:
            -Registrar el acceso a la aplicación mediante un usuario y un password.
            -Identificarlo como un usuario válido.
            -Solicitar datos identificatorios del lugar del reclamo.
            -Ingresar una descripción libre del reclamo.
            -Adjuntar una o más fotos del desperfecto o problema.
            -Una vez que los datos son enviados para su registración, debe devolver a la aplicación el número de reclamo generado para su posterior consulta.
     */
    public void testing1() {

        Usuario usuario1 = new Usuario();
        usuario1.setUser("mfelau");
        usuario1.setPassword("123");

        usuario1 = daoUsuario.read(usuario1);

        General reclamoExitoso = new General("este es un reclamo exitoso", null, usuario1, edificio);

        if (cargarEnGeneral(reclamoExitoso)) {

            if (daoReclamo.create(reclamoExitoso)) {

                edificio.getReclamos().add(reclamoExitoso);
                System.out.printf("Su número de reclamo es: %d%n", reclamoExitoso.getId());
            }
        }

        Assertions.assertTrue(reclamoExitoso.equals(daoReclamo.read(1)));

        Usuario usuario2 = new Usuario();
        usuario2.setUser("vmartin");
        usuario2.setPassword("123");

        usuario2 = daoUsuario.read(usuario2);

        General reclamoFallido = new General("este es un reclamo fallido", null, usuario2, edificio);

        if (cargarEnGeneral(reclamoFallido)) {

            if (daoReclamo.create(reclamoFallido)) {

                edificio.getReclamos().add(reclamoFallido);
                System.out.printf("Su número de reclamo es: %d%n", reclamoFallido.getId());
            }
        }

        Assertions.assertFalse(reclamoFallido.equals(daoReclamo.read(2)));
    }

    @Test
    @DisplayName("crear un reclamo localizado exitoso y uno fallido para luego redimirlo y leer")
    /*
        Se cumple con los siguientes requerimientos:
            -Registrar el acceso a la aplicación mediante un usuario y un password.
            -Identificarlo como un usuario válido.
            -Solicitar datos identificatorios del lugar del reclamo.
            -Ingresar una descripción libre del reclamo.
            -Adjuntar una o más fotos del desperfecto o problema.
            -Una vez que los datos son enviados para su registración, debe devolver a la aplicación el número de reclamo generado para su posterior consulta.
     */
    public void testing2() {

        Usuario usuario1 = new Usuario();
        usuario1.setUser("mfelau");
        usuario1.setPassword("123");

        usuario1 = daoUsuario.read(usuario1);

        Localizado reclamoExitoso = new Localizado("este es un reclamo exitoso", null, usuario1, unidad);

        if (cargarEnLocalizado(reclamoExitoso)) {

            if (daoReclamo.create(reclamoExitoso)) {

                unidad.getReclamos().add(reclamoExitoso);
                System.out.printf("Su número de reclamo es: %d%n", reclamoExitoso.getId());
            }
        }

        Assertions.assertTrue(reclamoExitoso.equals(daoReclamo.read(2)));

        Usuario usuario2 = new Usuario();
        usuario2.setUser("avitale");
        usuario2.setPassword("123");

        usuario2 = daoUsuario.read(usuario2);

        Localizado reclamoFallido = new Localizado("este es un reclamo fallido", null, usuario2, unidad);

        if (cargarEnLocalizado(reclamoFallido)) {

            if (daoReclamo.create(reclamoFallido)) {

                unidad.getReclamos().add(reclamoFallido);
                System.out.printf("Su número de reclamo es: %d%n", reclamoFallido.getId());
            }
        }

        Assertions.assertFalse(reclamoFallido.equals(daoReclamo.read(3)));

        daoUsuario.updateUnidades(usuario1, unidad);

        Localizado reclamoRedimido = reclamoFallido;

        reclamoRedimido.setDescripcion("este es un reclamo redimido");

        if (cargarEnLocalizado(reclamoRedimido)) {

            if (daoReclamo.create(reclamoRedimido)) {

                unidad.getReclamos().add(reclamoRedimido);
                System.out.printf("Su número de reclamo es: %d%n", reclamoRedimido.getId());
            }
        }

        Assertions.assertTrue(reclamoFallido.equals(daoReclamo.read(3)));
    }

    @Test
    @DisplayName("leer los reclamos pertenecientes a los edificios que pertenezca un usuario")
    /*
        LO CONSEGUI HIJOS DE PUTA
        ES EL MEJOR MOMENTO DE MI VIDA
        QUIERO AGRADECER A LA ESCUELA Y LA FAMILIA
        MUCHAS GRACIAS HIJOS DE PUTA
     */
    public void testing3() {

        Usuario usuario = new Usuario();
        usuario.setUser("mfelau");
        usuario.setPassword("123");

        usuario = daoUsuario.read(usuario);

        Set<Edificio> edificios = new HashSet<>();

        for (UsuarioUnidad usuarioUnidad : usuario.getUnidades()) {

            edificios.add(usuarioUnidad.getUnidad().getEdificio());
        }

        List<General> reclamos = new ArrayList<>();

        for (Edificio edificio : edificios) {

            reclamos.addAll(daoReclamo.readByEdificio(edificio));
        }

        for (General reclamo : reclamos) {

            System.out.printf("Reclamo %d del edificio en %s en estado %s: %s%n", reclamo.getId(), reclamo.getEdificio().getDireccion(), reclamo.getEstado(), reclamo.getDescripcion());
        }
    }

    @Test
    @DisplayName("leer los reclamos por estado")
    public void testing4 () {

        List<Reclamo> reclamos = daoReclamo.readByEstadoReclamo(EstadoReclamo.NUEVO);

        for (Reclamo reclamo : reclamos) {

            System.out.printf("Reclamo %d en estado %s%n", reclamo.getId(), reclamo.getEstado());
        }
    }

    @Test
    @DisplayName("actualizar el estado de un reclamo")
    public void testing5 () {

        Reclamo reclamo = daoReclamo.read(1);

        Log log = new Log(EstadoReclamo.ABIERTO, "se esta realizando una prueba", reclamo);

        if (daoReclamo.update(reclamo, log)) {

            reclamo.setEstado(EstadoReclamo.ABIERTO);
        }

        reclamo = daoReclamo.read(1);

        Assertions.assertEquals(reclamo.getEstado(), EstadoReclamo.ABIERTO);

        log = daoReclamo.readByReclamo(reclamo).get(0);

        Assertions.assertEquals(log.getDescripcion(), "se esta realizando una prueba");
    }

    @Test
    @DisplayName("actualizar usuarios")
    public void testing6 () {

        Usuario usuario = new Usuario();
        usuario.setUser("mfelau");
        usuario.setPassword("123");

        usuario = daoUsuario.read(usuario);

        usuario.setTelefono(1159595600);

        daoUsuario.update(usuario);

        usuario = daoUsuario.read(usuario);

        Assertions.assertEquals(usuario.getTelefono(), 1159595600);

        daoUsuario.updateUnidades(usuario, unidad);

        if (usuario.getUnidades().isEmpty()) {

            usuario.setEstadoUsuario(EstadoUsuario.ELIMINADO);
            usuario.setUser(null);
            usuario.setPassword(null);

            daoUsuario.update(usuario);
        }
    }

    public static boolean cargarEnGeneral (General reclamo){

        ConexionMySQL connection = ConexionMySQL.getInstance();
        Session session = connection.getSession();

        Edificio edificio = session.find(Edificio.class, reclamo.getEdificio().getId());

        for (Unidad unidad : edificio.getUnidades()) {
            for (UsuarioUnidad usuarioUnidad : unidad.getUsuarios()) {
                if (reclamo.getUsuario().getId() == usuarioUnidad.getUsuario().getId()) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean cargarEnLocalizado (Localizado reclamo){

        ConexionMySQL connection = ConexionMySQL.getInstance();
        Session session = connection.getSession();

        Unidad unidad = session.find(Unidad.class, reclamo.getUnidad().getId());

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
}


