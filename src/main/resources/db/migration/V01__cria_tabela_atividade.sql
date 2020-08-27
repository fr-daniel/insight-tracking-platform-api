CREATE TABLE atividade (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	titulo VARCHAR(255) NOT NULL,
	descricao TEXT,
	local VARCHAR(100)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO atividade(id, titulo, descricao, local) VALUES (1, 'Curso Inglês', 'Curso completo de inglês. 72 horas.', 'UFC');
INSERT INTO atividade(id, titulo, descricao, local) VALUES (2, 'Curso Espanhol', 'Curso completo de espanhol. 120 horas.', 'UFC');
INSERT INTO atividade(id, titulo, descricao, local) VALUES (3, 'Curso Francês', 'Curso completo de francês. 150 horas.', 'UFC');

INSERT INTO atividade(id, titulo, descricao, local) VALUES (4, 'Do Básico ao Avançado - O Curso Completo de Microsoft Excel', 'Aprenda Excel de forma completa e aplique seus conhecimentos construindo uma ferramenta avançada', 'Udemy');
INSERT INTO atividade(id, titulo, descricao, local) VALUES (5, 'Programação em Python do básico ao avançado', 'Aprenda Python do básico ao avançado com Expressões Lambdas, Iteradores, Geradores, Orientação a Objetos e muito mais!', 'Udemy');
INSERT INTO atividade(id, titulo, descricao, local) VALUES (6, 'Power BI Completo - Do Básico ao Avançado', 'Aprenda o passo a passo exato para criar dashboards e relatórios dinâmicos usando Business Intelligence', 'UFC');

INSERT INTO atividade(id, titulo, descricao, local) VALUES (7, 'Big Data Analytics com R e Microsoft Azure Machine Learning', 'Este curso une duas das principais ferramentas usadas por Cientistas de Dados: R, linguagem estatística usada para análise de dados', 'Data Science Academy');
INSERT INTO atividade(id, titulo, descricao, local) VALUES (8, 'Big Data Real-Time Analytics com Python e Spark', 'Este curso une na medida certa, teoria e prática, duas tecnologias em alta no mercado de Big Data Analytics: Python e Spark.', 'Data Science Academy');
INSERT INTO atividade(id, titulo, descricao, local) VALUES (9, 'Business Analytics', 'Conhecimento de negócio é uma das habilidades principais do Cientista de Dados. O objetivo deste curso é aplicar técnicas analíticas em áreas de negócio como Marketing, Finanças e RH, coletando dados.', 'Data Science Academy');

INSERT INTO atividade(id, titulo, descricao, local) VALUES (10, 'Curso de Introdução ao Docker', 'Neste curso inicial você aprenderá os principais conceitos e o funcionamento do Docker.', 'Insight Lab');
INSERT INTO atividade(id, titulo, descricao, local) VALUES (11, 'Curso de Introdução ao Kubernetes', 'Neste curso inicial você aprenderá os principais conceitos e o funcionamento do Kubernetes.', 'Insight Lab');
