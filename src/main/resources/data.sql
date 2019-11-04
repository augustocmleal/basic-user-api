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
	username VARCHAR(30) NOT NULL,
	password VARCHAR(6) NOT NULL,
	cargo INT NOT NULL,
	perfil INT NOT NULL,
	status VARCHAR(1) NOT NULL DEFAULT 'A',
	FOREIGN KEY (cargo) REFERENCES cargo(id),
	FOREIGN KEY (perfil) REFERENCES perfil(id),
	CONSTRAINT UC_user UNIQUE (cpf,nome)
);


INSERT INTO cargo (nome) VALUES ('Gerente'), ('Supervisor'), ('Administrativo');

INSERT INTO perfil (nome) VALUES ('Administrador'), ('Comum');

INSERT INTO user (nome, cpf, sexo, data_nasc, username, password, cargo, perfil) VALUES 
('Augusto Leal', '12236598744', 'M', parsedatetime('02-01-1987', 'dd-MM-yyyy'), 'augustoml', 'abc123', 
(SELECT id FROM cargo WHERE nome = 'Gerente'),
(SELECT id FROM perfil WHERE nome = 'Administrador')),
('Agnys Alves', '49465823655', 'F', parsedatetime('12-09-1987', 'dd-MM-yyyy'), 'agnysap', 'abc123',
(SELECT id FROM cargo WHERE nome = 'Supervisor'),
(SELECT id FROM perfil WHERE nome = 'Comum'));
