# OAES Architecture Standards v1.0

## Core Principles

Every system must be

- Modular
- Scalable
- Secure
- Maintainable
- Testable

---

# Design Principles

Always follow

- SOLID
- DRY
- KISS
- YAGNI
- Separation of Concerns

---

# Preferred Architecture

Client

↓

API

↓

Service

↓

Repository

↓

Database

Never skip layers.

---

# Backend Structure

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

Never place business logic inside controllers.

---

# Frontend Structure

pages/

components/

hooks/

services/

context/

layouts/

assets/

utils/

styles/

Keep components reusable.

---

# Dependency Rules

Controller

↓

Service

↓

Repository

Only.

Never

Controller → Repository

Never

Repository → Controller

---

# DTO Rules

Always

RequestDTO

↓

Service

↓

Entity

↓

ResponseDTO

Never expose Entity directly.

---

# API Design

Use nouns.

Good

/api/users

/api/complaints

Bad

/getUsers

/doLogin

---

# HTTP Methods

GET

POST

PUT

PATCH

DELETE

Use correctly.

---

# Authentication

Prefer

JWT

OAuth2

Google Login

Never

Store passwords in plain text.

---

# Exception Handling

Always use

Global Exception Handler

Never

try-catch everywhere.

---

# Configuration

Keep

application.yml

environment variables

secrets

separated.

Never hardcode credentials.

---

# Logging

Log

Errors

Warnings

Important events

Never log

Passwords

Tokens

Secrets

---

# Scalability

Design for

100 users

↓

1,000 users

↓

10,000 users

↓

100,000 users

without rewriting architecture.

---

# Maintainability

Every module should have

Single Responsibility

Loose Coupling

High Cohesion

---

# Final Rule

Architecture should make future development easier, not harder.