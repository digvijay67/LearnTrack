
# **Question & Notes**

```markdown
# Design Notes - LearnTrack

## 1. Why you used ArrayList instead of array
- Used **ArrayList** instead of array because:
  - Dynamic size, no need to predefine capacity.
  - Easy to add/remove entities (students, courses, enrollments).
  - Supports iteration with for-each loops.
  - 

## 2. Where you used static members and why
- **IdGenerator** class:
  - `private static int counter` → ensures unique IDs for Students, Courses, Enrollments.
  - `public static int generateId()` → provides the next unique ID.
- Reason:
  - Static ensures a **shared counter** across all objects.
  - No need to create separate IdGenerator objects for each entity.

## 3. Inheritance Usage
- Base class: **Person** → common fields: `id`, `name`, `email`, `phone`.
- Derived class: **Student extends Person** → adds `active` status, associated course info.
- Benefit:
  - Reuse of common fields and methods.
  - Simplifies code and demonstrates **OOP inheritance** principle.
  - Easy to extend in future (e.g., Trainer class).

## 4. Exception Handling
- **EntityNotFoundException** : thrown when student/course not found.
- **InvalidInputException** : handles invalid strings, email, or numbers.
- All user input validated using **InputValidator**.

## 5. Clean Code Principles Followed
- Each method performs a **single responsibility principle** .
- Meaningful names for methods and variables.
- Services handle business logic; repositories handle storage.
- Main.java focuses on UI/menu only.
- Minimal use of hardcoded values; constants are defined in `MenuOptions` or enums.
