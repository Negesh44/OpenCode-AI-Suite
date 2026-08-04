# Spring Boot Knowledge Base v1.0

## Preferred Stack

- Java 21+
- Spring Boot 3+
- Maven
- Spring Security
- Spring Data JPA
- MySQL
- JWT
- Lombok
- Validation
- Swagger

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

Never violate this structure.

---

# Controller Rules

Responsibilities

- Receive HTTP requests
- Validate input
- Return ResponseEntity
- Call Services

Never

- Business Logic
- SQL
- Complex Calculations

---

# Service Rules

Responsibilities

- Business Logic
- Transactions
- Validation
- Call Repository

---

# Repository Rules

Use

Spring Data JPA

Prefer

Derived Query Methods

JPQL

Native Query only if required.

---

# DTO Rules

Always create

Request DTO

Response DTO

Never expose Entity.

---

# Validation

Use

@Valid

@NotBlank

@NotNull

@Size

@Email

@Pattern

Never trust client data.

---

# Security

Always

JWT

BCrypt

Role Based Access

HTTPS

Constructor Injection

Never

Hardcode Secrets

Store Passwords

Disable Validation

---

# Exception Handling

Always use

@RestControllerAdvice

Global Exception Handler

Never

try-catch in every controller.

---

# API Standards

Good

/api/users

/api/complaints

/api/dashboard

Bad

/getUser

/deleteComplaint

---

# Database

Always

Indexes

Relationships

Foreign Keys

Transactions

Soft Delete where required

Audit Fields

---

# Performance

Always

Pagination

Caching

Batch Operations

Lazy Loading

Avoid N+1

---

# Logging

Log

Errors

Warnings

Business Events

Never

Passwords

JWT

Secrets

---

# Testing

Write

Unit Tests

Integration Tests

MockMvc Tests

Repository Tests

---

# Deployment

Docker

GitHub Actions

Nginx

Linux

Environment Variables

---

# Code Quality

Always

SOLID

DRY

Clean Code

Reusable Services

Small Methods

Meaningful Naming

---

# Final Rule

Every Spring Boot application should be production-ready before deployment.