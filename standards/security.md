# OAES Security Standards v1.0

## Security First

Every application must be designed assuming attackers exist.

Security is never optional.

---

# Authentication

Always

- JWT
- OAuth2
- Google Login
- Session Expiration
- Refresh Tokens

Never

- Plain text passwords
- Weak passwords
- Hardcoded credentials

---

# Authorization

Always

- Role Based Access Control (RBAC)
- Least Privilege
- Verify every request

Never trust client-side roles.

---

# Passwords

Always

- Hash passwords
- Use BCrypt or Argon2
- Minimum 12 characters
- Require strong passwords

Never

- Store plain text passwords
- Encrypt instead of hashing

---

# Input Validation

Validate

- Request Body
- Path Variables
- Query Parameters
- File Uploads
- JSON

Reject invalid input immediately.

---

# SQL Injection

Always

- Prepared Statements
- Parameterized Queries
- JPA Repository
- ORM

Never

- String concatenation in SQL

Bad

SELECT * FROM users WHERE id=" + id

Good

Repository.findById(id)

---

# XSS

Always

- Escape user input
- Sanitize HTML
- Validate data

Never render raw HTML unless trusted.

---

# CSRF

Enable CSRF protection where appropriate.

Disable only for stateless JWT APIs with proper reasoning.

---

# File Upload

Always

- Validate file type
- Validate size
- Rename uploaded files
- Store outside public directory
- Scan if possible

Never trust file extensions.

---

# API Security

Always

- HTTPS
- Authentication
- Authorization
- Rate Limiting
- Request Validation

Return only necessary data.

---

# Secrets

Store

- API Keys
- JWT Secret
- Database Passwords

inside

- Environment Variables
- Secret Managers

Never commit secrets to Git.

---

# Logging

Never log

- Passwords
- JWT Tokens
- API Keys
- Secrets

Log

- Errors
- Warnings
- Login attempts
- Important events

---

# Error Handling

Never expose

- Stack traces
- SQL errors
- Internal server details

Return user-friendly error messages.

---

# Dependencies

Keep dependencies updated.

Remove unused libraries.

Monitor security advisories.

---

# OWASP

Always consider

- Broken Access Control
- Cryptographic Failures
- Injection
- Insecure Design
- Security Misconfiguration
- Vulnerable Components
- Authentication Failures
- Data Integrity Failures
- Logging Failures
- SSRF

---

# Final Rule

Security is part of development, not something added later.