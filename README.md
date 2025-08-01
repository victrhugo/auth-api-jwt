# 🔐 Auth API com Spring Boot + JWT

Este projeto é uma API de autenticação desenvolvida com Java e Spring Boot, utilizando boas práticas de segurança e arquitetura REST. O objetivo é demonstrar como implementar cadastro, login e controle de acesso via **JWT (JSON Web Token)**.

---

## 🚀 Tecnologias utilizadas

- Java 17+
- Spring Boot 3.x
- Spring Security
- Spring Data JPA
- H2 Database (para ambiente de testes)
- JWT (via biblioteca `jjwt`)
- Maven
- IntelliJ IDEA
- Postman/Insomnia (para testes)

---

## 🧱 Funcionalidades

- Cadastro de novos usuários com criptografia de senha (BCrypt)
- Login com validação de e-mail/senha e geração de token JWT
- Acesso a rotas protegidas apenas com token válido
- Validação automática de token via filtro Spring Security
- Arquitetura em camadas: Controller, Service, Repository
- Seguindo princípios de Clean Code e responsabilidade única

---

## 📁 Estrutura de pastas

```bash
src/
├── controller/       # Endpoints REST
├── model/            # Entidades JPA
├── repository/       # Interfaces do Spring Data
├── service/          # Lógica de negócio
├── security/         # Configurações de autenticação JWT
└── DemoApplication.java
```

---

## ⚙️ Como executar o projeto

### 1. Clonar o repositório
```bash
git clone https://github.com/seu-usuario/auth-api-jwt.git
cd auth-api-jwt
```

### 2. Importar no IntelliJ ou IDE de sua preferência

### 3. Executar a aplicação
Execute a classe `DemoApplication` ou use:
```bash
./mvnw spring-boot:run
```

### 4. Acessar o console do H2 (opcional)
- URL: http://localhost:8080/h2-console  
- JDBC URL: `jdbc:h2:mem:meubanco`  
- Usuário: `sa` | Senha: *(em branco)*

---

## 📬 Endpoints principais

| Método | Rota             | Descrição                    |
|--------|------------------|------------------------------|
| POST   | `/auth/register` | Cadastro de novo usuário     |
| POST   | `/auth/login`    | Login e retorno do token JWT |
| GET    | `/profile`       | Acesso autenticado (protegido) |

> ⚠️ Rotas protegidas exigem Header:
```
Authorization: Bearer {seu_token_jwt}
```

---

## 🛡️ Boas práticas implementadas

- Separação clara de responsabilidades
- Criptografia de senhas com BCrypt
- Tokens JWT seguros e com expiração
- Controle de erros no login/cadastro
- Uso de `ResponseEntity` para respostas HTTP padronizadas
- Validação básica no controller (e pode evoluir com Bean Validation)
- Persistência com JPA + H2 para ambiente local

---

## ✍️ Futuras melhorias

- Validação com anotações (`@Valid`)
- Refresh token
- Autenticação com roles e perfis
- Integração com PostgreSQL
- Swagger/OpenAPI para documentação
