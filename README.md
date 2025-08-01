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
