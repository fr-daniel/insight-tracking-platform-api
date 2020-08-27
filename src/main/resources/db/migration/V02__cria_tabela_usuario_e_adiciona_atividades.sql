CREATE TABLE usuario (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    telefone VARCHAR(100) NOT NULL,
    descricao_pessoal TEXT,
    endereco VARCHAR(150),
    cep VARCHAR(20),
    cidade VARCHAR(100),
    estado VARCHAR(50)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE usuario_atividade (
    id_usuario BIGINT(20) NOT NULL,
    id_atividade BIGINT(20) NOT NULL,
    PRIMARY KEY (id_usuario, id_atividade),
    FOREIGN KEY (id_usuario) REFERENCES usuario(id) ON DELETE CASCADE,
    FOREIGN KEY (id_atividade) REFERENCES atividade(id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO usuario (id, nome, email, telefone, descricao_pessoal, endereco, cep, cidade, estado) values (1, 'Gilbert K. Anderson', 'gilbertKAnderson@teleworm.us', '(88) 992233443', 'Sem descrição', 'Rua da Aclimação, N 194, Santa Cruz', '64028-848', 'Santa Cruz', 'Piaui');
INSERT INTO usuario (id, nome, email, telefone, descricao_pessoal, endereco, cep, cidade, estado) values (2, 'Elmira L. Cullen', 'elmiraLCullen@armyspy.com', '(33) 997071457', 'Sem descrição',  'Rua Andrade Neves, N 766, Barcelos', '96506-674', 'Cachoeira do Sul', 'Rio Grande do Sul');
INSERT INTO usuario (id, nome, email, telefone, descricao_pessoal, endereco, cep, cidade, estado) values (3, 'Manuel Moreno', 'manuel.moreno@example.com', '(93) 973512546', 'Sem descrição',  'Rua São Francisco de Assis, N 367, Tabatinga', '64028-848', 'Igarassu', 'Pernanbuco');

INSERT INTO usuario_atividade (id_usuario, id_atividade) values (1, 1);
INSERT INTO usuario_atividade (id_usuario, id_atividade) values (1, 5);
INSERT INTO usuario_atividade (id_usuario, id_atividade) values (1, 6);
INSERT INTO usuario_atividade (id_usuario, id_atividade) values (1, 8);

INSERT INTO usuario_atividade (id_usuario, id_atividade) values (2, 1);
INSERT INTO usuario_atividade (id_usuario, id_atividade) values (2, 4);
INSERT INTO usuario_atividade (id_usuario, id_atividade) values (2, 10);

INSERT INTO usuario_atividade (id_usuario, id_atividade) values (3, 3);
INSERT INTO usuario_atividade (id_usuario, id_atividade) values (3, 8);
INSERT INTO usuario_atividade (id_usuario, id_atividade) values (3, 9);
