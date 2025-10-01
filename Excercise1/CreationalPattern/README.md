### Creational Pattern
### 1. Singleton Pattern
- **Class:** `ScheduleManager`
- **Purpose:** Ensures there is **only one instance** of the task manager that handles all tasks throughout the application.
- **Benefit:**  
  - Guarantees a single source of truth for task management.  
  - Prevents multiple conflicting instances of task storage.  
  - Simplifies global access to task management functionality.  

--------------------------------------------------------------------------------------------------------------
### 2. Factory Pattern 
The **Factory Pattern-**creational design pattern** used to encapsulate the creation of objects. It separates the object creation logic from the business logic, providing a centralized place to manage object instantiation.  

In this project, the **Factory Pattern** is applied to create `Task` objects in a consistent and maintainable way.

---

## Purpose of Factory Pattern in this Project
- Centralizes the creation of `Task` objects.
- Separates object creation from the main application logic (`Main.java` and `ScheduleManager.java`).

---## Implementation in Project
- **Class:** `TaskFactory`
- **Method:** `createTask(String description, LocalTime startTime, LocalTime endTime, int priority)`

```java
Task task = TaskFactory.createTask(description, startTime, endTime, priority);