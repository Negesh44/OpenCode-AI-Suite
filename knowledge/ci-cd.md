# CI/CD Knowledge Base

## Objective

Provide best practices for building reliable continuous integration and continuous delivery pipelines.

---

# Principles

Always

- Automate builds and tests
- Run fast feedback checks early
- Keep deployments repeatable
- Use versioned configuration

---

# Pipeline Design

Prefer

- Separate build, test, and deploy stages
- Parallel execution where appropriate
- Environment-specific deployment strategies
- Rollback plans

---

# Security

Always

- Protect secrets with dedicated secret stores
- Restrict deployment permissions
- Verify artifact integrity
- Use signed builds where possible

---

# Quality Gates

Include

- Linting
- Unit tests
- Integration tests
- Security scans

---

# Final Rule

CI/CD pipelines should be fast, reliable, secure, and easy to audit.
