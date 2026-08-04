# OAES Spring Boot Standards v1.0

## Spring Boot Version

Prefer

- Java 21+
- Spring Boot 3+
- Maven

---

# Project Structure

src/main/java

controller/

service/

repository/

entity/

dto/

mapper/

config/

security/

exception/

util/

Never mix responsibilities.

---

# Controller

Controllers should

- Handle HTTP requests
- Validate input
- Return ResponseEntity
- Never contain business logic

---

# Service

Services should

- Contain business logic
- Call repositories
- Handle transactions
- Throw meaningful exceptions

Never access HTTP objects.

---

# Repository

Use

Spring Data JPA

Never write unnecessary SQL.

Prefer repository methods.

---

# Entity

Entities should

- Represent database tables
- Contain relationships
- Avoid business logic

Never expose entities directly to clients.

---

# DTO

Always create

Request DTO

Response DTO

Never return Entity objects.

---

# Validation

Always use

@NotNull

@NotBlank

@Email

@Size

@Min

@Max

Use @Valid in controllers.

---

# Exception Handling

Use

@RestControllerAdvice

Global Exception Handler

Never surround every method with try-catch.

---

# Dependency Injection

Always

Constructor Injection

Never

Field Injection

---

# Transactions

Use

@Transactional

only when required.

Keep transactions small.

---

# Security

Always

Spring Security

JWT

BCrypt

Role Based Access

HTTPS

Never

Store passwords in plain text.

---

# API Design

Use

/api/users

/api/complaints

/api/admin

Never

/getUser

/createComplaint

---

# Response Format

Success

{
    "success": true,
    "data": {}
}

Error

{
    "success": false,
    "message": ""
}

Maintain consistency.

---

# Logging

Use

SLF4J

Log

Errors

Warnings

Important Events

Never log

Passwords

JWT

Secrets

---

# Performance

Always

Pagination

Caching

Indexes

Lazy Loading

Avoid N+1

Optimize queries.

---

# Testing

Write

Unit Tests

Integration Tests

Mock Services

Test Controllers

---

# Documentation

Use

Swagger/OpenAPI

Document every public endpoint.

---

# Code Quality

Follow

SOLID

DRY

Clean Architecture

Meaningful Naming

Reusable Services

Small Methods

---

# Final Rule

Every Spring Boot project should be production-ready, secure, scalable, and maintainable.