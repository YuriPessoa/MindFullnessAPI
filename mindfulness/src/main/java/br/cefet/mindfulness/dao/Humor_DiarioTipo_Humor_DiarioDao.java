package br.cefet.mindfulness.dao;

import br.cefet.mindfulness.model.Humor_DiarioTipo_Humor_Diario;
import br.cefet.mindfulness.model.Tipo_Humor_Diario;
import java.util.List;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

@RegisterBeanMapper(Tipo_Humor_Diario.class)
public interface Humor_DiarioTipo_Humor_DiarioDao {
        
    @SqlUpdate("insert into humor (id_tipo_humor_diario, id_humor_diario) values (:id_tipo_humor_diario, :id_humor_diario)")
    void insert(@BindBean Humor_DiarioTipo_Humor_Diario humor_diarioTipo_humor_diario);
    
    
    @SqlQuery("select thd.* " +
            " from tipo_humor_diario thd, humor h " +
            " where h.id_tipo_humor_diario = thd.id_tipo_humor_diario " +
            "   and h.id_humor_diario = :id_humor_diario " +
            "   and h.id_tipo_humor_diario = :id_tipo_humor_diario;")
    Tipo_Humor_Diario get(@Bind("id_humor_diario") int id_humor_diario, @Bind("id_tipo_humor_diario") int id_tipo_humor_diario);

    @SqlQuery("select thd.* " +
            " from tipo_humor_diario thd, humor h " +
            " where h.id_tipo_humor_diario = thd.id_tipo_humor_diario " +
            "   and h.id_humor_diario = :id_humor_diario;")
    List<Tipo_Humor_Diario> getAllByHumor_Diario(@Bind("id_humor_diario") int id_humor_diario);
    
    @SqlUpdate("delete " +
            " from humor h " +
            " where h.id_humor_diario = :id_humor_diario " +
            "   and h.id_tipo_humor_diario = :id_tipo_humor_diario;")
    int delete(@Bind("id_humor_diario") int id_humor_diario, @Bind("id_tipo_humor_diario") int id_tipo_humor_diario);
    
    @SqlUpdate("delete " +
            " from humor h " +
            " where h.id_humor_diario = :id_humor_diario;")
    int deleteAllByHumor_Diario(@Bind("id_humor_diario") int id_humor_diario);
}
