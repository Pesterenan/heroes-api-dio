# API de Gerenciamento de Heróis

Essa API armazena e gerencia nomes de heróis dos quadrinhos e algumas de suas informações. Foi desenvolvida com base no LiveCoding **Criando seu gerenciador de super heróis da Marvel e da DC em uma API reativa com Spring Boot** pela professora <a href="https://www.linkedin.com/in/kamila-santos-oliveira/" target="_blank">Kamila Santos</a> na plataforma **Digital Innovation One** no Bootcamp TQI Java Developer da <a href="https://www.linkedin.com/company/tqi-it/" target="_blank">**TQI**</a>.

## Tecnologias utilizadas

- Eclipse Enterprise
- Java 8
- Git
- DynamoDB
- AmazonAWS
- AWS CLI

## Spring Boot

- [SpringBoot - Start Spring Io](https://start.spring.io/)

* Java 8
* Maven Project
* Spring WebFlux
* Reactor
* Amazon DynamoDB
* JUnit
* Postman Documenter

## DataBase

### Amazon DynamoDB

- [Download Local do DynamoDB](https://docs.aws.amazon.com/pt_br/amazondynamodb/latest/developerguide/DynamoDBLocal.DownloadingAndRunning.html)
Faça o download do ".zip" da região da América do Sul (São Paulo - "us-east-2")

- Comando para iniciar o banco para o projeto (executado dentro da pasta já baixada do Dynamo):

```shell script
java -Djava.library.path=./DynamoDBLocal_lib -jar DynamoDBLocal.jar -sharedDb
```

### Configuração e importação das querys dentro do banco DynamoDB:

Com o DynamoDB já iniciado e rodando localmente, é só executar o método "main" nas duas classes do projeto, em sequência: HeroesTable.java e HeroesData.java
Após isso será possível realizar as requisições via browser ou no Postman

## Utilizando a API no Postman ou diretamente no Browser

- Para utilizar e acessar os dados da API no Postman ou no browser, veja os seguintes Endpoints com suas instruções:

 https://documenter.getpostman.com/view/17130743/UVJckGvF