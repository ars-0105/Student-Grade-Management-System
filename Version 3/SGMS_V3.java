import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

class Student {

    int ID;
    String name;
    double marks;

    Student(int r, String n, double m) {
        ID = r;
        name = n;
        marks = m;
    }

    String getGrade() {

        if (marks >= 90) {
            return "A ( PASS )";
        } else if (marks >= 80) {
            return "B ( PASS )";
        } else if (marks >= 70) {
            return "C ( PASS )";
        } else if (marks >= 60) {
            return "D ( PASS )";
        } else {
            return "F ( FAIL )";
        }
    }
}


public class SGMS_V3 extends JFrame {

    // =========================
    // DATA
    // =========================

    ArrayList<Student> student = new ArrayList<>();
    File database = null;

    // =========================
    // GUI COMPONENTS
    // =========================

    JTextField idField;
    JTextField nameField;
    JTextField marksField;

    JTable table;
    DefaultTableModel tableModel;

    JLabel databaseLabel;

    // =========================
    // COLORS / FONTS
    // =========================

    Font titleFont = new Font("Arial", Font.BOLD, 26);
    Font normalFont = new Font("Arial", Font.PLAIN, 15);
    Font buttonFont = new Font("Arial", Font.BOLD, 14);


    // =========================
    // CONSTRUCTOR
    // =========================

    public SGMS_V3() {

        setTitle("Student Grade Management System");
        setSize(950, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        showMainMenu();
    }


    // =========================================================
    // MAIN MENU
    // =========================================================

    void showMainMenu() {

        getContentPane().removeAll();

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(20, 20));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60));

        // TITLE

        JLabel title = new JLabel(
                "Student Grade Management System",
                SwingConstants.CENTER
        );

        title.setFont(titleFont);

        mainPanel.add(title, BorderLayout.NORTH);


        // BUTTON PANEL

        JPanel buttonPanel = new JPanel();

        buttonPanel.setLayout(new GridLayout(3, 1, 15, 15));

        JButton createButton = new JButton("Create New Database");
        JButton loadButton = new JButton("Load Existing Database");
        JButton exitButton = new JButton("Exit");

        createButton.setFont(buttonFont);
        loadButton.setFont(buttonFont);
        exitButton.setFont(buttonFont);

        buttonPanel.add(createButton);
        buttonPanel.add(loadButton);
        buttonPanel.add(exitButton);

        mainPanel.add(buttonPanel, BorderLayout.CENTER);


        // BUTTON ACTIONS

        createButton.addActionListener(e -> createDatabase());

        loadButton.addActionListener(e -> loadDatabase());

        exitButton.addActionListener(e -> System.exit(0));


        add(mainPanel);

        revalidate();
        repaint();
    }


    // =========================================================
    // CREATE DATABASE
    // =========================================================

    void createDatabase() {

        String dbName;

        while (true) {

            dbName = JOptionPane.showInputDialog(
                    this,
                    "Enter Database Name:"
            );

            if (dbName == null) {
                return;
            }

            dbName = dbName.trim();

            if (dbName.isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Database name cannot be empty!"
                );
                continue;
            }

            File f = new File(dbName + ".txt");

            if (f.exists()) {

                JOptionPane.showMessageDialog(
                        this,
                        "File already exists!\nPlease use another name.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );

            } else {

                try {

                    f.createNewFile();

                    JOptionPane.showMessageDialog(
                            this,
                            "Database created successfully!"
                    );

                    return;

                } catch (IOException e) {

                    JOptionPane.showMessageDialog(
                            this,
                            "Error creating database:\n" + e.getMessage(),
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );

                    return;
                }
            }
        }
    }


    // =========================================================
    // LOAD DATABASE
    // =========================================================

    void loadDatabase() {

        File directory = new File(".");
        File[] files = directory.listFiles();

        ArrayList<File> databases = new ArrayList<>();

        if (files != null) {

            for (File f : files) {

                if (f.isFile() && f.getName().endsWith(".txt")) {
                    databases.add(f);
                }
            }
        }


        if (databases.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "No databases found!"
            );

            return;
        }


        String[] databaseNames = new String[databases.size()];

        for (int i = 0; i < databases.size(); i++) {
            databaseNames[i] = databases.get(i).getName();
        }


        String selected = (String) JOptionPane.showInputDialog(
                this,
                "Select Database:",
                "Load Database",
                JOptionPane.PLAIN_MESSAGE,
                null,
                databaseNames,
                databaseNames[0]
        );


        if (selected == null) {
            return;
        }


        for (File f : databases) {

            if (f.getName().equals(selected)) {

                database = f;
                break;
            }
        }


        student.clear();


        try {

            BufferedReader b =
                    new BufferedReader(new FileReader(database));

            String line;

            while ((line = b.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                double marks = Double.parseDouble(data[2]);

                Student s = new Student(id, name, marks);

                student.add(s);
            }

            b.close();

            sort(student);

            JOptionPane.showMessageDialog(
                    this,
                    "Database loaded successfully!"
            );

            showOperations();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error loading database:\n" + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }


    // =========================================================
    // SAVE DATABASE
    // =========================================================

    void saveDatabase() {

        if (database == null) {
            return;
        }

        try {

            BufferedWriter b =
                    new BufferedWriter(new FileWriter(database));

            for (Student s : student) {

                b.write(
                        s.ID + "," +
                        s.name + "," +
                        s.marks
                );

                b.newLine();
            }

            b.close();

        } catch (IOException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error saving database:\n" + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }


    // =========================================================
    // OPERATIONS SCREEN
    // =========================================================

    void showOperations() {

    getContentPane().removeAll();

    JPanel mainPanel = new JPanel(new BorderLayout(10, 10));

    mainPanel.setBorder(
            BorderFactory.createEmptyBorder(
                    15, 15, 15, 15
            )
    );


    // =========================
    // TOP
    // =========================

    JPanel topPanel = new JPanel(new BorderLayout());

    JLabel title = new JLabel(
            "Student Grade Management System"
    );

    title.setFont(titleFont);

    databaseLabel = new JLabel(
            "Database: " + database.getName()
    );

    databaseLabel.setFont(normalFont);

    topPanel.add(title, BorderLayout.NORTH);
    topPanel.add(databaseLabel, BorderLayout.SOUTH);

    mainPanel.add(topPanel, BorderLayout.NORTH);


    // =========================
    // TABLE
    // =========================

    String[] columns = {
            "No.",
            "ID",
            "Name",
            "Marks",
            "Grade"
    };

    tableModel = new DefaultTableModel(columns, 0) {

        @Override
        public boolean isCellEditable(
                int row,
                int column
        ) {
            return false;
        }
    };

    table = new JTable(tableModel);

    table.setRowHeight(25);
    table.setFont(normalFont);
    table.getTableHeader().setFont(buttonFont);

    JScrollPane scrollPane =
            new JScrollPane(table);

    mainPanel.add(
            scrollPane,
            BorderLayout.CENTER
    );


    // =========================
    // BUTTON PANEL
    // =========================

    JPanel buttonPanel =
            new JPanel(
                    new GridLayout(2, 3, 10, 10)
            );


    JButton addButton =
            new JButton("Add Student");

    JButton removeButton =
            new JButton("Remove Student");

    JButton updateButton =
            new JButton("Update Marks");

    JButton statisticsButton =
            new JButton("Statistics");

    JButton refreshButton =
            new JButton("Refresh");

    JButton returnButton =
            new JButton("Main Menu");


    JButton[] buttons = {
            addButton,
            removeButton,
            updateButton,
            statisticsButton,
            refreshButton,
            returnButton
    };


    for (JButton b : buttons) {
        b.setFont(buttonFont);
        buttonPanel.add(b);
    }


    mainPanel.add(
            buttonPanel,
            BorderLayout.SOUTH
    );


    // =========================
    // ACTIONS
    // =========================

    addButton.addActionListener(
            e -> addStudentGUI()
    );

    removeButton.addActionListener(
            e -> removeStudentGUI()
    );

    updateButton.addActionListener(
            e -> updateStudentGUI()
    );

    statisticsButton.addActionListener(
            e -> showStatisticsGUI()
    );

    refreshButton.addActionListener(
            e -> refreshTable()
    );

    returnButton.addActionListener(
            e -> {

                int choice =
                        JOptionPane.showConfirmDialog(
                                this,
                                "Return to main menu?",
                                "Confirm",
                                JOptionPane.YES_NO_OPTION
                        );

                if (choice ==
                        JOptionPane.YES_OPTION) {

                    showMainMenu();
                }
            }
    );


    add(mainPanel);

    refreshTable();

    revalidate();
    repaint();
}


    // =========================================================
    // ADD STUDENT
    // =========================================================
void addStudentGUI() {

    JPanel panel = new JPanel(
            new GridLayout(3, 2, 10, 10)
    );

    JTextField id =
            new JTextField();

    JTextField name =
            new JTextField();

    JTextField marks =
            new JTextField();

    panel.add(new JLabel("Student ID:"));
    panel.add(id);

    panel.add(new JLabel("Student Name:"));
    panel.add(name);

    panel.add(new JLabel("Marks (%):"));
    panel.add(marks);


    while (true) {

        int result = JOptionPane.showConfirmDialog(
                this,
                panel,
                "Add Student",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );


        // User pressed Cancel
        if (result != JOptionPane.OK_OPTION) {
            return;
        }


        // =========================================
        // VALIDATE ID
        // =========================================

        int studentID;

        try {

            studentID =
                    Integer.parseInt(
                            id.getText().trim()
                    );

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid ID!\nPlease enter a valid number.",
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE
            );

            continue;
        }


        if (studentID <= 0) {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid ID!\nID must be greater than 0.",
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE
            );

            continue;
        }


        // =========================================
        // CHECK DUPLICATE ID
        // =========================================

        boolean duplicate = false;

        for (Student s : student) {

            if (s.ID == studentID) {

                duplicate = true;
                break;
            }
        }


        if (duplicate) {

            JOptionPane.showMessageDialog(
                    this,
                    "Student ID already exists!\nPlease enter another ID.",
                    "Duplicate ID",
                    JOptionPane.ERROR_MESSAGE
            );

            continue;
        }


        // =========================================
        // VALIDATE NAME
        // =========================================

        String studentName =
                name.getText().trim();


        if (
                studentName.isEmpty() ||
                !studentName.matches("[a-zA-Z ]+")
        ) {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid name!\nUse alphabets only.",
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE
            );

            continue;
        }


        // =========================================
        // VALIDATE MARKS
        // =========================================

        double studentMarks;

        try {

            studentMarks =
                    Double.parseDouble(
                            marks.getText().trim()
                    );

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid marks!\nPlease enter a valid number.",
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE
            );

            continue;
        }


        if (
                studentMarks < 0 ||
                studentMarks > 100
        ) {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid marks!\nMarks must be between 0 and 100.",
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE
            );

            continue;
        }


        // =========================================
        // ADD STUDENT
        // =========================================

        Student s =
                new Student(
                        studentID,
                        studentName,
                        studentMarks
                );


        student.add(s);

        sort(student);

        saveDatabase();

        refreshTable();


        JOptionPane.showMessageDialog(
                this,
                "Student added successfully!",
                "Success",
                JOptionPane.INFORMATION_MESSAGE
        );


        // Close dialog after successful addition
        return;
    }
}

    // =========================================================
    // REMOVE STUDENT
    // =========================================================

    void removeStudentGUI() {

        String input =
                JOptionPane.showInputDialog(
                        this,
                        "Enter Student ID:"
                );


        if (input == null) {
            return;
        }


        try {

            int id =
                    Integer.parseInt(
                            input.trim()
                    );


            if (id <= 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "ID must be greater than 0!"
                );

                return;
            }


            for (int i = 0;
                 i < student.size();
                 i++) {

                Student s =
                        student.get(i);


                if (s.ID == id) {

                    int choice =
                            JOptionPane.showConfirmDialog(
                                    this,
                                    "Remove student:\n\n" +
                                    "ID: " + s.ID +
                                    "\nName: " + s.name +
                                    "\nMarks: " + s.marks,
                                    "Confirm Removal",
                                    JOptionPane.YES_NO_OPTION
                            );


                    if (
                            choice ==
                            JOptionPane.YES_OPTION
                    ) {

                        student.remove(i);

                        saveDatabase();

                        refreshTable();


                        JOptionPane.showMessageDialog(
                                this,
                                "Student removed successfully!"
                        );
                    }

                    return;
                }
            }


            JOptionPane.showMessageDialog(
                    this,
                    "Student not found!"
            );


        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a valid ID!"
            );
        }
    }


    // =========================================================
    // SEARCH STUDENT
    // =========================================================

    void searchStudentGUI() {

        String input =
                JOptionPane.showInputDialog(
                        this,
                        "Enter Student ID:"
                );


        if (input == null) {
            return;
        }


        try {

            int id =
                    Integer.parseInt(
                            input.trim()
                    );


            for (Student s : student) {

                if (s.ID == id) {

                    String message =
                            "Student Found\n\n" +
                            "ID : " + s.ID +
                            "\nName : " + s.name +
                            "\nMarks : " + s.marks + " %" +
                            "\nGrade : " + s.getGrade();


                    JOptionPane.showMessageDialog(
                            this,
                            message,
                            "Student Details",
                            JOptionPane.INFORMATION_MESSAGE
                    );

                    return;
                }
            }


            JOptionPane.showMessageDialog(
                    this,
                    "No student found!"
            );


        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a valid ID!"
            );
        }
    }


    // =========================================================
    // UPDATE MARKS
    // =========================================================

    void updateStudentGUI() {

        String input =
                JOptionPane.showInputDialog(
                        this,
                        "Enter Student ID:"
                );


        if (input == null) {
            return;
        }


        try {

            int id =
                    Integer.parseInt(
                            input.trim()
                    );


            for (Student s : student) {

                if (s.ID == id) {

                    String marksInput =
                            JOptionPane.showInputDialog(
                                    this,
                                    "Student: " + s.name +
                                    "\nCurrent Marks: " +
                                    s.marks +
                                    "\n\nEnter New Marks:"
                            );


                    if (marksInput == null) {
                        return;
                    }


                    double newMarks =
                            Double.parseDouble(
                                    marksInput.trim()
                            );


                    if (
                            newMarks < 0 ||
                            newMarks > 100
                    ) {

                        JOptionPane.showMessageDialog(
                                this,
                                "Marks must be between 0 and 100!"
                        );

                        return;
                    }


                    s.marks = newMarks;


                    saveDatabase();

                    refreshTable();


                    JOptionPane.showMessageDialog(
                            this,
                            "Marks updated successfully!"
                    );

                    return;
                }
            }


            JOptionPane.showMessageDialog(
                    this,
                    "Student not found!"
            );


        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter valid numbers!"
            );
        }
    }


    // =========================================================
    // VIEW / REFRESH TABLE
    // =========================================================

    void refreshTable() {

        if (tableModel == null) {
            return;
        }


        tableModel.setRowCount(0);


        for (int i = 0;
             i < student.size();
             i++) {

            Student s =
                    student.get(i);


            Object[] row = {

                    i + 1,

                    s.ID,

                    s.name,

                    String.format(
                            "%.2f",
                            s.marks
                    ),

                    s.getGrade()
            };


            tableModel.addRow(row);
        }
    }


    // =========================================================
    // SORT STUDENTS
    // =========================================================

    void sort(ArrayList<Student> student) {

        student.sort(
                Comparator.comparingInt(
                        s -> s.ID
                )
        );
    }


    // =========================================================
    // STATISTICS
    // =========================================================

    void showStatisticsGUI() {

        if (student.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "No students found!"
            );

            return;
        }


        int total =
                student.size();


        int passed = 0;
        int failed = 0;


        double totalMarks = 0;


        double highest = 0;
        double lowest = 100;


        for (Student s : student) {

            if (s.marks >= 60) {
                passed++;
            } else {
                failed++;
            }


            totalMarks += s.marks;


            if (s.marks > highest) {
                highest = s.marks;
            }


            if (s.marks < lowest) {
                lowest = s.marks;
            }
        }


        double average =
                totalMarks / total;


        String message =
                "CLASS STATISTICS\n\n" +

                "Total Students : " +
                total +

                "\nPassed Students : " +
                passed +

                "\nFailed Students : " +
                failed +

                "\nAverage Marks : " +
                String.format(
                        "%.2f",
                        average
                ) +

                "\nHighest Marks : " +
                String.format(
                        "%.2f",
                        highest
                ) +

                "\nLowest Marks : " +
                String.format(
                        "%.2f",
                        lowest
                );


        JOptionPane.showMessageDialog(
                this,
                message,
                "Class Statistics",
                JOptionPane.INFORMATION_MESSAGE
        );
    }


    // =========================================================
    // MAIN
    // =========================================================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(
                () -> {

                    SGMS_V3 gui =
                            new SGMS_V3();

                    gui.setVisible(true);
                }
        );
    }
}