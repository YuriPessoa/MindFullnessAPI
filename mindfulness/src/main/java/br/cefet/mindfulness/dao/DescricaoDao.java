package br.cefet.mindfulness.dao;

import br.cefet.mindfulness.model.Descricao;
import java.util.List;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

@RegisterBeanMapper(Descricao.class)
public interface DescricaoDao {
    
    @GetGeneratedKeys
    @SqlUpdate("insert into descricao (descricao, aluno_id) values (:descricao, :aluno_id)")
    int insert(@BindBean Descricao descricao);
    
    
    @SqlQuery("select * " +
            " from descricao " +
            " where id_descricao = :id_descricao;")
    Descricao get(@Bind("id_descricao") int id_descricao);

    
    @SqlQuery("select * " +
            " from descricao;")
    List<Descricao> getAll();

    
    @SqlQuery("select * " +
            " from descricao " +
            " where aluno_id = :aluno_id;")
    List<Descricao> getAllByAluno(@Bind("aluno_id") int aluno_id);


    @SqlUpdate("update descricao " +
            " set descricao = :descricao, aluno_id = :aluno_id " +
            " where id_descricao = :id_descricao;")
    int update(@BindBean Descricao descricao);

    
    @SqlUpdate("delete " +
            " from descricao " +
            " where id_descricao = :id_descricao;")
    int delete(@Bind("id_descricao") int id_descricao);
}
