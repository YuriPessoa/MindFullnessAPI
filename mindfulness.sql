DROP SCHEMA IF EXISTS mindfulness;
CREATE SCHEMA IF NOT EXISTS mindfulness;

USE mindfulness;

CREATE TABLE aluno (
    id_aluno INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(1000) NOT NULL,
    idade INT NOT NULL,
    PRIMARY KEY (id_aluno)
);

CREATE TABLE tarefa (
    id_tarefa INT NOT NULL AUTO_INCREMENT,
    id_aluno INT NOT NULL,
    descricao VARCHAR(1000) NOT NULL,
    termino VARCHAR(1000),
    PRIMARY KEY (id_tarefa),
    CONSTRAINT FK_tarefa_id_aluno FOREIGN KEY (id_aluno) REFERENCES aluno(id_aluno)
);

CREATE TABLE descricao (
    id_descricao INT NOT NULL AUTO_INCREMENT,
    descricao VARCHAR(1000) NOT NULL,
    aluno_id INT NOT NULL,
	PRIMARY KEY (id_descricao),
    CONSTRAINT FK_descricao_aluno_id FOREIGN KEY (aluno_id) REFERENCES aluno(id_aluno)
);

CREATE TABLE humor_diario (
    id_humor_diario INT NOT NULL AUTO_INCREMENT,
    data DATE NOT NULL,
    id_aluno INT NOT NULL,
    aluno_id INT NOT NULL,
    hora DATETIME NOT NULL,
    PRIMARY KEY (id_humor_diario),
    CONSTRAINT FK_humor_diario_id_aluno FOREIGN KEY (id_aluno) REFERENCES aluno(id_aluno)
);

CREATE TABLE tipo_humor_diario (
    id_tipo_humor_diario INT NOT NULL AUTO_INCREMENT,
    tipo_humor VARCHAR(45) NOT NULL,
	icone VARCHAR(45),
	PRIMARY KEY (id_tipo_humor_diario)
);

CREATE TABLE humor (
	id_humor_diario INT NOT NULL,
    id_tipo_humor_diario INT NOT NULL,
	CONSTRAINT FK_id_humor_diario FOREIGN KEY (id_humor_diario) REFERENCES humor_diario(id_humor_diario),
	CONSTRAINT FK_id_tipo_humor_diario FOREIGN KEY (id_tipo_humor_diario) REFERENCES tipo_humor_diario(id_tipo_humor_diario),
    PRIMARY KEY (id_humor_diario, id_tipo_humor_diario)
);
