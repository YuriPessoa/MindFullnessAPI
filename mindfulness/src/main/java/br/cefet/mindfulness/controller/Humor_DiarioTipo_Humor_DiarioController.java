package br.cefet.mindfulness.controller;

import br.cefet.mindfulness.model.Tipo_Humor_Diario;
import br.cefet.mindfulness.model.Humor_DiarioTipo_Humor_Diario;
import br.cefet.mindfulness.service.Humor_DiarioTipo_Humor_DiarioService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/humor_diario/{id_tipo_humor_diario}/tipo_humor_diario")
public class Humor_DiarioTipo_Humor_DiarioController {

    private final Humor_DiarioTipo_Humor_DiarioService humor_diarioTipo_humor_diarioService;

    public Humor_DiarioTipo_Humor_DiarioController(
            Humor_DiarioTipo_Humor_DiarioService humor_diarioTipo_humor_diarioService) {
        this.humor_diarioTipo_humor_diarioService = humor_diarioTipo_humor_diarioService;
    }

    @GetMapping({ "/", "" })
    public List<Tipo_Humor_Diario> consultarTodos(@PathVariable("id_tipo_humor_diario") int id_tipo_humor_diario) {
        List<Tipo_Humor_Diario> tipo_humor_diarioList = humor_diarioTipo_humor_diarioService
                .getByHumor_Diario(id_tipo_humor_diario);
        return tipo_humor_diarioList;
    }

    @GetMapping("/{id_humor_diario}")
    public Tipo_Humor_Diario consultarAluno(@PathVariable("id_tipo_humor_diario") int id_tipo_humor_diario,
            @PathVariable("id_humor_diario") int id_humor_diario) {
        Tipo_Humor_Diario tipo_humor_diario = humor_diarioTipo_humor_diarioService.get(id_tipo_humor_diario,
                id_humor_diario);
        return tipo_humor_diario;
    }

    @PostMapping({ "", "/" })
    public Tipo_Humor_Diario inserir(@RequestBody Humor_DiarioTipo_Humor_Diario humor_diarioTipo_humor_diario) {
        Tipo_Humor_Diario tipo_humor_diario = humor_diarioTipo_humor_diarioService
                .inserir(humor_diarioTipo_humor_diario);
        return tipo_humor_diario;
    }

    @DeleteMapping({ "", "/" })
    public List<Tipo_Humor_Diario> deletar(@PathVariable("id_tipo_humor_diario") int id_tipo_humor_diario) {
        List<Tipo_Humor_Diario> tipo_humor_diarioList = humor_diarioTipo_humor_diarioService
                .getByHumor_Diario(id_tipo_humor_diario);
        if (tipo_humor_diarioList == null || tipo_humor_diarioList.isEmpty()) {
            throw new RuntimeException(
                    "Nao existem tipo_humor_diarios com este id_tipo_humor_diario para ser excluido....");
        }
        humor_diarioTipo_humor_diarioService.deleteAllByHumor_Diario(id_tipo_humor_diario);
        return tipo_humor_diarioList;
    }

    @DeleteMapping("/{id_humor_diario}")
    public Tipo_Humor_Diario deletar(
            @PathVariable("id_tipo_humor_diario") int id_tipo_humor_diario,
            @PathVariable("id_humor_diario") int id_humor_diario) {
        Tipo_Humor_Diario tipo_humor_diario = humor_diarioTipo_humor_diarioService.get(id_tipo_humor_diario,
                id_humor_diario);
        if (tipo_humor_diario == null) {
            throw new RuntimeException("Nao existe tipo_humor_diario com este id para ser excluido....");
        }
        humor_diarioTipo_humor_diarioService.delete(id_tipo_humor_diario, id_humor_diario);
        return tipo_humor_diario;
    }

}
