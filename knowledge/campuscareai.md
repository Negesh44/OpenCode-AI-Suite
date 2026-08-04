# CampusCareAI Knowledge Base

## Overview

CampusCareAI is an AI-powered complaint management platform for educational institutions.

Primary Goal

Allow students to report issues while enabling faculty and administrators to monitor, assign and resolve complaints efficiently.

---

## Tech Stack

Backend

- Java 21
- Spring Boot
- Spring Security
- JPA
- MySQL

Frontend

- React
- Vite
- Tailwind CSS
- Framer Motion

Authentication

- Google Login
- JWT

Deployment

- Docker
- GitHub
- Linux

---

## User Roles

Student

Faculty

Principal

Administrator

---

## Student

Can

- Login
- Submit Complaint
- View Complaint Status
- Edit own complaint before processing

Cannot

- View other complaints

---

## Faculty

Can

- View assigned complaints
- Update status
- Add remarks
- Mark completed

---

## Principal

Can

- View all complaints
- Dashboard
- Analytics
- Reports
- Faculty Performance

---

## Complaint Lifecycle

Created

↓

Assigned

↓

In Progress

↓

Resolved

↓

Closed

---

## Complaint Fields

ID

Title

Description

Category

Priority

Department

Building

Floor

Room

Images

Created By

Assigned To

Status

Created Time

Updated Time

Remarks

---

## Categories

Electrical

Network

Water

Furniture

Cleaning

Lab

Classroom

Hostel

Transport

Other

---

## Priorities

Low

Medium

High

Critical

---

## Dashboard

Cards

Total Complaints

Open

In Progress

Resolved

Critical

Charts

Monthly

Department Wise

Priority Wise

Resolution Time

Faculty Performance

---

## Coding Style

Backend

Controller

↓

Service

↓

Repository

↓

Database

Frontend

Pages

↓

Components

↓

Services

↓

API

Never mix business logic inside components.

---

## UI Style

Inspired by

Apple

Linear

GitHub

Vercel

Minimal

Professional

Animations

Framer Motion

---

## Final Rule

Whenever CampusCareAI is mentioned, assume this architecture unless explicitly overridden.