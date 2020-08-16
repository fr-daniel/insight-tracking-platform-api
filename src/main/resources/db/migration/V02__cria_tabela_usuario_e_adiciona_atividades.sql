CREATE TABLE usuario (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    telefone VARCHAR(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE usuario_atividade (
    id_usuario BIGINT(20) NOT NULL,
    id_atividade BIGINT(20) NOT NULL,
    PRIMARY KEY (id_usuario, id_atividade),
    FOREIGN KEY (id_usuario) REFERENCES usuario(id) ON DELETE CASCADE,
    FOREIGN KEY (id_atividade) REFERENCES atividade(id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO usuario (id, nome, email, telefone) values (1, 'Gilbert K. Anderson', 'gilbertKAnderson@teleworm.us', '88900223344');
INSERT INTO usuario (id, nome, email, telefone) values (2, 'Elmira L. Cullen', 'elmiraLCullen@armyspy.com', '3307071457');
INSERT INTO usuario (id, nome, email, telefone) values (3, 'Manuel Moreno', 'manuel.moreno@example.com', '(9373512546');

INSERT INTO atividade(id, titulo, descricao) values (1, 'Treinamento ReactJS', 'Treinamento Completo ReactJs');
INSERT INTO atividade(id, titulo, descricao) values (2, 'Curso JavaScript', 'Curso completo de JavaScript');

INSERT INTO usuario_atividade (id_usuario, id_atividade) values (1, 1);
INSERT INTO usuario_atividade (id_usuario, id_atividade) values (1, 2);
INSERT INTO usuario_atividade (id_usuario, id_atividade) values (2, 1);
INSERT INTO usuario_atividade (id_usuario, id_atividade) values (3, 2);