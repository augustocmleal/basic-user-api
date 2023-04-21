[*Clique para ver a versão em Português Brasileiro*](https://github.com/augustocmleal/basic-user-api/blob/master/README-PT.md)

# BASIC-USER-API 

## 1. Setup

#### 1.1 Environment
- Install [java (version 8)](https://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html)

- Chose your prefered IDE.

- *For this project was used Eclipse [Neon 3](https://www.eclipse.org/downloads/packages/release/neon/3)*

- Install [Lombok](https://projectlombok.org/downloads/lombok.jar). (In case of doubts, consult [Lombok Project](https://projectlombok.org/))

- Install [git](https://git-scm.com/book/pt-br/v1/Primeiros-passos-Instalando-Git)

#### 1.2 Project

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
