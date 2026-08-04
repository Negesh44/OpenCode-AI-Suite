# REST API Knowledge Base

## Objective

Provide best practices for designing and implementing RESTful APIs.

---

# Design Principles

Follow

- Resource-oriented design
- Clear naming conventions
- Consistent status codes
- Stateless communication

---

# Endpoint Design

Prefer

- Nouns for resource names
- Plural resource paths
- Consistent HTTP methods
- Clear pagination and filtering

Avoid

- Verb-based URLs
- Overloaded endpoints

---

# Request and Response

Use

- Meaningful JSON payloads
- Consistent response formats
- Validation for input data
- Clear error messages

---

# Versioning

Prefer

- Versioned APIs when breaking changes are expected
- Backward-compatible changes where possible

---

# Security

Always

- Authenticate and authorize requests
- Validate inputs
- Use HTTPS
- Protect sensitive data

---

# Performance

Optimize

- Pagination
- Caching where appropriate
- Efficient payload sizes
- Idempotent operations for retries

---

# Final Rule

Design REST APIs that are intuitive, secure, scalable, and easy to consume.
