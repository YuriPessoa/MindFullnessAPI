package br.cefet.mindfulness.dao;

import br.cefet.mindfulness.model.Tipo_Humor_Diario;
import java.util.List;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

@RegisterBeanMapper(Tipo_Humor_Diario.class)
public interface Tipo_Humor_DiarioDao {

        @GetGeneratedKeys
        @SqlUpdate("insert into tipo_humor_diario (tipo_humor, icone) values (:tipo_humor, :icone)")
        int insert(@BindBean Tipo_Humor_Diario tipo_humor_diario);

        @SqlQuery("select * " +
                        " from tipo_humor_diario " +
                        " where id_tipo_humor_diario = :id_tipo_humor_diario;")
        Tipo_Humor_Diario get(@Bind("id_tipo_humor_diario") int id_tipo_humor_diario);

        @SqlQuery("select * from tipo_humor_diario;")
        List<Tipo_Humor_Diario> getAll();

        @SqlQuery("select * " +
                        " from tipo_humor_diario " +
                        " where tipo_humor = :tipo_humor;")
        List<Tipo_Humor_Diario> getAllByTipoHumor(@Bind("tipo_humor") String tipo_humor);

        @SqlUpdate("update tipo_humor_diario " +
                        " set tipo_humor = :tipo_humor, icone = :icone" +
                        " where id_tipo_humor_diario = :id_tipo_humor_diario;")
        int update(@BindBean Tipo_Humor_Diario tipo_humor_diario);

        @SqlUpdate("delete " +
                        " from tipo_humor_diario " +
                        " where id_tipo_humor_diario = :id_tipo_humor_diario;")
        int delete(@Bind("id_tipo_humor_diario") int id_tipo_humor_diario);
}
