# React Knowledge Base v1.0

## Preferred Stack

- React 19+
- Vite
- TypeScript (Preferred)
- JavaScript (Allowed)
- Tailwind CSS
- Framer Motion
- React Router
- Axios

---

# Project Structure

src/

assets/

components/

pages/

layouts/

hooks/

services/

context/

utils/

constants/

styles/

Never place business logic inside UI components.

---

# Components

Always

- Functional Components
- Small Components
- Reusable Components
- Single Responsibility

Never create massive components.

---

# Hooks

Prefer

- useState
- useEffect
- useMemo
- useCallback
- useRef

Extract reusable logic into custom hooks.

---

# State Management

Use

- Context API
- Zustand

Use Redux only for large applications.

---

# Styling

Preferred

- Tailwind CSS
- CSS Modules

Avoid

- Bootstrap
- jQuery
- Large inline styles

---

# Routing

Use

React Router

Organize routes by feature.

Protect authenticated routes.

---

# API Layer

Store API calls inside

services/

Never call fetch or axios directly inside pages.

---

# Forms

Always

- Controlled Components
- Validation
- Loading State
- Success State
- Error State

---

# Performance

Always

- Lazy Loading
- Code Splitting
- Memoization
- Virtualization for large lists
- Image Optimization

Avoid unnecessary re-renders.

---

# Accessibility

Always

- Semantic HTML
- Labels
- Keyboard Navigation
- ARIA attributes
- Color Contrast

---

# UI Design

Inspired by

- Apple
- Linear
- GitHub
- Vercel
- Notion

Design should be

- Clean
- Modern
- Minimal
- Responsive

---

# Animations

Use

Framer Motion

Only when it improves UX.

Avoid excessive animation.

---

# Folder Responsibilities

components/

Reusable UI

pages/

Route Components

services/

API Calls

hooks/

Custom Hooks

utils/

Helper Functions

context/

Global State

layouts/

Application Layouts

---

# Error Handling

Handle

- API Errors
- Loading
- Empty States
- Network Failures

Never leave users without feedback.

---

# Code Quality

Always

- SOLID
- DRY
- KISS
- Reusable Components
- Meaningful Naming

---

# Final Rule

Every React application should feel fast, responsive, and production-ready.