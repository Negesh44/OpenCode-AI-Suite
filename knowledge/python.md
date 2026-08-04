# Python Knowledge Base

## Objective

Provide best practices for building clean, reliable, and maintainable Python applications.

---

# Core Principles

Always follow

- PEP 8
- Readability over cleverness
- DRY
- KISS

---

# Language Style

Prefer

- Clear variable names
- Type hints where helpful
- List comprehensions for simple transformations
- Context managers for resource handling

Avoid

- Deep nesting
- Mutable default arguments
- Unnecessary side effects

---

# Project Structure

Use

- virtual environments
- requirements.txt or pyproject.toml
- clear package/module boundaries
- environment-based configuration

---

# Error Handling

Always

- Catch specific exceptions
- Raise meaningful errors
- Log unexpected failures

Avoid

- Swallowing exceptions silently

---

# Performance

Optimize

- Database queries
- File I/O
- Memory usage
- Algorithm efficiency

Profile before optimizing.

---

# Security

Never

- Hardcode secrets
- Trust user input blindly
- Expose sensitive data in logs

---

# Testing

Include

- Unit tests
- Integration tests
- Edge cases and failure scenarios

---

# Final Rule

Write Python code that is clear, reusable, tested, and production-ready.
