
package br.cefet.mindfulness.controller;

import br.cefet.mindfulness.model.Descricao;
import br.cefet.mindfulness.service.DescricaoService;
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
@RequestMapping("/api/v1/descricao")
public class DescricaoController {
    private final DescricaoService descricaoService;
    
    public DescricaoController(DescricaoService descricaoService){
        this.descricaoService = descricaoService;
    }
    
    @GetMapping({"/", ""})
    public List<Descricao> consultarTodos(){
        List<Descricao> alunoList = descricaoService.consultarTodos();
        return alunoList;
    }
    
    @GetMapping("/{id}")
    public Descricao consultar(@PathVariable("id") int id){
        Descricao ret = descricaoService.consultarPorId(id);
        return ret;
    }
    
    @PostMapping({"", "/"})
    public Descricao inserir(@RequestBody Descricao descricao){
        Descricao ret = descricaoService.inserir(descricao);
        return ret;
    }
    
    @PutMapping({"", "/"})
    public Descricao alterar(@RequestBody Descricao descricao){
        descricaoService.alterar(descricao);
        return descricao;
    }
    
    @DeleteMapping("/{id}")
    public Descricao deletar(@PathVariable("id") int id){
        Descricao aluno = descricaoService.consultarPorId(id);
        if (aluno == null){
            throw new RuntimeException("Nao existe aluno com este id para ser excluido....");
        }
        descricaoService.excluir(id);
        return aluno;
    }
}
