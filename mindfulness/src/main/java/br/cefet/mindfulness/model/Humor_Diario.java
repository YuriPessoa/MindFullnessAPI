package br.cefet.mindfulness.model;

import java.sql.Timestamp;
import java.sql.Date;

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
public class Humor_Diario {
    private int id_humor_diario;
    private Date data;
    private int id_aluno;
    private int aluno_id;
    private Timestamp hora;
}
