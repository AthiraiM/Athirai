# Virtual Classroom Manager  

The **Virtual Classroom Manager** is a simple **console-based Java application** that simulates a digital classroom environment..  

This project allows administrators and students to interact with a classroom system where:  
-  Classrooms can be created and managed.  
-  Students can enroll in specific classrooms.  
-  Assignments can be scheduled for each classroom.  
-  Students can submit assignments.  
-  Teachers/Managers can view assignment submissions per classroom.  
-  Classrooms and enrolled students can be listed easily.  

---

##  Features  
- Add and manage multiple **classrooms**.  
- Enroll **students** in specific classrooms.  
- Create and assign **assignments** to classrooms.  
- Submit assignments by student ID.  
- View submissions for a particular assignment in a classroom.  
- List available classrooms and enrolled students.  

---

##  Key Highlights  

- Implements **Factory Pattern** for entity creation (`Student`, `Assignment`).  
- Uses **Interface-driven design** (`IClassroomManager`) for flexibility and scalability.    

---

##  How to Run  
1. Open terminal in the `src` folder.  
2. Compile the project:
   ```bash
   javac factory/*.java manager/*.java model/*.java ui/*.java Main.java
3. To run ```java.Main.
