package app.conexion;

import com.datastax.oss.driver.api.core.CqlSession;

import java.net.InetSocketAddress;

public class ConexionCassandra {
    private CqlSession session;
    private static ConexionCassandra instance = null;

    private ConexionCassandra(){
        session = CqlSession.builder()
                .addContactPoint(new InetSocketAddress("localhost",9042))
                .withLocalDatacenter("datacenter1")
                .build();
    }

    public static ConexionCassandra getInstance() {
        if(instance==null){
            instance = new ConexionCassandra();
        }
        return instance;
    }

    public CqlSession getSession() {
        return session;
    }
}
