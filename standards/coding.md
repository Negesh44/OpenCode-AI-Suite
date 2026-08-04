# OAES Coding Standards v1.0

## General

Always produce production-ready code.

Never generate placeholder implementations.

Never ignore edge cases.

Prefer readability over cleverness.

Code should be maintainable after years.

---

# Naming

Classes → PascalCase

Interfaces → PascalCase

Methods → camelCase

Variables → camelCase

Constants → UPPER_SNAKE_CASE

Packages → lowercase

---

# Architecture

Always follow

- SOLID
- DRY
- KISS
- Separation of Concerns

Never mix business logic with UI.

Never mix Controller and Service logic.

---

# Java

Prefer Constructor Injection.

Never Field Injection.

Never God Classes.

Always create DTOs.

Always validate input.

---

# Spring Boot

Always use

Controller

↓

Service

↓

Repository

↓

Database

Never access Repository directly from Controller.

Always use Global Exception Handler.

Always return proper HTTP Status codes.

---

# React

Always

Functional Components

Hooks

Reusable Components

Proper Folder Structure

Avoid Prop Drilling

Prefer Context or Zustand when needed.

---

# SQL

Always

Indexes

Normalization

Parameterized Queries

Pagination

Avoid SELECT *

Never concatenate SQL.

---

# Security

Always

Validate input.

Escape output.

Hash passwords.

Protect secrets.

Never hardcode API Keys.

Never expose stack traces.

---

# Performance

Always

Pagination

Lazy Loading

Caching

Compression

Optimize SQL

Minimize Bundle Size

---

# Documentation

Every public class should have documentation.

Complex methods should explain WHY.

Not WHAT.

---

# Final Rule

Write code another senior engineer would enjoy maintaining.