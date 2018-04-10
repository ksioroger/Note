# Note - Gerenciador de senhas #

## Descrição ## 
Gerenciador de senhas em JAVA com armazenamento em Banco Mysql e criptografia MD5(assimétrica) e AES(simétrica).

Permite o armazenamento de usuários e senhas em um banco de dados com criptografia, podendo ser identificado com a utilização de um nome e usuário durante o cadastro.

Sistema é totalmente gerenciável, é possível visualizar, incluir, visualizar, alterar e remover cadastros de senhas do gerenciador.
Permite o cadastro de novos usuários mediante ao uso de uma senha segura, a mesma deverá ser composta por letras maiúsculas, minúsculas, números e caracteres especiais.
No menu Usuário, é possível acessar as opções trocar usuário, onde o usuário ativo será encerrado e solicitado o logon do novo usuário, sair do sistema e gerenciamento da conta de usário atual, com as funções de trocar senha, excluir ou ainda cadastrar um novo usuário.

### Funcionamento:
Ao realizar o cadastro no sistema a senha mestre de acesso ao gerenciado de senhas é criptografada com MD5, junto disso é gerado uma chave que será utilizada para cifrar/descifrar com AES todas as senhas cadastradas no sistema, de forma que somente o proprietário daquela conta possa gerenciar as senhas no cofre.

### Manutenção:
* Cassiano Rogério          cassiano.roger@gmail.com

### Execução:

Para realizar a execução acesse, a [WIKI](https://github.com/ksioroger/Note/wiki) para mais informações.
