-- Logar como root
mysql -u root -p
-- Cria o usúario para conexão com o BD
create user note@localhost identified by 'note';
-- Fornce as permissões necessárias
grant all privileges on *.* to note@localhost;
-- Atualizar as permissões
flush privileges;
-- Sair da conta do root
exit


-- Criar Banco
CREATE DATABASE IF NOT EXISTS note;
-- Seleciona o Banco
USE note;
-- Cria a tabela
CREATE TABLE  IF NOT EXISTS senhas (
	id  INTEGER AUTO_INCREMENT,
	nome CHAR(30) NOT NULL,
	usuario VARCHAR(50) NOT NULL,
	senha VARCHAR(50) NOT NULL,
	PRIMARY KEY (id)
);

-- Apenas para checagem
SHOW DATABASES;
USE note;
SHOW TABLES;

-- Funções Adicionais

-- Deletar o banco
drop database note;
-- Deletar ousuário criado
delete from mysql.user where user='note';
-- Liste os usuários do mysql
select user, host from mysql.user;
