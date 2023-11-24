package br.cefet.mindfulness.controller;

import br.cefet.mindfulness.model.Tipo_Humor_Diario;
import br.cefet.mindfulness.service.Tipo_Humor_DiarioService;

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
@RequestMapping("/api/v1/tipo_humor_diario")
public class Tipo_Humor_DiarioController {
    
    private final Tipo_Humor_DiarioService tipo_humor_diarioService;
    
    public Tipo_Humor_DiarioController(Tipo_Humor_DiarioService tipo_humor_diarioService){
        this.tipo_humor_diarioService = tipo_humor_diarioService;
    }
    
    @GetMapping({"/", ""})
    public List<Tipo_Humor_Diario> consultarTodos(){
        List<Tipo_Humor_Diario> alunoList = tipo_humor_diarioService.consultarTodos();
        return alunoList;
    }
    
    @GetMapping("/{id}")
    public Tipo_Humor_Diario consultar(@PathVariable("id") int id){
        Tipo_Humor_Diario ret = tipo_humor_diarioService.consultarPorId(id);
        return ret;
    }
    
    @PostMapping({"", "/"})
    public Tipo_Humor_Diario inserir(@RequestBody Tipo_Humor_Diario tipo_humor_diario){
        Tipo_Humor_Diario ret = tipo_humor_diarioService.inserir(tipo_humor_diario);
        return ret;
    }
    
    @PutMapping({"", "/"})
    public Tipo_Humor_Diario alterar(@RequestBody Tipo_Humor_Diario tipo_humor_diario){
        tipo_humor_diarioService.alterar(tipo_humor_diario);
        return tipo_humor_diario;
    }
    
    @DeleteMapping("/{id}")
    public Tipo_Humor_Diario deletar(@PathVariable("id") int id){
        Tipo_Humor_Diario aluno = tipo_humor_diarioService.consultarPorId(id);
        if (aluno == null){
            throw new RuntimeException("Nao existe aluno com este id para ser excluido....");
        }
        tipo_humor_diarioService.excluir(id);
        return aluno;
    }
}
