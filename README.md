# IIITD Management System

## Overview

This project simulates a college academic management system in Java, including functionalities for managing students, professors, courses, and complaints. The system uses object-oriented programming (OOP) principles

## Classes and Interfaces

### 1. **Classes**

- **`add_drop`**: Manages adding or dropping courses for students.
- **`AddDropDeadlinePassedException`**: Exception class to throw exception when student tries to register/drop courses when add/drop period is over.
- **`admin`**: Represents an administrative user with privileges to manage courses, students, and complaints.
- **`amdrun`**: Handles the execution flow for administrative operations.
- **`cgpa`**: Calculates the Cumulative Grade Point Average (CGPA) for students.
- **`complaint`**: Represents a student complaint.
- **`complaintlist`**: Manages a list of complaints.
- **`course`**: Abstract class for general course attributes.
- **`courselist`**: Maintains a list of courses and provides course-related operations.
- **`CourseFullException`**: Exception class to throw exception when student tries to register courses whose enrolment limit has been reached.
- **`feedback`**: Class to take feedbacks about completed courses from students.
- **`gpa`**: Interface for GPA calculations.
- **`GradeToGPA`**: Converts grades to GPA values.
- **`home`**: Entry point for the user interface.
- **`InvalidLoginException`**: Exception class to throw exception when a user enters incorrect password.
- **`Main`**: The main class that initializes the application and starts the user interface.
- **`mapcourse`**: Maps course codes to course details and professors.
- **`mkcourse`**: Creates and initializes courses for professors and students.
- **`mkuser`**: Handles user creation.
- **`prof_course`**: Represents a course assigned to a professor.
- **`professor`**: Represents a professor with courses and schedules.
- **`profrun`**: Manages professor-specific operations.
- **`sgpa`**: Calculates the Semester Grade Point Average (SGPA) for students.
- **`stdrun`**: Manages student-specific operations.
- **`stud_course`**: Represents a course that a student is enrolled in.
- **`student`**: Represents a student with courses and academic details.
- **`takeinp`**: Provides methods for input handling.
- **`teaching_asst`**: Provides assistance to professors for giving grades to students.
- **`updatecourse`**: Handles updates to course details.
- **`user`**: Base class for common user attributes and methods.
- **`userlist`**: Manages a list of users.
- **`usermap`**: Maps user IDs to their respective objects.
- **`usr_run`**: Interface for user-related operations.

### 2. **Interfaces**

- **`gpa`**: Interface for GPA calculation.
- **`usr_run`**: Interface for user-related operations, defining methods for displaying options and handling user input.

## Object-Oriented Principles

### 1. **Encapsulation**

- **Classes**: Attributes of `student`, `professor`, and `course` are encapsulated using private access modifiers and accessed via public getters and setters.
- **Methods**: Methods such as `get_details()` in `user` and `view_schedule()` in `professor` encapsulate specific functionalities.

### 2. **Inheritance**

- **Base Class**: `user` is the base class for `student` and `professor`, providing common attributes and methods. `course` is the base class for `stud_course` and `prof_course` class.
- **Subclassing**: `student` and `professor` extend `user` to inherit common features and add specific attributes or methods.`teaching_assnt` extend `student`. Exception handling classes extend the `Exception` class.

### 3. **Polymorphism**

- **Method Overriding**: Methods in subclasses override methods from the base class `user`, such as `get_details()`.
- **Interfaces**: `gpa` and `usr_run` interfaces are implemented by classes like `sgpa`, `cgpa`, `amdrun`, and `stdrun` to provide specific functionalities.

### 4. **Abstraction**

- **Abstract Class**: `course` serves as an abstract class with common attributes for specific courses like `prof_course` and `stud_course`.
- **Interfaces**: `gpa` and `usr_run` abstract common functionalities, allowing different implementations.

### **UML Class Diagrams**

The UML class diagrams can be found in the `UML` directory.

## Running the Code

1. **Compile the Code**:

   ```bash
   javac *.java
   ```

2. **Run the Code**:
   ```bash
   java Main
   ```

### Assumptions

- **Data Initialization**: The system assumes that course codes, credits, syllabus, titles and prerequisites are pre-defined in `courselist` and `mapcourse`.

- **Unique Identifiers**: Student and professor IDs are unique and managed correctly in `usermap`.

- **Error Handling**: Beside from the 3 necessary error handling, handling for most of the possible errors has been performed.

- **Enrolment limit**: The enrollment limit for all courses has been set to 3 by default.

- **Student class**:
  (No students are created by default)

1. The students are by default entered in sem 1. They can add a course only if the following are sattisfied:

   a. The student satisfies the course's prerequisites  
   b. The student has not exceeded the credit limit  
   c. The course is being offered in their semester  
   d. A professor has been assigned to that course

2. SGPA is calculated only for current semester only if professor gives grade. CGPA is calculated for all the completed courses of previous semester.
3. If a student fails a course it will be available in next semester.
4. A student can give anonymous feedback of a course when he/she has completed it.

- **Professor class**:
  (No professors are created by default)

1. The professor ID should include atleast one English alphabet (Otherwise prof.name is stored as "unkonwn")
2. The professor updates course details of the course he/she is offering
3. The professor can update grades of the students
4. The professor can get TA's assigned (if a student is eligible to become TA)to their current courses.
5. They can view feedback given to their completed courses.

- **Admin class**:

1. The admin has a single default account with password `admin@IIITD`
2. The admin can add/drop courses from course catalog (assuming the user doesn't drop courses which are currently taken by some professor or student).
3. The admin can update student's personal details
4. The admin has a special feature: It can end the semester, meaning that all the courses being currenlty taken by any professor and student are being removed and student's semester increments by one. This can only happen if all the students have recieved grades for all their courses

- **Teaching_asst class**:

1. A student can become a teaching assistant for a course if they have completed the course (No F grades) and they are not a TA for any other course in that semester.
2. The TA can only update student grades, which means they cannot change grade of a student untill professor gives some grade to them.
3. A student can access his/her TA functionality inside student login only (only if they are a TA)
