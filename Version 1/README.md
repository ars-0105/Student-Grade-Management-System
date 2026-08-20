# 🎓 Student Grade Management System

A simple **Java-based Student Grade Management System** that allows users to add, remove, view, update, and manage student records through a console-based menu.

This project is built using **Java**, `ArrayList`, `Scanner`, and `Comparator`, making it a good beginner-level project for understanding **Object-Oriented Programming (OOP)** and Java collections.

## ✨ Features

* ➕ **Add Student**

  * Add a student using their ID, name, and marks.
  * Prevents duplicate student IDs.

* 🗑️ **Remove Student**

  * Remove a student by entering their unique Student ID.
  * Displays a confirmation message after successful removal.

* 👀 **View All Students**

  * Displays all registered students in a formatted table.
  * Shows Student ID, Name, Marks, and Grade.

* ✏️ **Update Marks**

  * Update the marks of an existing student using their Student ID.
  * The student's grade is automatically updated based on the new marks.

* 📊 **Automatic Grade Assignment**

  * Grades are assigned according to the student's marks:

  | Marks    | Grade    |
  | -------- | -------- |
  | 90–100   | A (PASS) |
  | 80–89    | B (PASS) |
  | 70–79    | C (PASS) |
  | 60–69    | D (PASS) |
  | Below 60 | F (FAIL) |

* 🔤 **Automatic Sorting**

  * Students are sorted in ascending order by ID.

## 🛠️ Technologies Used

* **Java**
* **ArrayList**
* **Scanner**
* **Comparator**
* **Object-Oriented Programming (OOP)**

## 📁 Project Structure

```text
Student-Grade-Management-System/
│
├── SGMS.java
└── README.md
```

## 🚀 How to Run

### 1. Clone the Repository

```bash
git clone <your-repository-url>
```

### 2. Navigate to the Project Folder

```bash
cd Student-Grade-Management-System
```

### 3. Compile the Program

```bash
javac SGMS.java
```

### 4. Run the Program

```bash
java SGMS
```

## 💻 Program Menu

When the program starts, the following menu is displayed:

```text
===== Student Grade Management System =====
Operation:
1. Add Student
2. Remove Student
3. View all Students
4. Update marks
5. Exit

Enter choice:
```

## 📌 Example

### Adding a Student

```text
Enter choice: 1
Enter Student ID: 101
Enter Student Name: Rahul
Enter Student Marks (in %): 87

Student Added Successfully!
```

### Viewing Students

```text
========Students=======
No.   ID         Name                           Marks      Grade
----------------------------------------------------------------------
1     101        Rahul                          87.00      B ( PASS )
```

## 🧠 Concepts Practiced

This project helped me practice several important Java concepts:

* Classes and Objects
* Constructors
* Encapsulation basics
* Methods
* Conditional Statements
* Loops
* `ArrayList`
* `Comparator`
* Lambda Expressions
* User Input using `Scanner`
* Searching and removing elements
* Updating object data
* Sorting collections

## 👨‍💻 Author

**Aaditya Raj Singhaniya**

This project was created as part of my journey to learn and practice **Java programming and Object-Oriented Programming**.

## ⭐ Support

If you found this project useful or interesting, consider giving the repository a **star ⭐** on GitHub!

---

**Built with ☕ Java**
