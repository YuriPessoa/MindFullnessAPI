package br.cefet.mindfulness.dao;

import br.cefet.mindfulness.model.Aluno;
import java.util.List;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

@RegisterBeanMapper(Aluno.class)
public interface AlunoDao {
    
    @GetGeneratedKeys
    @SqlUpdate("insert into aluno (nome, idade) values (:nome, :idade)")
    int insert(@BindBean Aluno aluno);
    
    
    @SqlQuery("select * " +
            " from aluno " +
            " where id_aluno = :id_aluno;")
    Aluno get(@Bind("id_aluno") int id_aluno);

    
    @SqlQuery("select * " +
            " from aluno " +
            " order by nome;")
    List<Aluno> getAll();

    
    @SqlQuery("select * " +
            " from aluno " +
            " where nome like :nome " +
            " order by nome;")
    List<Aluno> getAllByName(@Bind("nome") String nome);


    @SqlUpdate("update aluno " +
            " set nome = :nome, " +
            "     idade = :idade " +
            " where id_aluno = :id_aluno;")
    int update(@BindBean Aluno aluno);

    
    @SqlUpdate("delete " +
            " from aluno " +
            " where id_aluno = :id_aluno;")
    int delete(@Bind("id_aluno") int id_aluno);

}
