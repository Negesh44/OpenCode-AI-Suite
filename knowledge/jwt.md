# JWT Knowledge Base

## Objective

Provide best practices for creating, validating, and securely using JSON Web Tokens.

---

# Core Concepts

Understand

- Header
- Payload
- Signature
- Claims

---

# Security Best Practices

Always

- Use strong signing algorithms such as RS256 or ES256
- Validate signature, issuer, audience, and expiration
- Keep tokens short-lived
- Store tokens securely

Avoid

- Storing sensitive data directly in JWT payloads
- Using weak algorithms

---

# Usage Guidance

Prefer JWT for

- Stateless authentication
- API authorization
- Cross-service identity propagation

---

# Revocation and Rotation

Plan for

- Token revocation strategies
- Refresh token rotation
- Secret/key rotation

---

# Final Rule

Treat JWTs as bearer credentials and protect them with strong validation and secure storage practices.
