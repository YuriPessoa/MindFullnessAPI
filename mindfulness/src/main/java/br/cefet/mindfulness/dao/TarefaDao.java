package br.cefet.mindfulness.dao;

import br.cefet.mindfulness.model.Tarefa;
import java.util.List;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

@RegisterBeanMapper(Tarefa.class)
public interface TarefaDao {
    
    @GetGeneratedKeys
    @SqlUpdate("insert into tarefa (id_aluno, descricao, termino) values (:id_aluno, :descricao, :termino)")
    int insert(@BindBean Tarefa tarefa);
    
    
    @SqlQuery("select * " +
            " from tarefa " +
            " where id_tarefa = :id_tarefa;")
    Tarefa get(@Bind("id_tarefa") int id_tarefa);

    
    @SqlQuery("select * " +
            " from tarefa " +
            " order by descricao;")
    List<Tarefa> getAll();

    @SqlQuery("select * " +
            " from tarefa " +
            " where id_aluno like :id_aluno " +
            " order by descricao;")
    List<Tarefa> getAllByAluno(@Bind("id_aluno") int id_aluno);

    
    @SqlQuery("select * " +
            " from tarefa " +
            " where descricao like :descricao " +
            " order by descricao;")
    List<Tarefa> getAllByDescricao(@Bind("descricao") String descricao);


    @SqlUpdate("update tarefa " +
            " set id_aluno = :id_aluno, descricao = :descricao, termino = :termino " +
            " where id_tarefa = :id_tarefa;")
    int update(@BindBean Tarefa tarefa);

    
    @SqlUpdate("delete " +
            " from tarefa " +
            " where id_tarefa = :id_tarefa;")
    int delete(@Bind("id_tarefa") int id_tarefa);

}
