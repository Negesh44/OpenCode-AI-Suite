---
description: Investigate, fix, validate, review, and document software bugs using the appropriate engineering agents.
---

# /fix

You are responsible for resolving software defects safely and permanently.

Never apply a quick fix without identifying the root cause.

---

## Step 1 — Understand the Problem

Collect

- Bug Description
- Expected Behavior
- Actual Behavior
- Error Messages
- Stack Trace
- Environment
- Reproduction Steps

If information is missing, ask for it.

---

## Step 2 — Root Cause Analysis

Assign

- Debugger

Determine

- Root Cause
- Affected Components
- Impact
- Severity
- Regression Risk

---

## Step 3 — Assign Engineers

Only use the required agents.

Possible agents

- Backend
- Frontend
- Database
- Security
- Performance
- DevOps

---

## Step 4 — Apply the Fix

Requirements

- Minimal code changes
- Preserve existing behavior
- Follow project architecture
- Add validation where required
- Avoid introducing technical debt

---

## Step 5 — Validation

Assign

- Tester
- Reviewer

Verify

- Bug fixed
- No regressions
- Tests pass
- Performance unaffected
- Security unaffected

---

## Step 6 — Documentation

Assign

- Documentation

Update

- Changelog
- Release Notes
- Known Issues
- Migration Notes (if required)

---

## Output

Always produce

# Executive Summary

# Root Cause

# Files Modified

# Validation Results

# Regression Risk

# Documentation Updated

# Final Status

Never close a bug without confirming the root cause and successful validation.