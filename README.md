# 🎓 Student Grade Management System

A **Java-based Student Grade Management System** developed as a learning project to practice and improve Java programming, Object-Oriented Programming, Collections, File Handling, Exception Handling, Data Persistence, and GUI development.

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
Java Swing GUI + Database Management + Improved User Experience
```

---

# 🔢 Project Versions

## 🟢 Version 1 — Basic Console Application

**Version 1** is the initial version of the Student Grade Management System.

It focuses on implementing basic student management functionality using a console-based menu.

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
* 🗑️ Delete Existing Database
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

It keeps the file handling, database management, validation, sorting, and data persistence introduced in Version 2 while providing a more user-friendly graphical interface.

### ✨ Main Features

* 🖥️ Java Swing GUI
* 🗄️ Create New Database
* 📂 Load Existing Database
* 🗑️ Delete Existing Database
* ➕ Add Student
* 🗑️ Remove Student with Confirmation
* ✏️ Update Marks
* 📋 Student Records displayed using `JTable`
* 📊 Class Statistics
* 🔤 Automatic Sorting by Student ID
* 🔄 Refresh Student Table
* 💾 File Handling & Data Persistence
* 🛡️ Input Validation
* ⚠️ Exception Handling
* 💬 GUI error messages, dialogs, and confirmations

### 🗑️ Delete Existing Database

Version 3 includes a dedicated **Delete Existing Database** feature in the main menu.

The user can:

1. Open **Delete Existing Database**
2. Select an existing `.txt` database from a GUI list
3. Confirm the deletion
4. Permanently delete the selected database

A confirmation dialog is displayed before deletion because the action **cannot be undone**.

If the deleted database is currently loaded, Version 3 also clears the active database reference and student data.

### ➕ Add Student

The GUI validates:

* Student ID must be a valid positive number.
* Duplicate Student IDs are not allowed.
* Student names can contain alphabets and spaces only.
* Marks must be between `0` and `100`.
* Invalid numeric input is handled using `NumberFormatException`.
* The Add Student dialog remains open after invalid input, allowing the user to correct the entered information.
* Successfully added students are automatically sorted and saved.

### 🗑️ Remove Student

* Removes a student using Student ID.
* Displays the student's details before removal.
* Asks for confirmation before deletion.
* Automatically saves the updated database.
* Refreshes the table after successful removal.

### ✏️ Update Marks

* Updates marks using Student ID.
* Validates marks between `0` and `100`.
* Automatically changes the student's grade based on the new marks.
* Automatically saves the updated database.
* Refreshes the table after the update.

### 📋 Student Table

Loaded students are displayed directly inside a `JTable`.

The table contains:

* No.
* ID
* Name
* Marks
* Grade

Students are automatically sorted in ascending order by Student ID.

### 📊 Class Statistics

Version 3 displays:

* Total Students
* Passed Students
* Failed Students
* Average Marks
* Highest Marks
* Lowest Marks

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
* Sorting with `Comparator`
* Object-Oriented Programming

📖 **For complete features, GUI details, examples, project structure, and instructions, see the README inside the Version 3 folder.**

---

# 📊 Version Comparison

| Feature | Version 1 | Version 2 | Version 3 |
| --- | :---: | :---: | :---: |
| Add Student | ✅ | ✅ | ✅ |
| Remove Student | ✅ | ✅ | ✅ |
| Update Marks | ✅ | ✅ | ✅ |
| View Students | ✅ | ✅ | ✅ |
| Search Student | ❌ | ✅ | ⚪ |
| Automatic Grade Assignment | ✅ | ✅ | ✅ |
| Automatic Sorting | ✅ | ✅ | ✅ |
| Class Statistics | ❌ | ✅ | ✅ |
| Input Validation | Basic | ✅ | ✅ |
| Exception Handling | ❌ | ✅ | ✅ |
| File Handling | ❌ | ✅ | ✅ |
| Data Persistence | ❌ | ✅ | ✅ |
| Database Creation | ❌ | ✅ | ✅ |
| Load Existing Database | ❌ | ✅ | ✅ |
| Delete Existing Database | ❌ | ✅ | ✅ |
| Java Swing GUI | ❌ | ❌ | ✅ |
| `JTable` | ❌ | ❌ | ✅ |
| GUI Dialogs | ❌ | ❌ | ✅ |
| Refresh Functionality | ❌ | ❌ | ✅ |
| Delete Confirmation | ❌ | Console | GUI |

> **Note:** Version 3 does not provide a separate Search Student button because all loaded students are already displayed in the `JTable`. A search method exists in the V3 source code, but it is not connected to the operations interface.

---

# 🎓 Automatic Grade Assignment

All versions use the same grade assignment system:

| Marks | Grade |
| --- | --- |
| 90–100 | A (PASS) |
| 80–89 | B (PASS) |
| 70–79 | C (PASS) |
| 60–69 | D (PASS) |
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

When a database is loaded, the records are converted into `Student` objects and stored in an:

```java
ArrayList<Student>
```

Whenever a student is added, removed, or updated, the modified records are written back to the active database file.

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
* **NumberFormatException**
* **File Handling**
* **File**
* **FileReader**
* **FileWriter**
* **BufferedReader**
* **BufferedWriter**
* **Java Swing**
* **JFrame**
* **JPanel**
* **JButton**
* **JLabel**
* **JTextField**
* **JTable**
* **JScrollPane**
* **JOptionPane**
* **DefaultTableModel**
* **ActionListener**
* **GUI Event Handling**

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

Database `.txt` files are created in the working directory when using Version 2 or Version 3.

> **Note:** The exact folder and file names may vary depending on the repository structure.

---

# 🚀 How to Run

Each version can be compiled and run separately.

## Requirements

Make sure the **Java JDK** is installed on your system.

You can verify Java installation using:

```bash
java -version
```

and:

```bash
javac -version
```

Both commands should work from your terminal or command prompt.

---

## Version 1

Navigate to the Version 1 folder and compile:

```bash
javac SGMS.java
```

Run:

```bash
java SGMS
```

---

## Version 2

Navigate to the Version 2 folder and compile:

```bash
javac SGMS_V2.java
```

Run:

```bash
java SGMS_V2
```

Version 2 runs as a console application.

---

## Version 3

Navigate to the Version 3 folder and compile:

```bash
javac SGMS_V3.java
```

Run:

```bash
java SGMS_V3
```

The **Student Grade Management System GUI** will open.

Version 3 uses Java Swing, which is included with the standard Java SE JDK.

---

# 📈 Project Evolution

This project was developed step-by-step to understand how a Java application can grow from a basic program into a more complete application.

### Version 1

Focused on learning the fundamentals:

**Java → OOP → Collections → Basic Student Management**

### Version 2

Introduced practical application concepts:

**File Handling → Data Persistence → Database Management → Validation → Exception Handling → Statistics**

### Version 3

Focused on application usability and GUI development:

**Java Swing → GUI → Event Handling → Tables → Dialogs → Database Management → Improved User Experience**

---

# 🧠 Learning Journey

Through the three versions, this project provided practice with:

* Classes and Objects
* Constructors
* Methods
* Object-Oriented Programming
* Conditional Statements
* Loops
* Collections
* `ArrayList`
* Sorting
* Searching
* Updating and Removing Objects
* Lambda Expressions
* Exception Handling
* `InputMismatchException`
* `NumberFormatException`
* File Handling
* `File`
* `FileReader`
* `FileWriter`
* `BufferedReader`
* `BufferedWriter`
* Reading and Writing Files
* Data Persistence
* Database Management using `.txt` files
* Java Swing
* GUI Event Handling
* `ActionListener`
* Tables and Dialogs
* `JFrame`
* `JPanel`
* `JButton`
* `JLabel`
* `JTextField`
* `JTable`
* `JScrollPane`
* `JOptionPane`
* `DefaultTableModel`

---

# 📖 Detailed Documentation

Each version has its **own README file** containing detailed information about that particular version, including its features, examples, project structure, implementation details, database format, and how to run it.

If you want to understand a specific version in detail, **open the README file inside that version's folder.**

---

# 👨‍💻 Author

**Aaditya Raj Singhaniya**

This project was created as part of my journey to learn and practice:

**Java Programming • Object-Oriented Programming • Collections • Exception Handling • File Handling • Data Persistence • Java Swing**

The project represents the progression from a simple console-based Java program to a graphical desktop application with database management and persistent student records.

---

## ⭐ Support

If you found this project useful or interesting, consider giving the repository a **star ⭐** on GitHub!

---

**Built with ☕ Java**
