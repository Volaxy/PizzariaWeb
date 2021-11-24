create database pizzaria;

use pizzaria;

/******************************** Criação das Tabelas ************************************************/

/* Tabelas Primarias */
create table Endereco (
	id int primary key auto_increment,
    cidade varchar(25) not null,
    bairro varchar(25) not null,
    rua varchar(25) not null,
    numero int not null,
    logradouro varchar(50) not null
);

create table Ingrediente (
	id int primary key auto_increment,
    descricao varchar(25) not null
);

/* Tabelas Compostas */
create table Cliente (
	id int primary key auto_increment,
    nome varchar(50) not null,
    cpf varchar(15) not null,
    
    id_endereco int,
    
    foreign key (id_endereco) references Endereco(id) on delete set null
);

create table Pedido (
	id int primary key auto_increment,
    tipo_pedido enum("Entrega", "Presencial") not null,
    tipo_pagamento enum("Dinheiro", "Cartao") not null,
    total double not null,
	
    id_cliente int not null,
    
    foreign key (id_cliente) references Cliente(id) on delete cascade
);

create table Pizza (
	id int primary key auto_increment,
    descricao varchar(25) not null unique,
    tamanho enum("PEQUENA", "MEDIA", "GRANDE") not null,
    preco double not null
);

create table Pizza_Ingrediente (
	id_pizza int not null,
    id_ingrediente int not null,
    
    quantidade int not null,
    
    foreign key (id_pizza) references Pizza(id) on delete cascade,
    foreign key (id_ingrediente) references Ingrediente(id) on delete cascade
);

create table pizza_pedido (
	id_pizza int not null,
    id_pedido int not null,
    
    quantidade int not null,
    
    foreign key (id_pizza) references Pizza(id) on delete cascade,
    foreign key (id_pedido) references Pedido(id) on delete cascade
);

/* Alteração das Tabelas */
alter table Cliente drop column pagamento;
alter table Cliente modify column cpf varchar(15);
alter table Pizza modify column descricao varchar(25) not null unique;
alter table Pizza add descricao varchar(15);
ALTER TABLE `pizzaria`.`pizza`
CHANGE COLUMN `descricao` `descricao` VARCHAR(15) NOT NULL AFTER `id`,
ADD UNIQUE INDEX `descricao_UNIQUE` (`descricao` ASC) VISIBLE;
alter table Pizza modify column tamanho enum("PEQUENA", "MEDIA", "GRANDE");
SET foreign_key_checks = 1;
delete from pizza where id = 1;

/************************************** CRUD's *******************************************************/

/* Descrever Tabelas */
describe endereco;
describe ingrediente;
describe cliente;
describe pedido;
describe pizza;
describe pizza_ingrediente;
describe pizza_pedido;

/* Create */
insert into endereco(cidade, bairro, rua, numero, logradouro) values
("Viana", "Bairro 1", "Rua 1", 63, "Perto da Igreja"),
("Cariacica", "Bairro 2", "Rua 2", 71, "Perto da Igreja"),
("Viana", "Bairro 1", "Rua 1", 147, "Perto do Supermercado");

insert into ingrediente(descricao) values
("Queijo"),
("Presunto"),
("Ovo"),
("Farinha"),
("Trigo"),
("Peperone"),
("Orégano"),
("Tomate");

insert into Cliente(nome, cpf, id_endereco) values
("Ana Maria", "146.835.863-68", 2),
("Bia Bianca", "869.478.741-01", 2),
("Clara Shuster", "048.916.863-94", 1);

insert into Pedido(tipo_pedido, tipo_pagamento, total, id_cliente) values
("Presencial", "Dinheiro", 20.0, 2),
("Presencial", "Cartao", 30.0, 2),
("Entrega", "Cartao", 10.0, 3),
("Presencial", "Cartao", 10.0, 1),
("Entrega", "Dinheiro", 20.0, 3);

insert into Pizza(descricao, tamanho, preco) values
("Calabresa" ,"Pequena", 10.0),
("Portuguesa" ,"Grande", 20.0);

insert into Pizza_Ingrediente(id_pizza, id_ingrediente, quantidade) values
(1, 4, 2),
(2, 2, 1),
(1, 3, 2),
(2, 3, 2),
(2, 6, 3),
(2, 5, 3),
(1, 1, 5),
(2, 4, 1);

insert into Pizza_Pedido(id_pizza, id_pedido, quantidade) values
(1, 1, 2),
(2, 2, 1),
(1, 3, 3),
(2, 3, 5);

/* Read */
	/* Seleciona os dados da Tabela */
	select * from endereco;
    select * from ingrediente;
    select * from cliente;
	select * from pedido;
	select * from pizza;
	select * from pizza_ingrediente;
	select * from pizza_pedido;

	/* Select's Específicos */
    select * from pizza join pizza_pedido on pizza.id = pizza_pedido.id_pizza;