package br.cefet.mindfulness.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Tarefa {
    private int id_tarefa;
    private int id_aluno;
    private String descricao;
    private String termino;
}
