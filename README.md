# Note F5enha - Gerenciador de senhas #

## Descrição ## 
Gerenciador de senhas em JAVA com armazenamento em Banco Mysql e criptografia MD5(assimétrica) e AES(simétrica).

Permite o armazenamento de usuários e senhas em um banco de dados com criptografia, podendo ser identificado com a utilização de um nome e usuário durante o cadastro.

Sistema é totalmente gerenciável, é possível incluir, visualizar, alterar e remover cadastros de senhas do gerenciador.

Permite o cadastro de novos usuários mediante ao uso de uma senha segura, a mesma deverá ser composta por pelo menos oito caracteres, letras maiúsculas, minúsculas, números e caracteres especiais.

No menu **_Editar_** é possível criar um novo Cadastro de senha, Visualizar um Cadastro de senha, Atualizar um cadastro de senha, Excluir um cadastro de senha, ou ainda Sair do sistema.

No menu **_Sobre_** é possível acessar os atalhos do programa e informações sobre o sistema.

No menu **_Usuário_**, é possível acessar as opções trocar usuário, onde o usuário ativo será encerrado e solicitado o logon do novo usuário, sair do sistema e gerenciamento da conta de usário atual, com as funções de trocar senha, cadastrar um novo usuário ou ainda excluir, neste caso o sistema irá realizar a remoção do usuário e também a remoção das senhas que são de própriedade do usuário removido.

### Funcionamento:
Ao realizar o cadastro no sistema a senha mestre de acesso ao gerenciado de senhas é criptografada com MD5, junto disso é gerado uma chave que será utilizada para cifrar/descifrar com AES todas as senhas cadastradas no sistema, de forma que somente o proprietário daquela conta possa gerenciar as senhas no cofre.

### Execução:
Caso deseje apenas executar o software sem a necessidade de configurações ou adicionais visite o link [Executar](https://github.com/ksioroger/Note/wiki#executar).

Execução com banco em nuvem, modo [online](https://github.com/ksioroger/Note/wiki#executar-com-banco-de-dados-on-line)(modo RECOMENDADO), execução com banco local(localhost), ou em máquina na rede, modo [offline](https://github.com/ksioroger/Note/wiki#executar-offlinelocalhost-ou-banco-de-dados-na-mesma-rede);

Caso deseje informações mais detalhadas e personalizações de banco acesse, a [WIKI](https://github.com/ksioroger/Note/wiki) para mais informações.

### Manutenção:
* Cassiano Rogério          cassiano.roger@gmail.com
