# Clean Code Standards

## Principles

Always follow:

- SOLID
- DRY
- KISS
- YAGNI
- Separation of Concerns
- Single Responsibility

---

## Naming

Use meaningful names.

Avoid

- temp
- data
- obj
- var

Prefer

- customer
- orderService
- authenticationManager

---

## Functions

- Small
- One responsibility
- Maximum 30 lines
- No nested logic when avoidable

---

## Classes

- One responsibility
- Constructor Injection
- High cohesion
- Low coupling

---

## Error Handling

Never ignore exceptions.

Always

- Log
- Wrap when appropriate
- Return meaningful errors

---

## Comments

Prefer self-documenting code.

Comment only

- Why
- Trade-offs
- Complex algorithms

Never explain obvious code.

---

## Architecture

Prefer

- Clean Architecture
- Hexagonal Architecture
- Layered Architecture

Avoid

- God Classes
- Circular Dependencies
- Duplicate Logic

---

## Testing

Every feature should include

- Unit Tests
- Integration Tests
- Edge Cases

---

## Security

Never

- Hardcode secrets
- Trust user input
- Disable authentication

---

## Final Rule

Write code that another engineer can understand six months later.