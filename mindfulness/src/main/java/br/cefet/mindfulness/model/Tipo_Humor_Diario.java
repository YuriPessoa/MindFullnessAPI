package br.cefet.mindfulness.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Tipo_Humor_Diario {
    private int id_tipo_humor_diario;
    private String tipo_humor;
    private String icone;
}
