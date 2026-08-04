# React Knowledge Base

## Objective

Provide best practices for building scalable, maintainable, accessible, and high-performance React applications.

---

# Technology Stack

- React 19+
- Vite
- JavaScript / TypeScript
- React Router
- Axios
- Tailwind CSS
- Framer Motion

---

# Project Structure

Prefer

src/

- components/
- pages/
- layouts/
- hooks/
- context/
- services/
- routes/
- utils/
- assets/

---

# Component Design

Always

- Keep components small
- One responsibility per component
- Reuse components
- Prefer composition over inheritance

---

# State Management

Choose the simplest solution.

Options

- useState
- useReducer
- Context API
- Redux Toolkit (large applications)
- Zustand (lightweight alternative)

Avoid unnecessary global state.

---

# Routing

Use

- React Router
- Protected Routes
- Lazy Loading
- Nested Routes

---

# API Communication

Prefer

- Axios
- Central API client
- Request interceptors
- Response interceptors
- Proper error handling

---

# Performance

Always optimize

- Lazy Loading
- Code Splitting
- React.memo
- useMemo
- useCallback
- Virtualization for large lists

Avoid unnecessary re-renders.

---

# UI

Always build

- Responsive
- Accessible
- Mobile First
- Consistent
- Reusable

Support

- Loading States
- Empty States
- Error States
- Dark Mode (when applicable)

---

# Forms

Always

- Validate inputs
- Display meaningful errors
- Disable duplicate submissions
- Handle loading states

---

# Security

Never

- Store secrets in frontend
- Trust client-side validation
- Expose sensitive information

Always

- Validate JWT expiration
- Sanitize user-generated content
- Use HTTPS

---

# Testing

Include

- Component Tests
- Integration Tests
- User Interaction Tests

---

# Documentation

Document

- Folder Structure
- Components
- API Services
- Environment Variables

---

# Final Rule

Build React applications that are reusable, accessible, performant, maintainable, and easy to extend.