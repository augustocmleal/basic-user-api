[(Portugues)](https://badgen.net/badge/Lang:/Portuguese/green?icon=github)
# BASIC-USER-API 

## 1. Configuração

#### 1.1. Visão geral



#### 1.2. Environment
- Install [java (version 8)](https://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html)

- Chose your prefered IDE.

- *For this project was used Eclipse [Neon 3](https://www.eclipse.org/downloads/packages/release/neon/3)*

- Install [Lombok](https://projectlombok.org/downloads/lombok.jar) na sua IDE. (Em caso de dúvidas, consulte [Projeto Lombok](https://projectlombok.org/))

- Install [git](https://git-scm.com/book/pt-br/v1/Primeiros-passos-Instalando-Git)

#### 1.3. Project

- Project [checkout](https://git-scm.com/docs/git-checkout) in your prefered directory

```shell
git clone https://github.com/augustocmleal/basic-user-api.git
```

- Inside IDE, **import** the project as **Maven Project**

*After instalation, if necessary, update project with Maven*

## 2. Executing project localy


Execute the main class `br/com/augustoleal/basic_user_api/Application.java`

###### The necessary scripts is into `data.sql`.

#### 2.1. Calling the API

- Download and install [POSTMAN](https://www.getpostman.com/downloads/)
- Open postman and select **import** button on the top of the screenno alto da tela
- Select **choose files**
- Select the postman file on path: `PATH/basic-user-api/postman/basic-user-api.postman_collection.json`

## 3. What do you find in basic-user-api?
- Endpoint to create, update, list and delete the user entity
- CPF validation when insertnew user
- Endpoint create and list da Cargo entity
- Endpoint create and list profile entity
- Endpoint search users filtering by por nome, cpf, cargo, perfil and/or status
- Endpoint to inactivate users
- Endpoint to list womanly users with more than 18 year old
- Endpoint to list cpf with the first digit zero
- Validation to not permit create users with the same nome and CPF. Create cpf and nome repeated separately is allow.
- Selects with date format to pattern (daya/month/year)


# BASIC-USER-API (Portuguese description)

## 1. Configuração

#### 1.1. Visão geral



#### 1.2. Ambiente
- Instalar o [java (versão 8)](https://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html)

- Escolher IDE de sua preferencia.

-* Para este projeto foi utilizado o Eclipse [Neon 3](https://www.eclipse.org/downloads/packages/release/neon/3)*

- Instale o [Lombok](https://projectlombok.org/downloads/lombok.jar) na sua IDE. (Em caso de dúvidas, consulte [Projeto Lombok](https://projectlombok.org/))

- Instalar o [git](https://git-scm.com/book/pt-br/v1/Primeiros-passos-Instalando-Git)

#### 1.3. Projeto

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
