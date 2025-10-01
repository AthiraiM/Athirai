# Behavioral Design Patterns Implementation

## Overview

This project demonstrates two important **Behavioral Design Patterns** in Java:  

1. **Command Pattern** – Encapsulates requests as objects, decoupling the invoker from the receiver.  
2. **Observer Pattern** – Defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified automatically.  

Behavioral patterns focus on **how objects interact and communicate**, improving **flexibility, maintainability, and scalability**.

------------------------------------------------------------------------------------------------------------

## 1. Command Pattern

### Purpose
The Command Pattern allows actions to be encapsulated as objects so that:  
- Clients can parameterize invokers with different commands.  
- Requests can be queued, logged, or undone.  
- Invokers are decoupled from the receiver.  

--------------------------------------------------------------------------------------------------------------------
## 2.Observer Pattern

### Overview
The **Observer Pattern** is a **behavioral design pattern** that defines a **one-to-many relationship** between objects.  
When the state of one object (the subject) changes, all dependent objects (the observers) are automatically notified and updated.  

This pattern is useful when you want to maintain consistency between related objects without tightly coupling them.

------------------------------------------------------------------------------------------------------------------------



### Benefits

- Promotes **maintainability** by decoupling components.
- Allows systems to **scale easily**, adding more observers without changing the subject logic.
- Ideal for **event-driven systems**, GUI updates, and notification systems.
