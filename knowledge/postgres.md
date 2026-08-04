# PostgreSQL Knowledge Base

## Objective

Provide best practices for designing, optimizing, securing, and operating PostgreSQL databases.

---

# Version

Preferred

- PostgreSQL 16+

---

# Database Design

Always

- Normalize appropriately
- Use Primary Keys
- Use Foreign Keys
- Define Constraints
- Use CHECK constraints where appropriate
- Use UUIDs when globally unique identifiers are beneficial

---

# Naming Convention

Tables

- users
- products
- orders

Columns

- id
- created_at
- updated_at
- email
- order_id

Functions

- snake_case

---

# Data Types

Prefer

- UUID
- BIGINT
- VARCHAR
- TEXT
- BOOLEAN
- NUMERIC
- DATE
- TIMESTAMP WITH TIME ZONE (timestamptz)
- JSONB (when appropriate)

Avoid oversized column definitions.

---

# Indexing

Use

- Primary Indexes
- Foreign Key Indexes
- Composite Indexes
- Partial Indexes
- GIN Indexes for JSONB and Full-Text Search

Review index usage regularly.

---

# Queries

Prefer

- Explicit JOINs
- Parameterized Queries
- LIMIT + OFFSET or Keyset Pagination
- EXPLAIN ANALYZE for optimization

Avoid

- SELECT *
- Unnecessary subqueries
- Repeated queries

---

# Transactions

Always

- Follow ACID
- Keep transactions short
- Rollback on failure

Use isolation levels appropriately.

---

# Performance

Optimize

- Query Plans
- Index Usage
- Vacuum
- Analyze
- Connection Pooling
- Batch Operations

Use pg_stat_statements to identify slow queries.

---

# JSON Support

Use JSONB when

- Flexible schemas are required
- Querying JSON fields is necessary

Avoid using JSONB as a replacement for proper relational design.

---

# Security

Always

- Least Privilege
- SSL Connections
- Role-based Access
- Parameterized Queries

Never

- Expose superuser credentials
- Hardcode passwords

---

# Backup

Maintain

- Automated Backups
- Point-in-Time Recovery (PITR)
- WAL Archiving
- Restore Testing

---

# Monitoring

Monitor

- Slow Queries
- Locks
- Deadlocks
- Replication
- CPU
- Memory
- Connections

---

# Documentation

Maintain

- Schema
- Constraints
- Indexes
- Migrations
- Backup Strategy

---

# Final Rule

Leverage PostgreSQL's advanced capabilities while keeping the schema simple, performant, and maintainable.