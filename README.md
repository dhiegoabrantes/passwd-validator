# Password Validator API
A API é especializada em validação de formato de senha.<br>
Os requisitos mínimos para um formato de senha aceitável são:
* Mínimo de 9 caracteres
* Conter pelo menos um dígito
* Conter pelo menos uma letra minúscula
* Conter pelo menos uma letra maiúscula
* Conter pelo menos um caractere especial

## Ferramentas Utilizadas
* Java 11
* Spring Boot 2
* Lombok 1.18
* JUnit 5
* Swagger 2
* JaCoCo 0.8.5
* Docker

## Sobre as API's disponibilizadas
Basicamente, a aplicação disponibiliza duas API's no formato REST:
* API para validação de valores de senha
* API para health check

A documentação das API`s e client web foram dispibilizados através do Swagger e, uma vez que a aplicação estiver em execução,
poderá ser acessado através da [URL](http://localhost:8080/swagger-ui.html).


### API para Validação de formato de senha
API utilizada para validar formato de valores que serão utilizados como senha.
* Método HTTP: POST
* Path: /passwd-validator

O método POST foi utilizado para evitar que a senha fosse exposta na URL da requisição.

#### Como utilizar?

```bash
curl -X POST "http://localhost:8080/passwd-validator" \
        -H "accept: application/json" \
        -H "Content-Type: application/json" \
        -d "{ \"word\": \"0MyP4sswd!\"}"
```

### API para Health Check
API utilizada somente para verificar a saúde da instância onde está disponibilizada a aplicação.

* Método HTTP: GET
* Path: /ping

#### Como utilizar?
Abaixo segue um exemplo de request no formato `curl`:
```bash
curl -X GET "http://localhost:8080/ping" -H "accept: */*"
```

O retorno em caso de sucesso é o valor `"pong"`.

## Executando a aplicação
Existem alguns requisitos mínimos para executar a aplicação:
* Java 11 ou superior
* Caso queira executar em container docker, necessitará o Docker instalado

É possível executar a aplicação de duas formas e, para isso, é necessário fazer um clone do repositório ou download do código fonte. <br>
Por padrão, a porta utilizada foi a `8080`.

### Clone ou Download do repositório

Após fazer o clone ou download, basta acessar a pasta raiz do projeto e executar o seguinte comando:
```bash
./build-and-run.sh
```

Através desse comando será feito o build da aplicação e, em seguida, a execução.

### Executando em um container docker
Após fazer o clone ou download, basta acessar a pasta raiz do projeto e executar o seguinte comando:
```bash
./build-and-dockerize-and-run.sh
```

Através desse comando, as seguintes taks são executadas:
* Build do projeto
    * Clean de diretórios
    * Compilação de artefato
    * Execução de testes unitários e de integração
    * Check de regra de cobertura mínima de código (90%)
    * Geração de relatório de cobertura de testes
* Criação da imagem docker contendo o artefato atualizado
* Criação e execução do container

### Considerações Técnicas
O projeto está configurado com `minimum code coverage` de 90% e o build somente terá sucesso se essa regra for respeitada.

Acessando a raíz do projeto e utilizando o comando abaixo é possível efetuar o build.

```bash
./gradlew clean build
```

Os relatórios de cobertura de teste estarão disponíveis na raíz do projeto, no path: `/build/jacocoHtml/index.html`

![jacoco](docs/jacoco-report-exemple.png)

Algumas classes foram desconsideradas na checagem da cobertura dos testes e na geração do relatório:
* Classes DTO (Data Transfer Object)
* Classe de inicialização do projeto
* Código gerado pelo Lombok (uso do `lombok.config`)