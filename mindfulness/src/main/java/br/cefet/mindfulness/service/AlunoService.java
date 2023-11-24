package br.cefet.mindfulness.service;

import br.cefet.mindfulness.dao.AlunoDao;
import br.cefet.mindfulness.dao.DescricaoDao;
import br.cefet.mindfulness.dao.TarefaDao;
import br.cefet.mindfulness.model.Aluno;
import br.cefet.mindfulness.model.Descricao;
import br.cefet.mindfulness.model.Tarefa;
import java.util.List;
import org.jdbi.v3.core.Jdbi;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {
    
    private final AlunoDao alunoDao;
    private final TarefaDao tarefaDao; 
    private final DescricaoDao descricaoDao; 
    
    public AlunoService(Jdbi jdbi){
        this.alunoDao = jdbi.onDemand(AlunoDao.class);
        this.tarefaDao = jdbi.onDemand(TarefaDao.class);
        this.descricaoDao = jdbi.onDemand(DescricaoDao.class);
    }
    
    public Aluno inserir (Aluno aluno){
        int idAluno = alunoDao.insert(aluno);
        aluno.setId_aluno(idAluno);
        return aluno;
    }
    
    public List<Aluno> consultarTodos(){
        List<Aluno> alunoList = alunoDao.getAll();
        
        for (Aluno aluno : alunoList) {
            List<Tarefa> tarefaList = tarefaDao.getAllByAluno(aluno.getId_aluno());
            aluno.setTarefas(tarefaList);
            List<Descricao> descricaoList = descricaoDao.getAllByAluno(aluno.getId_aluno());
            aluno.setDescricoes(descricaoList);
        }
        
        return alunoList;
    }
    
    public Aluno consultarPorId(int id){
        Aluno aluno = alunoDao.get(id);
        if (aluno != null){
            List<Tarefa> tarefaList = tarefaDao.getAllByAluno(aluno.getId_aluno());
            aluno.setTarefas(tarefaList);
            List<Descricao> descricaoList = descricaoDao.getAllByAluno(aluno.getId_aluno());
            aluno.setDescricoes(descricaoList);
        }
        return aluno;
    }
    
    public void alterar(Aluno aluno){
        alunoDao.update(aluno);
    }
    
    public void excluir(int id){
        alunoDao.delete(id);
    }
    
}
