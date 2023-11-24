package br.cefet.mindfulness.controller;

import br.cefet.mindfulness.model.Tarefa;
import br.cefet.mindfulness.service.TarefaService;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tarefa")
public class TarefaController {
    
    private final TarefaService tarefaService;
    
    public TarefaController(TarefaService tarefaService){
        this.tarefaService = tarefaService;
    }
    
    @GetMapping({"/", ""})
    public List<Tarefa> consultarTodos(){
        List<Tarefa> alunoList = tarefaService.consultarTodos();
        return alunoList;
    }
    
    @GetMapping("/{id}")
    public Tarefa consultarTarefa(@PathVariable("id") int id){
        Tarefa ret = tarefaService.consultarPorId(id);
        return ret;
    }
    
    @PostMapping({"", "/"})
    public Tarefa inserir(@RequestBody Tarefa tarefa){
        Tarefa ret = tarefaService.inserir(tarefa);
        return ret;
    }
    
    @PutMapping({"", "/"})
    public Tarefa alterar(@RequestBody Tarefa tarefa){
        tarefaService.alterar(tarefa);
        return tarefa;
    }
    
    @DeleteMapping("/{id}")
    public Tarefa deletar(@PathVariable("id") int id){
        Tarefa aluno = tarefaService.consultarPorId(id);
        if (aluno == null){
            throw new RuntimeException("Nao existe aluno com este id para ser excluido....");
        }
        tarefaService.excluir(id);
        return aluno;
    }
}
