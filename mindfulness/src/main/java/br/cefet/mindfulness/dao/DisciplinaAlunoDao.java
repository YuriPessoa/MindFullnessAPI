package br.cefet.mindfulness.dao;

import br.cefet.mindfulness.model.DisciplinaAluno;
import br.cefet.mindfulness.model.Aluno;
import java.util.List;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

@RegisterBeanMapper(Aluno.class)
public interface DisciplinaAlunoDao {
        
    @SqlUpdate("insert into aluno_disciplina (idAluno, idDisciplina) values (:id, :idDisciplina)")
    void insert(@BindBean DisciplinaAluno disciplinaAluno);
    
    
    @SqlQuery("select * " +
            " from aluno a, aluno_disciplina ad " +
            " where ad.idAluno = a.id " +
            "   and ad.idDisciplina = :idDisciplina " +
            "   and ad.idAluno = :idAluno;")
    Aluno get(@Bind("idDisciplina") int idDisciplina, @Bind("idAluno") int idAluno);

    @SqlQuery("select * " +
            " from aluno a, aluno_disciplina ad " +
            " where ad.idAluno = a.id " +
            "   and ad.idDisciplina = :idDisciplina;")
    List<Aluno> getAllByDisciplina(@Bind("idDisciplina") int idDisciplina);
    
    @SqlUpdate("delete " +
            " from aluno_disciplina ad " +
            " where ad.idDisciplina = :idDisciplina " +
            "   and ad.idAluno = :idAluno;")
    int delete(@Bind("idDisciplina") int idDisciplina, @Bind("idAluno") int idAluno);
    
    @SqlUpdate("delete " +
            " from aluno_disciplina ad " +
            " where ad.idDisciplina = :idDisciplina;")
    int deleteAllByDisciplina(@Bind("idDisciplina") int idDisciplina);
}
