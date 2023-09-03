package app.model.dao;

import app.conexion.ConexionCassandra;
import app.model.entity.LogEstadoReclamo;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.querybuilder.insert.Insert;
import static com.datastax.oss.driver.api.querybuilder.QueryBuilder.*;

public class DaoLogReclamoCassandra implements DaoLogReclamo{
    private static DaoLogReclamoCassandra instance = null;

    private DaoLogReclamoCassandra(){

    }

    public static DaoLogReclamoCassandra getInstance() {
        if(instance == null){
            instance = new DaoLogReclamoCassandra();
        }
        return instance;
    }

    @Override
    public void saveLogEstadoReclamo(LogEstadoReclamo log) {
        CqlSession session = ConexionCassandra.getInstance().getSession();
        Insert query = insertInto("logEstadoReclamo")
                .value("idReclamo",literal(log.getIdReclamo()))
                .value("fechaHora",literal(log.getFechaHora()))
                .value("estado",literal(log.getEstado()))
                .value("descripcion",literal(log.getDescripcion()));
        session.execute(query.build());
    }
}
