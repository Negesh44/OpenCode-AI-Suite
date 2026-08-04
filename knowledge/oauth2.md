# OAuth 2.0 Knowledge Base

## Objective

Provide best practices for implementing OAuth 2.0 authorization flows securely.

---

# Core Concepts

Understand

- Authorization server
- Resource server
- Client applications
- Access tokens
- Refresh tokens

---

# Security Principles

Always

- Use HTTPS
- Use short-lived access tokens
- Rotate secrets and refresh tokens
- Validate token issuer, audience, and expiration

Avoid

- Storing tokens in insecure locations
- Using implicit flow for new applications

---

# Recommended Flows

Prefer

- Authorization Code flow with PKCE for web and mobile apps
- Client Credentials flow for service-to-service communication

---

# Best Practices

Use

- Scoped permissions
- Clear consent prompts
- Proper token revocation handling

---

# Final Rule

Implement OAuth 2.0 with least privilege, strong validation, and secure token handling.
