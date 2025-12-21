# 🎟️ DesafioTrivia -- API de Venda e Validação de Ingressos

API REST desenvolvida em **Java com Spring Boot** para simular o fluxo
de **compra e validação de ingressos**, aplicando boas práticas de
arquitetura, validação de dados e persistência com banco relacional.

------------------------------------------------------------------------

## 📌 Visão Geral

O **DesafioTrivia** é uma API que permite:

-   Comprar ingressos
-   Persistir os dados no banco de dados
-   Validar ingressos previamente adquiridos
-   Garantir regras de negócio e integridade dos dados

Projeto ideal para desafios técnicos, estudos e portfólio profissional.

------------------------------------------------------------------------

## 🧱 Arquitetura do Projeto

    com.desafiotrivia
     ├── Controller
     ├── Service
     ├── Repository
     ├── Domain
     ├── Dto
     └── Exception

------------------------------------------------------------------------

## 🚀 Tecnologias Utilizadas

-   Java 17
-   Spring Boot 3
-   Spring Web
-   Spring Data JPA
-   Bean Validation
-   PostgreSQL
-   Maven
-   Lombok

------------------------------------------------------------------------

## ⚙️ Configuração

### application.properties

``` properties
spring.application.name=DesafioTrivia

spring.datasource.url=jdbc:postgresql://localhost:5432/desafiotrivia
spring.datasource.username=postgres
spring.datasource.password=postgres

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

------------------------------------------------------------------------

## 🌐 Endpoints

### 🎟️ Comprar Ingresso

**POST** `/api/v1/tickets`

``` json
{
  "name": "Alexandre Silva",
  "document": "12345678900"
}
```

### ✅ Validar Ingresso

**POST** `/api/v1/tickets/{ticketId}/validate`

``` json
{
  "document": "12345678900"
}
```

------------------------------------------------------------------------

## 🛡️ Validações

-   Campos obrigatórios
-   Documento válido
-   Ticket existente
-   Ticket não validado previamente

------------------------------------------------------------------------

## 🧪 Testes

A API pode ser testada via Postman, Insomnia ou curl.

------------------------------------------------------------------------

## 📈 Evoluções Futuras

-   Swagger
-   JWT
-   Testes automatizados
-   Docker
-   CI/CD

------------------------------------------------------------------------

## 👨‍💻 Autor

Alexandre Silva\
Desenvolvedor Java / C#

-----------------------------------------------------------------------
