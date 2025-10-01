# Structural Patterns Demo in Java

This project demonstrates the use of **two structural design patterns** in Java: **Adapter** and **Decorator**. 

---

## **1. Adapter Pattern – Power Socket Example**

**Pattern Type:** Structural  
**Purpose:** Converts the interface of a class into another interface that a client expects. This allows classes with incompatible interfaces to work together.



### **Key Classes**
- `Socket` → Target interface  
- `OldSocket` → Existing class providing 110V  
- `NewDevice` → Class requiring 220V  
- `SocketAdapter` → Adapter class implementing `Socket` and converting voltage  
- `AdapterDemoMenu` → Menu-driven demonstration allowing the user to input voltage and see the adapter in action  

### **Highlights**
- Menu-driven input allows user to choose the voltage.  
- Input validation ensures safe and valid choices.  
- Logging provides feedback on program actions.  

----------------------------------------------------------------------------------------------------------------------

## **2. Decorator Pattern – Sandwich Example**

**Pattern Type:** Structural  
**Purpose:** Allows behavior to be added to individual objects dynamically without affecting other objects of the same class. It provides a flexible alternative to subclassing for extending functionality.

### **Use Case in this Project**
- Scenario: You have a **basic sandwich** and want to add ingredients like **cheese** and **tomato**.  
- Problem: Creating separate subclasses for every possible combination would be cumbersome.  
- Solution: Decorators dynamically wrap the base sandwich and add ingredients.

### **Key Classes**
- `Sandwich` → Component interface  
- `BasicSandwich` → Concrete component  
- `SandwichDecorator` → Abstract decorator class  
- `CheeseDecorator` → Adds cheese  
- `TomatoDecorator` → Adds tomato  
- `DecoratorDemo` → Menu-driven demonstration allowing the user to choose ingredients dynamically  

### **Highlights**
- Users can add ingredients interactively via a menu.  
- Each decorator wraps the previous sandwich, enabling dynamic behavior composition.  
- Logging informs the user about the ingredients added.  

---

