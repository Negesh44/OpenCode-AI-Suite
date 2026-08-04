# Security Knowledge Base

## Objective

Provide security best practices for designing, developing, deploying, and maintaining secure software systems.

---

# Security Principles

Always follow

- Zero Trust
- Least Privilege
- Defense in Depth
- Secure by Default
- Fail Securely
- Principle of Least Knowledge

---

# Authentication

Use

- JWT
- OAuth2
- OpenID Connect
- Multi-Factor Authentication (MFA)

Always

- Hash passwords with BCrypt or Argon2
- Expire tokens
- Rotate refresh tokens
- Lock accounts after repeated failed logins

Never

- Store plaintext passwords
- Hardcode credentials
- Store secrets in source code

---

# Authorization

Always

- Role-Based Access Control (RBAC)
- Principle of Least Privilege
- Verify permissions on every protected endpoint
- Perform server-side authorization

Never rely only on frontend checks.

---

# Input Validation

Validate

- Request Body
- Query Parameters
- Path Variables
- Uploaded Files

Always

- Validate server-side
- Sanitize user input
- Reject unexpected fields

---

# OWASP Top 10

Protect against

- Broken Access Control
- Cryptographic Failures
- Injection Attacks
- Insecure Design
- Security Misconfiguration
- Vulnerable Dependencies
- Authentication Failures
- Software Integrity Failures
- Logging Failures
- SSRF

---

# API Security

Always

- HTTPS
- Authentication
- Authorization
- Rate Limiting
- Request Validation
- Response Validation
- API Versioning

Return only necessary data.

---

# Database Security

Always

- Prepared Statements
- Parameterized Queries
- Encryption at Rest
- Regular Backups
- Least Privilege Database Users

Never concatenate SQL queries.

---

# File Upload Security

Always

- Validate file type
- Validate file size
- Scan uploaded files when applicable
- Rename uploaded files
- Store outside the web root when possible

---

# Secrets Management

Store secrets in

- Environment Variables
- Secret Managers
- Vault Services

Never

- Commit API Keys
- Commit Passwords
- Commit Private Keys

---

# Logging

Log

- Authentication Events
- Authorization Failures
- Errors
- Security Events

Never log

- Passwords
- JWT Tokens
- API Keys
- Credit Card Numbers

---

# Dependency Management

Regularly

- Update dependencies
- Scan for vulnerabilities
- Remove unused packages

---

# Production Checklist

Verify

- HTTPS Enabled
- Secure Headers
- CORS Configured
- Rate Limiting Enabled
- Logging Enabled
- Monitoring Enabled
- Secrets Protected
- Backup Strategy

---

# Final Rule

Security is a continuous process. Every feature, review, deployment, and maintenance activity must consider security from design through production.