import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;

class Student{
    int ID;
    String name;
    double marks;
    Student(int r, String n, double m){
        ID = r;
        name = n;
        marks = m;
    }

    // To assign grades based n their marks
    
    String getGrade(){

    if(marks >= 90){
        return "A ( PASS )";
    }
    else if(marks >= 80){
        return "B ( PASS )";
    }
    else if(marks >= 70){
        return "C ( PASS )";
    }
    else if(marks >= 60){
        return "D ( PASS )";
    }
    else{
        return "F ( FAIL )";
    }
}
    
}
public class SGMS {

    // Function to Add students
    
    static void addS(Scanner sc, ArrayList<Student> student){
        System.out.print("Enter Student ID: ");
        int r = sc.nextInt();
        sc.nextLine();
        
        // To check if the Student ID already exists or not
        
        for(Student s: student){
            if(s.ID==r){
                System.out.println("Student ID already exists!");
                return;
            }
        }
        System.out.print("Enter Student Name: ");
        String n = sc.nextLine();
        System.out.print("Enter Student Marks (in %): ");
        double m = sc.nextDouble();
        Student s= new Student(r,n,m);
        student.add(s);
        System.out.println("Student Added Successfully!");
        
    }
    
    // Function to Sort students based on ID and name in Ascen. order 
    
    static void sort(ArrayList<Student> student){
    student.sort(Comparator.comparingInt(s -> s.ID));
    }
    
    // Function to remove students
    
    static void remS(Scanner sc, ArrayList<Student> student){
        System.out.print("Enter Student ID : ");
        int id= sc.nextInt();
        boolean found= false;
        System.out.println("\n========Students=======");
        System.out.printf("%-5s %-10s %-30s %-10s %-10s%n",
                          "No.", "ID", "Name", "Marks", "Grade");
        System.out.println("----------------------------------------------------------------------");
        for(int i=0; i<student.size(); i++){
            Student s= student.get(i);
            if(s.ID==id){
                System.out.printf( "%-5d %-10d %-30s %-10.2f %-10s%n" 
                                      ,i+1 , s.ID , s.name , s.marks , s.getGrade());
                student.remove(i);
                System.out.println("Student Removed Successfully!");
                found = true;
                break;
            }
        }
        if(found==false){
                System.out.println("Student not found!");
        }
    }
    
    // Function to View all the Students
    
    static void viewS( ArrayList<Student> student){
        System.out.println("\n========Students=======");
        if(student.size()==0){
            System.out.println("No Students Found!");
            return;
        }
        System.out.printf("%-5s %-10s %-30s %-10s %-10s%n",
                          "No.", "ID", "Name", "Marks", "Grade");
        System.out.println("----------------------------------------------------------------------");
        for(int i=0; i< student.size(); i++){
            Student s=student.get(i);
            System.out.printf( "%-5d %-10d %-30s %-10.2f %-10s%n" 
                                      ,i+1 , s.ID , s.name , s.marks , s.getGrade());
        }
    }
    
    // Function to Update the marks of students
    
    static void updateS( Scanner sc, ArrayList<Student> student){
        System.out.print("Enter Student ID : ");
        int id= sc.nextInt();
        boolean found= false;
        System.out.println("\n========Students=======");
        System.out.printf("%-5s %-10s %-30s %-10s %-10s%n",
                          "No.", "ID", "Name", "Marks", "Grade");
        System.out.println("----------------------------------------------------------------------");
        for(int i=0; i<student.size(); i++){
            Student s= student.get(i);
            if(s.ID==id){
            System.out.printf( "%-5d %-10d %-30s %-10.2f %-10s%n" 
                                      ,i+1 , s.ID , s.name , s.marks , s.getGrade());
                System.out.print("Set new marks: ");
                double m= sc.nextDouble();
                s.marks=m; 
                System.out.print("Marks Updated Successfully!");                     
                found = true;
                break;
            }
        }
        if(found==false){
                System.out.println("Student not found!");
        }

}
    public static void main(String []args){
        Scanner sc= new Scanner(System.in); 
        ArrayList<Student> student = new ArrayList<>();
        int a;
        while(true){
            System.out.println("\n===== Student Grade Management System =====");
            System.out.println("Operation:");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. View all Students");
            System.out.println("4. Update marks");
            System.out.println("5. Exit\n");
        
            System.out.print("Enter choice: ");
            a=sc.nextInt();

            switch (a) {
            case 1 : addS(sc, student);
                     sort(student);
            break;
            case 2 : remS(sc, student);
            break;
            case 3 : viewS(student);
            break;
            case 4 : updateS(sc, student);
            break;
            case 5 : System.out.println("Exiting......");
            sc.close();
            return;
            default: System.out.print("\nPlease enter a valid choice\n");

            }
        }
    }

    
}
