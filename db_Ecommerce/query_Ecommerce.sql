CREATE TABLE USUARIO (
	ID_user BIGINT NOT NULL AUTO_INCREMENT,
	nome_user varchar(255) NOT NULL,
	email_user varchar(255) NOT NULL,
	password_user varchar(12) NOT NULL,
	FK_pedidos varchar(255) NOT NULL,
	PRIMARY KEY (ID_user)
);

CREATE TABLE CATEGORIA_PRODUTO (
	ID_categoria BINARY NOT NULL AUTO_INCREMENT,
	nome_cat varchar(255) NOT NULL,
	regiao varchar(255) NOT NULL,
	PRIMARY KEY (ID_categoria)
);

CREATE TABLE PRODUTO (
	ID_produto BIGINT NOT NULL AUTO_INCREMENT,
	nome_produto varchar(255) NOT NULL,
	preco_produto FLOAT(6.2) NOT NULL,
    foto_produto varchar(255) NOT NULL,
	estoque INT(500) NOT NULL,
	descricao_produto varchar(255) NOT NULL,
	quantidade INT NOT NULL,
	FK_categoria INT NOT NULL,
	FK_animais INT NOT NULL,
	PRIMARY KEY (ID_produto)
);

CREATE TABLE PEDIDOS (
	ID_pedido BIGINT NOT NULL,
	valor_pedido FLOAT(8.2) NOT NULL,
	data_pedido DATE NOT NULL,tb_manutencaoid
	status_pedido BOOLEAN NOT NULL DEFAULT false,
	FK_produto INT NOT NULL,
	PRIMARY KEY (ID_pedido)
);

CREATE TABLE ANIMAIS (
	ID_animal INT NOT NULL,
	nome_animal varchar(255) NOT NULL,
    foto_animal varchar(255) NOT NULL,
	descricao_animal varchar(255) NOT NULL,
	PRIMARY KEY (ID_animal)
);

CREATE TABLE LOCATION_USER (
	nome_endereco varchar(255) NOT NULL,
	numero_endereco INT NOT NULL,
	cep INT NOT NULL,
	cidade varchar(50) NOT NULL,
	UF varchar(50) NOT NULL,
	FK_usuario varchar(50) NOT NULL
);

ALTER TABLE USUARIO ADD CONSTRAINT USUARIO_fk0 FOREIGN KEY (FK_pedidos) REFERENCES PEDIDOS(ID_pedido);

ALTER TABLE PRODUTO ADD CONSTRAINT PRODUTO_fk0 FOREIGN KEY (FK_categoria) REFERENCES CATEGORIA_PRODUTO(ID_categoria);

ALTER TABLE PRODUTO ADD CONSTRAINT PRODUTO_fk1 FOREIGN KEY (FK_animais) REFERENCES ANIMAIS(ID_animal);

ALTER TABLE `PEDIDOS` ADD CONSTRAINT `PEDIDOS_fk0` FOREIGN KEY (`FK_produto`) REFERENCES `PRODUTO`(`ID_produto`);

ALTER TABLE `LOCATION_USER` ADD CONSTRAINT `LOCATION_USER_fk0` FOREIGN KEY (`FK_usuario`) REFERENCES `USUARIO`(`ID_user`);

