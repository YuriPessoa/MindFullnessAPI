package br.cefet.mindfulness.controller;

import br.cefet.mindfulness.model.Humor_Diario;
import br.cefet.mindfulness.service.Humor_DiarioService;

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
@RequestMapping("/api/v1/humor_diario")
public class Humor_DiarioController {
    
    private final Humor_DiarioService humor_diarioService;
    
    public Humor_DiarioController(Humor_DiarioService humor_diarioService){
        this.humor_diarioService = humor_diarioService;
    }
    
    @GetMapping({"/", ""})
    public List<Humor_Diario> consultarTodos(){
        List<Humor_Diario> alunoList = humor_diarioService.consultarTodos();
        return alunoList;
    }
    
    @GetMapping("/{id}")
    public Humor_Diario consultar(@PathVariable("id") int id){
        Humor_Diario ret = humor_diarioService.consultarPorId(id);
        return ret;
    }
    
    @PostMapping({"", "/"})
    public Humor_Diario inserir(@RequestBody Humor_Diario humor_diario){
        Humor_Diario ret = humor_diarioService.inserir(humor_diario);
        return ret;
    }
    
    @PutMapping({"", "/"})
    public Humor_Diario alterar(@RequestBody Humor_Diario humor_diario){
        humor_diarioService.alterar(humor_diario);
        return humor_diario;
    }
    
    @DeleteMapping("/{id}")
    public Humor_Diario deletar(@PathVariable("id") int id){
        Humor_Diario aluno = humor_diarioService.consultarPorId(id);
        if (aluno == null){
            throw new RuntimeException("Nao existe aluno com este id para ser excluido....");
        }
        humor_diarioService.excluir(id);
        return aluno;
    }
}
