DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS cargo;
DROP TABLE IF EXISTS perfil;


CREATE TABLE cargo (
	id INT AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(60) NOT NULL,
	descricao VARCHAR(100)
);

CREATE TABLE perfil(
	id INT AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(30) NOT NULL,
	descricao VARCHAR(100)
);

CREATE TABLE user (
	id INT AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(100) NOT NULL,
	cpf VARCHAR(11) NOT NULL,
	sexo VARCHAR(1) NOT NULL,
	data_nasc Date NOT NULL,
	cargo INT NOT NULL,
	perfil INT NOT NULL,
	status VARCHAR(1) NOT NULL DEFAULT 'A',
	FOREIGN KEY (cargo) REFERENCES cargo(id),
	FOREIGN KEY (perfil) REFERENCES perfil(id),
	CONSTRAINT UC_user UNIQUE (cpf,nome)
);


INSERT INTO cargo (nome, descricao) VALUES ('Gerente', 'Descricao Gerente'), ('Supervisor', 'Descricao Supervisor'), ('Administrativo', 'Descricao Administrativo');

INSERT INTO perfil (nome, descricao) VALUES ('Administrador', 'Descricao Administrador'), ('Comum', 'Descricao Comum');

INSERT INTO user (nome, cpf, sexo, data_nasc, cargo, perfil) VALUES 
('Augusto Leal', '03663790037', 'M', parsedatetime('02-01-1987', 'dd-MM-yyyy'), 
(SELECT id FROM cargo WHERE nome = 'Gerente'),
(SELECT id FROM perfil WHERE nome = 'Administrador')),
('Agnys Alves', '58863353077', 'F', parsedatetime('12-09-1987', 'dd-MM-yyyy'),
(SELECT id FROM cargo WHERE nome = 'Supervisor'),
(SELECT id FROM perfil WHERE nome = 'Comum'));
