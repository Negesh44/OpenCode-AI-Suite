# Security Knowledge Base v1.0

## Security Principles

Always design software assuming it will be attacked.

Security must be built into every layer.

---

# Authentication

Supported

- JWT
- OAuth2
- Google Login
- Microsoft Login
- Multi-Factor Authentication

Never

- Store plain text passwords
- Disable authentication
- Use weak secrets

---

# Authorization

Always implement

- RBAC
- Least Privilege
- Resource Ownership
- Permission Validation

Never trust client-side roles.

---

# Password Security

Always

- BCrypt
- Argon2
- Minimum 12 Characters
- Password Complexity
- Password Reset Tokens

Never

- MD5
- SHA1
- Plain Text
- Reversible Encryption

---

# OWASP Top 10

Always review

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

# Input Validation

Validate

- Request Body
- Query Parameters
- Headers
- Cookies
- Uploaded Files

Reject invalid input immediately.

---

# SQL Injection

Always

- Prepared Statements
- Parameterized Queries
- ORM
- Input Validation

Never

- String Concatenation
- Dynamic SQL

---

# XSS

Always

- Escape Output
- Sanitize HTML
- Validate Input
- Content Security Policy

Never trust browser input.

---

# CSRF

Enable CSRF protection where appropriate.

For stateless JWT APIs, disable only with proper justification.

---

# JWT

Always

- Expiration
- Refresh Tokens
- Strong Secret
- HTTPS

Never

- Long-lived tokens
- Store secrets in source code

---

# API Security

Always

- HTTPS
- Authentication
- Authorization
- Rate Limiting
- Input Validation
- Request Size Limits

---

# File Upload

Always

- Validate MIME Type
- Validate Extension
- Limit Size
- Rename Files
- Virus Scan
- Store Outside Public Folder

---

# Docker Security

Always

- Non-root User
- Small Images
- Secret Management
- Image Scanning
- Read-only Filesystem where possible

---

# Cloud Security

Review

- IAM
- Security Groups
- Firewalls
- Secrets
- Encryption
- Logging

---

# Logging

Never log

- Passwords
- JWT
- API Keys
- Secrets

Always log

- Authentication Events
- Authorization Failures
- Critical Errors

---

# Incident Response

Always prepare

- Backups
- Restore Plan
- Audit Logs
- Monitoring
- Alerting

---

# Security Checklist

✔ Authentication

✔ Authorization

✔ Validation

✔ Encryption

✔ Logging

✔ HTTPS

✔ Secrets

✔ Backups

✔ Monitoring

---

# Final Rule

Security is everyone's responsibility.

Build secure software by default.