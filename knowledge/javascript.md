# JavaScript Knowledge Base

## Objective

Provide best practices for writing modern, readable, and maintainable JavaScript applications.

---

# Core Principles

Always follow

- Clean Code
- DRY
- KISS
- SOLID principles where applicable

---

# Language Features

Prefer

- ES6+ syntax
- const and let over var
- Arrow functions for short callbacks
- Destructuring and spread operators
- Template literals
- Modules (ESM)

Avoid

- Global variables
- Mutation where unnecessary
- Overly clever one-liners

---

# Functions

Write functions that are

- Small
- Reusable
- Predictable
- Easy to test

Prefer pure functions when possible.

---

# Asynchronous Programming

Use

- async/await
- Promises
- Proper error handling

Avoid

- Callback hell
- Unhandled promise rejections

---

# Performance

Optimize

- Avoid unnecessary loops
- Minimize DOM access
- Use lazy loading where appropriate
- Debounce expensive events

---

# Security

Never

- Expose secrets in frontend code
- Trust client-side validation alone
- Eval user-controlled input

---

# Testing

Include

- Unit tests
- Integration tests
- Edge case coverage

---

# Final Rule

Write JavaScript that is simple, readable, safe, and maintainable.
