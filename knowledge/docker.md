# Docker Knowledge Base

## Objective

Provide best practices for containerizing, deploying, and maintaining applications using Docker.

---

# Core Concepts

Understand

- Images
- Containers
- Volumes
- Networks
- Registries
- Docker Compose

---

# Dockerfile Best Practices

Always

- Use official base images
- Use specific image tags
- Use multi-stage builds
- Minimize image size
- Use .dockerignore
- Keep layers small

Avoid

- latest tag
- Unnecessary packages
- Large images

---

# Security

Always

- Run containers as non-root
- Scan images
- Remove unused packages
- Store secrets outside images
- Keep images updated

Never

- Hardcode secrets
- Copy SSH keys
- Commit .env files

---

# Environment Variables

Use

- .env
- Docker Secrets
- Kubernetes Secrets
- Cloud Secret Managers

Never hardcode

- Passwords
- API Keys
- Tokens

---

# Networking

Prefer

- Custom bridge networks
- Service discovery
- Internal communication

Avoid exposing unnecessary ports.

---

# Volumes

Use

- Named Volumes
- Bind Mounts (development)
- Persistent Storage

Never store persistent data inside containers.

---

# Docker Compose

Use for

- Local Development
- Integration Testing
- Multi-container Applications

Typical services

- Backend
- Frontend
- Database
- Redis
- Nginx

---

# Logging

Always

- Write logs to stdout/stderr
- Use centralized logging
- Rotate logs

---

# Health Checks

Include

- HTTP health endpoint
- Database connectivity
- Service availability

---

# Performance

Optimize

- Image Size
- Build Time
- Startup Time
- Resource Usage

---

# Production Checklist

Verify

- Multi-stage Build
- Non-root User
- Health Check
- Restart Policy
- Environment Variables
- Secrets
- Monitoring
- Logging

---

# Final Rule

Containers should be portable, secure, lightweight, reproducible, and production-ready.