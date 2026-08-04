# AWS Knowledge Base

## Objective

Provide best practices for designing, deploying, securing, and operating applications on Amazon Web Services (AWS).

---

# Core Services

Compute

- EC2
- ECS
- EKS
- Lambda

Storage

- S3
- EBS
- EFS

Database

- RDS
- Aurora
- DynamoDB
- ElastiCache

Networking

- VPC
- Route 53
- CloudFront
- Elastic Load Balancer

Security

- IAM
- KMS
- Secrets Manager
- WAF
- Shield

Monitoring

- CloudWatch
- CloudTrail
- AWS Config

---

# IAM

Always

- Least Privilege
- Separate Roles
- MFA
- Temporary Credentials

Never

- Use Root Account
- Hardcode Access Keys

---

# Compute

Choose

EC2

- Long-running applications

Lambda

- Event-driven workloads

ECS

- Containerized applications

EKS

- Kubernetes workloads

---

# Storage

Use

S3

- Static Assets
- Backups
- Object Storage

Enable

- Versioning
- Encryption
- Lifecycle Policies

---

# Database

Choose

RDS

- Traditional relational applications

Aurora

- High-performance relational workloads

DynamoDB

- Serverless NoSQL

Always

- Enable Backups
- Encryption
- Monitoring

---

# Networking

Configure

- Private Subnets
- Public Subnets
- NAT Gateway
- Security Groups
- Network ACLs

Never expose internal resources unnecessarily.

---

# Security

Always

- Encrypt Data at Rest
- Encrypt Data in Transit
- Rotate Secrets
- Enable CloudTrail
- Enable GuardDuty
- Enable Security Hub

---

# Monitoring

Monitor

- CPU
- Memory
- Network
- Disk
- API Latency
- Error Rate

Use

- CloudWatch
- Alarms
- Dashboards

---

# Cost Optimization

Always

- Use Auto Scaling
- Stop unused resources
- Monitor costs
- Use Reserved or Savings Plans where appropriate
- Optimize storage lifecycle

---

# Backup & Recovery

Implement

- Automated Backups
- Cross-Region Replication (when required)
- Disaster Recovery Plan
- Restore Testing

---

# CI/CD

Integrate

- GitHub Actions
- AWS CodePipeline
- AWS CodeBuild
- AWS CodeDeploy

---

# Documentation

Maintain

- Infrastructure Diagram
- IAM Policies
- Deployment Guide
- Recovery Procedures
- Cost Optimization Notes

---

# Final Rule

Build AWS solutions that are secure, scalable, resilient, observable, and cost-efficient.