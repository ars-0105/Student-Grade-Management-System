# 🎓 Student Grade Management System – V3

A simple **Java-based Student Grade Management System** with a **Graphical User Interface (GUI)** that allows users to create and load student databases, add, remove, and update student records, as well as display class statistics through an easy-to-use graphical interface.

This is **Version 3** of my Student Grade Management System. It builds upon Version 2 by converting the previous **console-based system into a GUI-based desktop application using Java Swing**, while keeping file handling, data persistence, input validation, automatic sorting, and grade assignment.

---

## ✨ Features

* 🖥️ **Java Swing GUI**
  * Converted the previous console-based system into a graphical desktop application.
  * Uses buttons, dialogs, tables, and message boxes for interaction.

* 🗄️ **Create New Database**
  * Creates a new student database as a `.txt` file.
  * Prevents duplicate database names.
  * Uses a GUI dialog for database creation.

* 📂 **Load Existing Database**
  * Displays all available `.txt` databases.
  * Allows the user to select a database through a GUI dialog.
  * Loads student records into an `ArrayList<Student>`.
  * Displays loaded students directly in a `JTable`.

* ➕ **Add Student**
  * Adds a student using ID, name, and marks.
  * Prevents duplicate Student IDs.
  * Validates ID, name, and marks.
  * Marks must be between `0` and `100`.
  * Student names can contain alphabets and spaces only.
  * The dialog remains open after invalid input so previously entered information is not lost.
  * Automatically saves the student after successful addition.

* 🗑️ **Remove Student**
  * Removes a student using their Student ID.
  * Displays student details before deletion.
  * Asks for confirmation before removing the student.
  * Automatically saves the updated database.

* ✏️ **Update Marks**
  * Updates marks using the Student ID.
  * Validates marks between `0` and `100`.
  * Automatically updates the student's grade.
  * Automatically saves the changes.

* 📋 **Student Table**
  * Displays all loaded students directly in a `JTable`.
  * Shows No., ID, Name, Marks, and Grade.
  * Automatically refreshes after changes.

* 📊 **Class Statistics**
  * Displays total students.
  * Displays passed and failed students.
  * Calculates average marks.
  * Displays highest and lowest marks.

* 🔤 **Automatic Sorting**
  * Students are sorted in ascending order by Student ID.

* 🔄 **Refresh**
  * Refreshes the student table to show the latest data.

* 💾 **File Handling / Data Persistence**
  * Student records are stored in `.txt` files.
  * Data is loaded when a database is opened.
  * Changes are automatically saved after adding, removing, or updating students.

* 🛡️ **Input Validation & Exception Handling**
  * Handles invalid IDs, duplicate IDs, invalid names, and invalid marks.
  * Uses `NumberFormatException` to prevent crashes from invalid numeric input.
  * Displays errors through `JOptionPane`.

---

## 🎓 Automatic Grade Assignment

| Marks | Grade |
|---|---|
| 90–100 | A (PASS) |
| 80–89 | B (PASS) |
| 70–79 | C (PASS) |
| 60–69 | D (PASS) |
| Below 60 | F (FAIL) |

---

## 🖥️ GUI Components Used

* `JFrame` – Main application window
* `JPanel` – Organizes GUI components
* `JButton` – Performs operations
* `JLabel` – Displays information
* `JTextField` – Accepts user input
* `JTable` – Displays student records
* `JScrollPane` – Provides table scrolling
* `JOptionPane` – Dialogs, errors, confirmations, and messages
* `DefaultTableModel` – Manages table data

---

## 🛠️ Technologies Used

* **Java**
* **Java Swing**
* **ArrayList**
* **Comparator**
* **Lambda Expressions**
* **JFrame**
* **JPanel**
* **JButton**
* **JTable**
* **JOptionPane**
* **DefaultTableModel**
* **BufferedReader**
* **BufferedWriter**
* **File Handling**
* **Exception Handling**
* **Object-Oriented Programming (OOP)**

---

## 📁 Project Structure

```text
Student-Grade-Management-System/
│
├── SGMS_V3.java
├── Database files (.txt)
└── README.md
```

---

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
javac SGMS_V3.java
```

### 4. Run the Program

```bash
java SGMS_V3
```

The **Student Grade Management System GUI** will open.

> Make sure Java JDK is installed and `javac` and `java` are available in your system PATH.

---

## 💻 Program Interface

### Main Menu

When the program starts, the main menu provides:

```text
Student Grade Management System

[ Create New Database ]

[ Load Existing Database ]

[ Exit ]
```

### Operations Screen

After loading a database:

```text
Student Grade Management System
Database: ClassA.txt

No.   ID       Name             Marks       Grade
--------------------------------------------------------
1     101      Rahul            87.00       B ( PASS )
2     102      Aman             91.00       A ( PASS )
3     103      Rohit            55.00       F ( FAIL )

[ Add Student ] [ Remove Student ] [ Update Marks ]
[ Statistics ]  [ Refresh ]        [ Main Menu ]
```

Since all students are already visible in the table, separate **View All Students** and **Search Student** options were removed in Version 3.

---

## 📌 Examples

### Creating a Database

Click **Create New Database** and enter a database name:

```text
Enter Database Name:

[ ClassA ]

[ OK ] [ Cancel ]
```

After successful creation:

```text
Database created successfully!
```

A file named `ClassA.txt` will be created.

---

### Loading a Database

Click **Load Existing Database**.

Available `.txt` databases are displayed:

```text
Select Database:

ClassA.txt
ClassB.txt
ClassC.txt
```

After selecting a database, its student records are loaded and displayed automatically in the table.

---

### Adding a Student

Click **Add Student**:

```text
Student ID:   [ 101 ]
Student Name: [ Rahul ]
Marks (%):    [ 87 ]

[ OK ] [ Cancel ]
```

After successful validation:

```text
Student added successfully!
```

The new student appears in the table and is saved to the database.

---

### Invalid Input Handling

If invalid marks are entered:

```text
Marks (%): abc
```

the program displays:

```text
Invalid marks!
Please enter a valid number.
```

The **Add Student dialog remains open**, and the previously entered ID and name remain in their fields. This allows the user to correct the invalid value without entering all information again.

---

### Removing a Student

Click **Remove Student** and enter an ID:

```text
Enter Student ID:

[ 101 ]
```

If found, the program displays the student's details and asks for confirmation:

```text
Remove student:

ID: 101
Name: Rahul
Marks: 87.0

[ Yes ] [ No ]
```

After confirmation, the student is removed and the database is updated.

---

### Updating Marks

Click **Update Marks** and enter the Student ID.

For example:

```text
Student: Rahul
Current Marks: 87.0

Enter New Marks:

[ 92 ]
```

The marks and grade are updated automatically:

```text
87 → B ( PASS )

92 → A ( PASS )
```

The updated data is saved to the database.

---

### Class Statistics

Click **Statistics** to display:

```text
CLASS STATISTICS

Total Students : 3
Passed Students : 2
Failed Students : 1
Average Marks : 77.67
Highest Marks : 91.00
Lowest Marks : 55.00
```

---

## 💾 Database / File Format

Student records are stored inside `.txt` files using a comma-separated format:

```text
101,Rahul,87.0
102,Aman,91.0
103,Rohit,55.0
```

The format is:

```text
StudentID,StudentName,Marks
```

When the database is loaded, each line is converted into a `Student` object and stored in:

```java
ArrayList<Student>
```

Whenever a student is added, removed, or updated, the modified data is written back to the database file.

---

## 🔄 Version 3 Upgrades

Version 3 introduces the following improvements over Version 2:

1. ✅ Graphical User Interface using Java Swing
2. ✅ Student records displayed directly in a `JTable`
3. ✅ GUI-based database creation
4. ✅ GUI-based database loading
5. ✅ GUI-based Add Student operation
6. ✅ GUI-based Remove Student operation
7. ✅ GUI-based Update Marks operation
8. ✅ GUI-based Class Statistics
9. ✅ GUI-based validation and error messages
10. ✅ Add Student dialog remains open after invalid input
11. ✅ Removed separate View All Students option
12. ✅ Removed separate Search Student option
13. ✅ Added Refresh functionality
14. ✅ Improved user experience

### Version 1

The first version focused on basic student management:

* Add Student
* Remove Student
* View Students
* Update Marks
* Automatic Grade Assignment
* Automatic Sorting

### Version 2

Version 2 added:

* Database creation
* Existing database loading
* File-based data persistence
* Automatic saving
* Student search
* Class statistics
* Input validation
* Exception handling

### Version 3

Version 3 converts the project into a **GUI-based desktop application using Java Swing** and improves the user experience with:

* Interactive graphical interface
* `JTable` student display
* GUI database management
* GUI student operations
* GUI statistics
* Improved input handling
* Automatic table updates
* Persistent `.txt` databases

---

## 🧠 Concepts Practiced

* Classes and Objects
* Constructors
* Methods
* Conditional Statements
* Loops
* `ArrayList`
* `Comparator`
* Lambda Expressions
* Sorting Collections
* Updating and Removing Objects
* Exception Handling
* `NumberFormatException`
* File Handling
* `File`
* `FileReader`
* `FileWriter`
* `BufferedReader`
* `BufferedWriter`
* Reading and Writing Files
* Data Persistence
* Java Swing
* GUI Event Handling
* `ActionListener`
* `JFrame`
* `JPanel`
* `JButton`
* `JLabel`
* `JTextField`
* `JTable`
* `JScrollPane`
* `JOptionPane`
* `DefaultTableModel`
* Object-Oriented Programming

---

## 👨‍💻 Author

**Aaditya Raj Singhaniya**

This project was created as part of my journey to learn and practice **Java programming, Object-Oriented Programming, Collections, Exception Handling, File Handling, and GUI development using Java Swing**.

This is **Version 3** of my Student Grade Management System, built as a GUI-based improvement over my previous versions.

---

## ⭐ Support

If you found this project useful or interesting, consider giving the repository a **star ⭐** on GitHub!

---

**Built with ☕ Java & Swing**
