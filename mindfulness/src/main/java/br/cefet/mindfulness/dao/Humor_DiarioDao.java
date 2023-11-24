package br.cefet.mindfulness.dao;

import br.cefet.mindfulness.model.Humor_Diario;
import java.util.List;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

@RegisterBeanMapper(Humor_Diario.class)
public interface Humor_DiarioDao {
            
@GetGeneratedKeys
    @SqlUpdate("insert into humor_diario (data, id_aluno, aluno_id, hora) values (:data, :id_aluno, :aluno_id, :hora)")
    int insert(@BindBean Humor_Diario humor_diario);
    
    
    @SqlQuery("select * " +
            " from humor_diario " +
            " where id_humor_diario = :id_humor_diario;")
    Humor_Diario get(@Bind("id_humor_diario") int id_humor_diario);

    
    @SqlQuery("select * " +
            " from humor_diario;")
    List<Humor_Diario> getAll();

    
    @SqlQuery("select * " +
            " from humor_diario " +
            " where id_aluno = :id_aluno;")
    List<Humor_Diario> getAllByAluno(@Bind("id_aluno") int id_aluno);


    @SqlUpdate("update humor_diario " +
            " set data = :data, id_aluno = :id_aluno, aluno_id = :aluno_id, hora = :hora " +
            " where id_humor_diario = :id_humor_diario;")
    int update(@BindBean Humor_Diario humor_diario);

    
    @SqlUpdate("delete " +
            " from humor_diario " +
            " where id_humor_diario = :id_humor_diario;")
    int delete(@Bind("id_humor_diario") int id_humor_diario);
}
