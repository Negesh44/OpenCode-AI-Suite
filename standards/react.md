# OAES React Standards v1.0

## React Version

Prefer

- React 19+
- Vite
- TypeScript (preferred)
- JavaScript (acceptable)

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

styles/

constants/

Never place everything inside one folder.

---

# Components

Always

- Functional Components
- Small Components
- Reusable Components
- Single Responsibility

Never create components larger than necessary.

---

# Hooks

Prefer

- useState
- useEffect
- useMemo
- useCallback
- useRef

Create custom hooks for reusable logic.

Never duplicate hook logic.

---

# State Management

Use

- Context API
- Zustand

Use Redux only when application complexity requires it.

---

# Styling

Preferred

- Tailwind CSS
- CSS Modules

Never

- Bootstrap
- jQuery
- Inline styles (except dynamic values)

---

# UI

Design inspired by

- Apple
- Linear
- Vercel
- GitHub
- Notion

Always

- Responsive
- Accessible
- Modern
- Minimal

---

# Animations

Use

Framer Motion

Only when animations improve UX.

Avoid unnecessary animations.

---

# API Calls

Store all API logic inside

services/

Never call APIs directly inside UI components.

---

# Forms

Use

Controlled Components

Validate

- Required fields
- Email
- Password
- Number
- Date

Display meaningful validation messages.

---

# Routing

Use

React Router

Organize routes logically.

Protect private routes.

---

# Performance

Always

- Lazy Loading
- Code Splitting
- Memoization
- Pagination
- Debouncing

Avoid unnecessary re-renders.

---

# Accessibility

Always

- Semantic HTML
- Labels
- Keyboard Navigation
- ARIA attributes when needed

Never sacrifice accessibility for design.

---

# Error Handling

Handle

- Network Errors
- API Errors
- Loading States
- Empty States

Never leave users without feedback.

---

# Folder Naming

Use

PascalCase → Components

camelCase → Variables

kebab-case → CSS files

---

# Code Quality

Follow

- SOLID
- DRY
- KISS

Keep components readable.

Extract repeated logic.

---

# Final Rule

Build React applications that are fast, beautiful, reusable, accessible, and easy to maintain.