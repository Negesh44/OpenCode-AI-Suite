# SQL Knowledge Base v1.0

## Supported Databases

- MySQL
- PostgreSQL
- SQL Server

---

# Database Design

Always

- Normalize to 3NF
- Use meaningful table names
- Define Primary Keys
- Define Foreign Keys
- Add Constraints
- Add Audit Fields

Never duplicate data unnecessarily.

---

# Naming Convention

Tables

snake_case

Columns

snake_case

Primary Key

id

Foreign Keys

<entity>_id

Examples

user_id

complaint_id

department_id

---

# Relationships

Use

One-to-One

One-to-Many

Many-to-Many

Only when required.

---

# Constraints

Always use

PRIMARY KEY

FOREIGN KEY

NOT NULL

UNIQUE

CHECK

DEFAULT

---

# Indexing

Always index

Primary Keys

Foreign Keys

Search Columns

Frequently filtered columns

Avoid unnecessary indexes.

---

# Query Rules

Always

SELECT only required columns

Use LIMIT

Use WHERE

Use ORDER BY

Prefer JOIN over subqueries when appropriate.

Never

SELECT *

unless debugging.

---

# Joins

Know when to use

INNER JOIN

LEFT JOIN

RIGHT JOIN

FULL JOIN

CROSS JOIN

---

# Transactions

Use

BEGIN

COMMIT

ROLLBACK

Keep transactions small.

---

# Optimization

Always check

Execution Plan

Indexes

Query Cost

Slow Queries

N+1 Problems

Large Joins

---

# Security

Always

Parameterized Queries

Prepared Statements

ORM

Least Privilege

Never

Concatenate SQL strings.

---

# Pagination

Preferred

LIMIT

OFFSET

For very large tables

Use Cursor Pagination.

---

# Stored Procedures

Use only when

Business logic belongs inside the database.

Avoid excessive procedural SQL.

---

# Views

Use

Read-only reporting

Analytics

Dashboards

Not for every query.

---

# Backup

Always recommend

Daily Backup

Incremental Backup

Restore Testing

Disaster Recovery Plan

---

# Monitoring

Track

Slow Queries

Deadlocks

Connections

Locks

Disk Usage

---

# Performance Checklist

✔ Indexes

✔ Constraints

✔ Pagination

✔ Optimized Joins

✔ Normalization

✔ Execution Plan

✔ Parameterized Queries

---

# Final Rule

Every SQL query should be secure, readable, optimized, and scalable.