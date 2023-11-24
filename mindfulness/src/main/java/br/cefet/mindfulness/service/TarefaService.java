package br.cefet.mindfulness.service;

import br.cefet.mindfulness.dao.TarefaDao;
import br.cefet.mindfulness.model.Tarefa;
import java.util.List;
import org.jdbi.v3.core.Jdbi;
import org.springframework.stereotype.Service;

@Service
public class TarefaService {
    
    private final TarefaDao tarefaDao;
    
    public TarefaService(Jdbi jdbi){
        this.tarefaDao = jdbi.onDemand(TarefaDao.class);
    }
    
    public Tarefa inserir (Tarefa tarefa){
        int id = tarefaDao.insert(tarefa);
        tarefa.setId_tarefa(id);
        return tarefa;
    }
    
    public List<Tarefa> consultarTodos(){
        List<Tarefa> tarefaList = tarefaDao.getAll();
        return tarefaList;
    }
    
    public Tarefa consultarPorId(int id){
        Tarefa aluno = tarefaDao.get(id);
        return aluno;
    }
    
    public void alterar(Tarefa tarefa){
        tarefaDao.update(tarefa);
    }
    
    public void excluir(int id){
        tarefaDao.delete(id);
    }
    
}
