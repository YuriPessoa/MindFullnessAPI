package br.cefet.mindfulness.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Descricao {
    private int id_descricao;
    private String descricao;
    private int aluno_id;
}
