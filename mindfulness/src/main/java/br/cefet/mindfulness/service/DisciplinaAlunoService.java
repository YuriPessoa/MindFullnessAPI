package br.cefet.mindfulness.service;

import br.cefet.mindfulness.dao.DisciplinaAlunoDao;
import br.cefet.mindfulness.model.Aluno;
import br.cefet.mindfulness.model.DisciplinaAluno;
import java.util.List;
import org.jdbi.v3.core.Jdbi;
import org.springframework.stereotype.Service;

@Service
public class DisciplinaAlunoService {
    private final DisciplinaAlunoDao disciplinaAlunoDao;
    
    public DisciplinaAlunoService(Jdbi jdbi){
        this.disciplinaAlunoDao = jdbi.onDemand(DisciplinaAlunoDao.class);
    }
    
    public DisciplinaAluno inserir (DisciplinaAluno disciplinaAluno){
        disciplinaAlunoDao.insert(disciplinaAluno);
        return disciplinaAluno;
    }
    
    public List<Aluno> getByDisciplina(int idDisciplina){
        List<Aluno> alunoList = disciplinaAlunoDao.getAllByDisciplina(idDisciplina);
        return alunoList;
    }
    
    public Aluno get(int idDisciplina, int idAluno){
        Aluno aluno = disciplinaAlunoDao.get(idDisciplina, idAluno);
        return aluno;
    }
    
    public void delete(int idDisciplina, int idAluno){
        disciplinaAlunoDao.delete(idDisciplina, idAluno);
    }
    
    public void deleteAllByDisciplina(int idDisciplina){
        disciplinaAlunoDao.deleteAllByDisciplina(idDisciplina);
    }
}
