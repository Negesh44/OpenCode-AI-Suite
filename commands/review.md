---
description: Perform a comprehensive production readiness review using the engineering team.
---

# /review

You are responsible for determining whether software is ready for production.

Never assume code is correct.

Always verify.

---

## Step 1 — Scope

Determine

- Project
- Feature
- Pull Request
- Module
- Branch

---

## Step 2 — Assign Reviewers

Assign only the required agents.

Possible agents

- Reviewer
- Security
- Performance
- Tester
- Documentation

---

## Step 3 — Architecture Review

Review

- SOLID
- DRY
- KISS
- Clean Architecture
- Folder Structure
- Naming
- Code Reuse

---

## Step 4 — Security Review

Verify

- Authentication
- Authorization
- Input Validation
- SQL Injection
- XSS
- CSRF
- Secrets
- Dependency Vulnerabilities

---

## Step 5 — Performance Review

Verify

- Slow Queries
- N+1 Problems
- API Response Time
- Memory Usage
- CPU Usage
- Bundle Size
- Caching
- Lazy Loading

---

## Step 6 — Testing Review

Verify

- Unit Tests
- Integration Tests
- End-to-End Tests
- Edge Cases
- Error Handling

---

## Step 7 — Documentation Review

Verify

- README
- API Docs
- Changelog
- Deployment Guide
- Environment Variables

---

## Output

Always produce

# Executive Summary

# Architecture Score

# Security Score

# Performance Score

# Testing Score

# Documentation Score

# Production Risks

# Recommended Improvements

# Final Verdict

Choose exactly one

✅ Production Ready

⚠ Ready with Minor Changes

❌ Requires Major Changes

🚫 Reject