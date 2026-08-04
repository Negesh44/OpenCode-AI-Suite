---
description: Standard workflow for reviewing software quality before production.
---

# Review Workflow

## Objective

Perform a comprehensive production readiness review.

---

## Phase 1 — Scope

Agent

- Project Manager

Determine

- Project
- Feature
- Pull Request
- Module
- Branch

---

## Phase 2 — Architecture Review

Agent

- Reviewer

Verify

- SOLID
- DRY
- KISS
- Clean Architecture
- Folder Structure
- Naming
- Maintainability

---

## Phase 3 — Security Review

Agent

- Security

Verify

- Authentication
- Authorization
- JWT
- OAuth
- SQL Injection
- XSS
- CSRF
- Dependency Vulnerabilities
- Secrets

---

## Phase 4 — Performance Review

Agent

- Performance

Review

- Slow Queries
- N+1 Queries
- API Response Time
- Memory Usage
- CPU Usage
- Bundle Size
- Rendering Performance
- Caching

---

## Phase 5 — Testing Review

Agent

- Tester

Verify

- Unit Tests
- Integration Tests
- End-to-End Tests
- Regression Tests
- Edge Cases
- Error Handling

---

## Phase 6 — Documentation Review

Agent

- Documentation

Verify

- README
- API Documentation
- Deployment Guide
- Changelog
- Environment Variables

---

## Phase 7 — Final Decision

Agent

- Reviewer

Possible outcomes

✅ Production Ready

⚠ Ready with Minor Changes

❌ Requires Major Changes

🚫 Reject

---

## Completion Criteria

A review passes only when

- Security Approved
- Performance Approved
- Tests Passed
- Documentation Updated
- Reviewer Approved