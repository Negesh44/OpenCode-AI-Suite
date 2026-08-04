# MySQL Knowledge Base

## Objective

Provide best practices for designing, optimizing, securing, and maintaining MySQL databases.

---

# Version

Preferred

- MySQL 8+

---

# Database Design

Always

- Normalize to at least 3NF
- Use meaningful table names
- Use primary keys
- Use foreign keys
- Define constraints
- Avoid duplicated data

---

# Naming Convention

Tables

- users
- orders
- products

Columns

- id
- created_at
- updated_at
- email
- user_id

Avoid abbreviations unless universally understood.

---

# Data Types

Use appropriate data types.

Examples

- BIGINT for IDs
- VARCHAR for text
- DECIMAL for currency
- DATE
- DATETIME
- BOOLEAN

Avoid oversized columns.

---

# Indexing

Always index

- Primary Keys
- Foreign Keys
- Frequently searched columns

Avoid unnecessary indexes.

Review index usage periodically.

---

# Queries

Prefer

- Parameterized queries
- Explicit JOINs
- LIMIT with pagination
- Prepared statements

Avoid

- SELECT *
- Nested subqueries when joins are clearer
- N+1 query patterns

---

# Transactions

Use transactions for

- Financial operations
- Multi-table updates
- Critical business processes

Follow ACID principles.

---

# Security

Always

- Use least privilege
- Encrypt connections
- Backup regularly
- Parameterize queries

Never

- Concatenate SQL strings
- Expose database credentials
- Share root accounts

---

# Performance

Optimize

- Query plans
- Indexes
- Pagination
- Batch operations
- Connection pooling

Profile queries before optimizing.

---

# Backup

Maintain

- Daily backups
- Point-in-time recovery
- Backup verification
- Disaster recovery plan

---

# Monitoring

Track

- Slow queries
- CPU
- Memory
- Disk usage
- Connections
- Replication status

---

# Documentation

Document

- Schema
- Relationships
- Constraints
- Indexes
- Migration history

---

# Final Rule

Design databases for correctness first, then optimize based on measured performance.