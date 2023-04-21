
# BASIC-USER-API

## 1. Configuração

#### 1.1 Ambiente
- Instalar o [java (versão 8)](https://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html)

- Escolher IDE de sua preferencia.

-* Para este projeto foi utilizado o Eclipse [Neon 3](https://www.eclipse.org/downloads/packages/release/neon/3)*

- Instale o [Lombok](https://projectlombok.org/downloads/lombok.jar) na sua IDE. (Em caso de dúvidas, consulte [Projeto Lombok](https://projectlombok.org/))

- Instalar o [git](https://git-scm.com/book/pt-br/v1/Primeiros-passos-Instalando-Git)

#### 1.2 Projeto

- Fazer [checkout](https://git-scm.com/docs/git-checkout) do projeto num diretório local

```shell
git clone https://github.com/augustocmleal/basic-user-api.git
```

- Dentro da sua IDE, faça o **import** do projeto como **Maven Project**

*Após a importação, caso necessário, faça um update project pelo Maven*

## 2. Executando a aplicação localmente

A maneira mais simples para executar a aplicação em seu ambiente local e executando o método main da classe `br/com/augustoleal/basic_user_api/Application.java`

###### Os scripts necessários para o teste da aplicação estão dentro de `data.sql`.

#### 2.1. Realizando chamadas na API

- Baixe e instale o [POSTMAN](https://www.getpostman.com/downloads/)
- Abra o postman e clique no botão **import** no alto da tela
- Clique no botão **choose files**
- Selecione o arquivo do postman no caminho: `PATH/basic-user-api/postman/basic-user-api.postman_collection.json`

## 3. O que encontrar na basic-user-api?
- Endpoint para cadastro, atualização, remoção e listagem da Entidade User
- Validação de cpf ao inserir novo User
- Endpoint para cadastro e listagem da Entidade Cargo
- Endpoint para cadastro e listagem da Entidade Perfil
- Endpoint para buscas na Entidade Users filtrando por nome, cpf, cargo, perfil ou/e status
- Endpoint para inativar os usuários ativos
- Validação ao inativar usuário para verificar se ele está ativo.
- Endpoint para retornar usuários do sexo feminino e que sejam maiores de 18 anos
- Endpoint para retornar cpf que iniciem com dígito zero
- Validação para não permitir o cadastro de usuários com o mesmo cpf e nome. (cpf ou nome repetidos separadamente são permitidos)
- Formatação de data para o padrão (dia/Mês/Ano) nas consultas
