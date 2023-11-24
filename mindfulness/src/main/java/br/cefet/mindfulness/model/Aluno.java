package br.cefet.mindfulness.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.Getter;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Aluno {
    private int id_aluno;
    private String nome;
    private int idade;
    
    private List<Tarefa> tarefas;
    private List<Descricao> descricoes;
}
