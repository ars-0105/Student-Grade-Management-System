# 🎓 Student Grade Management System

A **Java-based Student Grade Management System** developed as a learning project to practice and improve Java programming, Object-Oriented Programming, Collections, File Handling, Exception Handling, and GUI development.

This repository contains **three versions** of the project, with each version introducing new features and improvements over the previous one.

The project started as a simple **console-based student management system** and gradually evolved into a **GUI-based desktop application using Java Swing**.

---

## 📌 Project Overview

The Student Grade Management System allows users to manage student records, including:

* Student ID
* Student Name
* Marks
* Automatically assigned Grade

The project was developed progressively across three versions:

```text
Version 1
   ↓
Basic Console-Based Student Management
   ↓
Version 2
   ↓
File Handling + Database + Validation + Statistics
   ↓
Version 3
   ↓
Java Swing GUI + Improved User Experience
```

---

# 🔢 Project Versions

## 🟢 Version 1 — Basic Console Application

**Version 1** is the initial version of the Student Grade Management System.

It focuses on implementing the basic student management functionality using a console-based menu.

### ✨ Main Features

* ➕ Add Student
* 🗑️ Remove Student
* 👀 View All Students
* ✏️ Update Student Marks
* 📊 Automatic Grade Assignment
* 🔤 Automatic Sorting by Student ID
* 🛡️ Prevention of duplicate Student IDs

### 🛠️ Main Concepts

* Java
* Classes and Objects
* Constructors
* Methods
* `ArrayList`
* `Scanner`
* `Comparator`
* Lambda Expressions
* Basic OOP

📖 **For complete features, examples, project structure, and instructions, see the README inside the Version 1 folder.**

---

## 🟡 Version 2 — File Handling & Data Persistence

**Version 2** builds upon Version 1 by introducing file handling and a database-like system using `.txt` files.

Student records can now be saved and loaded, allowing data to remain available even after the program is closed.

### ✨ Main Features

* 🗄️ Create New Database
* 📂 Load Existing Database
* ➕ Add Student
* 🗑️ Remove Student
* 🔍 Search Student
* 👀 View All Students
* ✏️ Update Marks
* 📊 Class Statistics
* 🔤 Automatic Sorting
* 💾 File Handling & Data Persistence
* 🛡️ Input Validation
* ⚠️ Exception Handling
* 🔄 Automatic Saving of Changes

### 🛠️ Main Concepts

* `ArrayList`
* `File`
* `FileReader`
* `FileWriter`
* `BufferedReader`
* `BufferedWriter`
* `InputMismatchException`
* Exception Handling
* File-based Data Persistence
* Collections
* OOP

📖 **For complete features, database format, examples, and instructions, see the README inside the Version 2 folder.**

---

## 🔵 Version 3 — Java Swing GUI Application

**Version 3** converts the previous console-based system into a **graphical desktop application using Java Swing**.

It keeps the file handling and data persistence introduced in Version 2 while providing a more user-friendly graphical interface.

### ✨ Main Features

* 🖥️ Java Swing GUI
* 🗄️ Create New Database
* 📂 Load Existing Database
* ➕ Add Student
* 🗑️ Remove Student with Confirmation
* ✏️ Update Marks
* 📋 Student Records displayed using `JTable`
* 📊 Class Statistics
* 🔤 Automatic Sorting
* 🔄 Refresh Student Table
* 💾 File Handling & Data Persistence
* 🛡️ Input Validation
* ⚠️ Exception Handling
* 💬 GUI error messages and dialogs

### 🖥️ Main Swing Components

* `JFrame`
* `JPanel`
* `JButton`
* `JLabel`
* `JTextField`
* `JTable`
* `JScrollPane`
* `JOptionPane`
* `DefaultTableModel`

### 🛠️ Main Concepts

* Java Swing
* GUI Event Handling
* `ActionListener`
* Collections
* File Handling
* Exception Handling
* Data Persistence
* Object-Oriented Programming

📖 **For complete features, GUI details, examples, and instructions, see the README inside the Version 3 folder.**

---

# 📊 Version Comparison

| Feature                    | Version 1 | Version 2 | Version 3 |
| -------------------------- | :-------: | :-------: | :-------: |
| Add Student                |     ✅     |     ✅     |     ✅     |
| Remove Student             |     ✅     |     ✅     |     ✅     |
| Update Marks               |     ✅     |     ✅     |     ✅     |
| View Students              |     ✅     |     ✅     |     ✅     |
| Search Student             |     ❌     |     ✅     |     —     |
| Automatic Grade Assignment |     ✅     |     ✅     |     ✅     |
| Automatic Sorting          |     ✅     |     ✅     |     ✅     |
| Class Statistics           |     ❌     |     ✅     |     ✅     |
| Input Validation           |   Basic   |     ✅     |     ✅     |
| Exception Handling         |     ❌     |     ✅     |     ✅     |
| File Handling              |     ❌     |     ✅     |     ✅     |
| Data Persistence           |     ❌     |     ✅     |     ✅     |
| Database Creation          |     ❌     |     ✅     |     ✅     |
| Java Swing GUI             |     ❌     |     ❌     |     ✅     |
| `JTable`                   |     ❌     |     ❌     |     ✅     |
| GUI Dialogs                |     ❌     |     ❌     |     ✅     |
| Refresh Functionality      |     ❌     |     ❌     |     ✅     |

> **Note:** Some features from Version 2, such as separate Search and View options, were redesigned in Version 3 because student records are displayed directly in the GUI table.

---

# 🎓 Automatic Grade Assignment

All versions use the same basic grade assignment system:

| Marks    | Grade    |
| -------- | -------- |
| 90–100   | A (PASS) |
| 80–89    | B (PASS) |
| 70–79    | C (PASS) |
| 60–69    | D (PASS) |
| Below 60 | F (FAIL) |

---

# 💾 Database Format

Versions 2 and 3 use `.txt` files to store student records.

The basic format is:

```text
StudentID,StudentName,Marks
```

Example:

```text
101,Rahul,87.0
102,Aman,91.0
103,Rohit,55.0
```

When a database is loaded, the records are converted into `Student` objects and stored in an `ArrayList<Student>`.

Changes made to the student records are then saved back to the database file.

---

# 🛠️ Technologies Used

The project progressively uses:

* **Java**
* **Object-Oriented Programming**
* **ArrayList**
* **Scanner**
* **Comparator**
* **Lambda Expressions**
* **Exception Handling**
* **File Handling**
* **BufferedReader**
* **BufferedWriter**
* **Java Swing**
* **JTable**
* **JOptionPane**
* **DefaultTableModel**

---

# 📁 Repository Structure

The repository contains each version separately:

```text
Student-Grade-Management-System/
│
├── Version-1/
│   ├── SGMS.java
│   └── README.md
│
├── Version-2/
│   ├── SGMS_V2.java
│   └── README.md
│
├── Version-3/
│   ├── SGMS_V3.java
│   └── README.md
│
└── README.md
```

> **Note:** The exact folder and file names may vary depending on the repository structure.

---

# 🚀 How to Run

Each version can be compiled and run separately.

### Version 1

```bash
javac SGMS.java
java SGMS
```

### Version 2

```bash
javac SGMS_V2.java
java SGMS_V2
```

### Version 3

```bash
javac SGMS_V3.java
java SGMS_V3
```

Make sure the **Java JDK** is installed and `java` and `javac` are available in your system PATH.

---

# 📈 Project Evolution

This project was developed step-by-step to understand how a Java application can grow from a basic program into a more complete application.

### Version 1

Focused on learning the fundamentals:

**Java → OOP → Collections → Basic Student Management**

### Version 2

Introduced more practical application concepts:

**File Handling → Data Persistence → Validation → Exception Handling → Statistics**

### Version 3

Focused on application usability and GUI development:

**Java Swing → GUI → Event Handling → Tables → Dialogs → Improved User Experience**

---

# 🧠 Learning Journey

Through the three versions, this project provided practice with:

* Classes and Objects
* Constructors
* Methods
* Encapsulation
* Conditional Statements
* Loops
* Collections
* `ArrayList`
* Sorting
* Searching
* Updating and Removing Objects
* Lambda Expressions
* Exception Handling
* File Handling
* Reading and Writing Files
* Data Persistence
* Java Swing
* GUI Event Handling
* `ActionListener`
* Tables and Dialogs
* Object-Oriented Programming

---

# 📖 Detailed Documentation

Each version has its **own README file** containing detailed information about that particular version, including its features, examples, project structure, implementation details, and how to run it.

If you want to understand a specific version in detail, **open the README file inside that version's folder.**

---

# 🔮 Future Improvements

Possible future improvements for the project include:

* [ ] Student name update
* [ ] Student ID update
* [ ] Attendance management
* [ ] Subject-wise marks
* [ ] GPA calculation
* [ ] Multiple subjects for each student
* [ ] Database deletion
* [ ] Improved database format
* [ ] GUI improvements
* [ ] MySQL database integration
* [ ] Login/authentication system
* [ ] Student report generation

---

# 👨‍💻 Author

**Aaditya Raj Singhaniya**

This project was created as part of my journey to learn and practice:

**Java Programming • Object-Oriented Programming • Collections • Exception Handling • File Handling • Data Persistence • Java Swing**

---

## ⭐ Support

If you found this project useful or interesting, consider giving the repository a **star ⭐** on GitHub!

---

**Built with ☕ Java**
