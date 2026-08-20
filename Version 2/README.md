# 🎓 Student Grade Management System – V2

A simple **Java-based Student Grade Management System** that allows users to create and load student databases, add, remove, search, view, and update student records, as well as display class statistics through a console-based menu.

This is the **Version 2** of my Student Grade Management System. The project builds upon the first version by adding **input validation, exception handling, student search, class statistics, and file handling/data persistence**.

The project is built using **Java**, `ArrayList`, `Scanner`, `Comparator`, `BufferedReader`, `BufferedWriter`, and Java File Handling concepts.

---

## ✨ Features

* 🗄️ **Create New Database**
  * Allows the user to create a new student database.
  * Database files are stored as `.txt` files.
  * Prevents creating a database with a name that already exists.

* 📂 **Load Existing Database**
  * Displays all available `.txt` databases.
  * Allows the user to select a database from the list.
  * Loads all student records from the selected file into an `ArrayList`.

* ➕ **Add Student**
  * Add a student using their ID, name, and marks.
  * Prevents duplicate student IDs.
  * Validates student name and marks.

* 🗑️ **Remove Student**
  * Remove a student by entering their unique Student ID.
  * Displays the student's details before removing them.
  * Automatically saves the updated database.

* 🔍 **Search Student**
  * Search for a student using their Student ID.
  * Displays the student's ID, name, marks, and grade.

* 👀 **View All Students**
  * Displays all registered students in a formatted table.
  * Shows Student ID, Name, Marks, and Grade.

* ✏️ **Update Marks**
  * Update the marks of an existing student using their Student ID.
  * The student's grade is automatically updated based on the new marks.
  * Automatically saves the updated database.

* 📊 **Class Statistics**
  * Displays the total number of students.
  * Displays the number of passed and failed students.
  * Calculates the average marks.
  * Displays the highest marks.
  * Displays the lowest marks.

* 🔤 **Automatic Sorting**
  * Students are sorted in ascending order according to their Student ID.

* 💾 **File Handling / Data Persistence**
  * Student records are stored inside `.txt` database files.
  * Data is loaded from the file when a database is opened.
  * Changes are automatically written back to the database after adding, removing, or updating students.
  * Student data remains available even after closing the program.

* 🛡️ **Input Validation**
  * Validates Student IDs.
  * Prevents duplicate Student IDs.
  * Validates student names.
  * Validates marks between `0` and `100`.
  * Validates menu choices.

* ⚠️ **Exception Handling**
  * Uses `InputMismatchException` to handle invalid user input.
  * Prevents the program from crashing when incorrect data types are entered.

---

## 🎓 Automatic Grade Assignment

Grades are assigned according to the student's marks:

| Marks    | Grade    |
| -------- | -------- |
| 90–100   | A (PASS) |
| 80–89    | B (PASS) |
| 70–79    | C (PASS) |
| 60–69    | D (PASS) |
| Below 60 | F (FAIL) |

---

## 🛠️ Technologies Used

* **Java**
* **ArrayList**
* **Scanner**
* **Comparator**
* **Lambda Expressions**
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
├── SGMS_V2.java
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
javac SGMS_V2.java
```

### 4. Run the Program

```bash
java SGMS_V2
```

---

## 💻 Program Menu

When the program starts, the following main menu is displayed:

```text
===== Student Grade Management System =====

1.Create New Database
2.Load Existing Database
3.Exit

Enter choice:
```

After loading a database, the operations menu is displayed:

```text
Operation:
1. Add Student
2. Remove Student
3. Search Student
4. View all Students
5. Update marks
6. Show Statistics
7. Return to Main menu

Enter choice:
```

---

## 📌 Example

### Creating a Database

```text
Enter choice: 1
Enter Database Name: ClassA

Database created successfully.
```

A file named:

```text
ClassA.txt
```

will be created.

---

### Loading a Database

```text
Enter choice: 2

Available Databases:

1. ClassA.txt
2. ClassB.txt

Select Database no. : 1

Database Loaded Successfully.
```

---

### Adding a Student

```text
Enter choice: 1
Enter Student ID: 101
Enter Student Name: Rahul
Enter Student Marks (in %): 87

Student Added Successfully!
```

The information is then saved to the database file.

---

### Viewing Students

```text
========Students=======

No.   ID         Name                           Marks      Grade
----------------------------------------------------------------------
1     101        Rahul                          87.00      B ( PASS )
```

---

### Searching for a Student

```text
Enter Student ID: 101

========Student========
ID : 101
Name : Rahul
Marks : 87.0 %
Grade : B ( PASS )
```

---

### Class Statistics

```text
========Class Statistics=======

Total Students : 3
Passed Students : 2
Failed Students : 1
Average marks : 72.67
Highest Marks : 91.0
Lowest Marks : 55.0
```

---

## 💾 Database / File Format

The student records are stored inside `.txt` files using a simple comma-separated format.

For example:

```text
101,Rahul,87.0
102,Aman,91.0
103,Rohit,55.0
```

When the database is loaded, each line is read and converted into a `Student` object, which is then stored inside the `ArrayList<Student>`.

When a student is added, removed, or their marks are updated, the updated `ArrayList` is written back to the database file.

---

## 🔄 Version 2 Upgrades

The following upgrades were added in **Version 2** compared to the previous version:

1. ✅ **Input Validation**
2. ✅ **Search Student**
3. ✅ **Class Statistics**
4. ✅ **Exception Handling**
5. ✅ **File Handling / Data Persistence**

### Version 1

The first version focused on the basic student management functionality:

* Add Student
* Remove Student
* View Students
* Update Marks
* Automatic Grade Assignment
* Automatic Sorting

### Version 2

Version 2 expands the project by adding:

* Database creation
* Existing database loading
* File-based data persistence
* Automatic saving of changes
* Student search
* Class statistics
* Input validation
* Exception handling

---

## 🧠 Concepts Practiced

This project helped me practice several important Java concepts:

* Classes and Objects
* Constructors
* Methods
* Conditional Statements
* Loops
* `ArrayList`
* `Comparator`
* Lambda Expressions
* User Input using `Scanner`
* Searching elements
* Removing elements
* Updating object data
* Sorting collections
* Exception Handling
* `InputMismatchException`
* File Handling
* `File`
* `FileReader`
* `FileWriter`
* `BufferedReader`
* `BufferedWriter`
* Reading and writing files
* Data Persistence
* Passing objects and collections to methods

---

## 🔮 Future Improvements

Some features that could be added in future versions:

* [ ] Add student name update functionality
* [ ] Add Student ID update functionality
* [ ] Add attendance management
* [ ] Add subject-wise marks
* [ ] Add GPA calculation
* [ ] Add multiple subjects for each student
* [ ] Add database deletion option
* [ ] Improve database file format
* [ ] Add confirmation before deleting a student
* [ ] Add graphical user interface (GUI)
* [ ] Connect the application to a database such as MySQL
* [ ] Add login/authentication system
* [ ] Generate student reports

---

## 👨‍💻 Author

**Aaditya Raj Singhaniya**

This project was created as part of my journey to learn and practice **Java programming, Object-Oriented Programming, Collections, Exception Handling, and File Handling**.

This is **Version 2** of my Student Grade Management System, built as an improvement over my first version.

---

## ⭐ Support

If you found this project useful or interesting, consider giving the repository a **star ⭐** on GitHub!

---

**Built with ☕ Java**
