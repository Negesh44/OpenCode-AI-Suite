---
description: Standard workflow for safely refactoring software while preserving existing behavior.
---

# Refactor Workflow

## Objective

Improve code quality, maintainability, readability, and performance without changing business functionality.

---

## Phase 1 — Analysis

Agent

- Architect

Review

- Current Architecture
- Technical Debt
- Code Smells
- Complexity
- Dependency Graph

Output

- Refactoring Plan

---

## Phase 2 — Risk Assessment

Agent

- Project Manager

Determine

- Scope
- Dependencies
- Risks
- Rollback Strategy

---

## Phase 3 — Refactoring

Agents

- Backend
- Frontend
- Database

Possible Tasks

- Rename
- Extract Methods
- Extract Classes
- Remove Dead Code
- Improve Folder Structure
- Simplify Logic
- Improve Reusability

---

## Phase 4 — Security Review

Agent

- Security

Verify

- No security regressions
- Authentication unchanged
- Authorization unchanged

---

## Phase 5 — Performance Review

Agent

- Performance

Verify

- No new bottlenecks
- Faster execution where possible
- Better memory usage

---

## Phase 6 — Code Review

Agent

- Reviewer

Review

- Maintainability
- Readability
- SOLID
- DRY
- KISS

---

## Phase 7 — Testing

Agent

- Tester

Verify

- Unit Tests
- Integration Tests
- Regression Tests
- Existing functionality preserved

---

## Phase 8 — Documentation

Agent

- Documentation

Update

- Architecture
- Developer Guide
- Changelog

---

## Completion Criteria

Refactoring is complete only if

- Behavior unchanged
- Tests pass
- Reviewer approved
- Performance maintained or improved
- Documentation updated