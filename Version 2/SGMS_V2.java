import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.io.*;

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
public class SGMS_V2 {
                                                             // MAIN_MENU

    //Function to create a new database

    static void create(Scanner sc)throws IOException{
        String DB;
        File f;
        while(true){
            System.out.print("Enter Database Name: ");
            DB= sc.nextLine();
            f= new File(DB+".txt");
            if(f.exists()){
                System.out.println("File already Exists! Please use another name.");
            }else{
                break;
            }
        }
        f.createNewFile();
        System.out.println("Database created succesfully.");
    }

    //Function to show availble DB and select one

    static File load(Scanner sc, ArrayList<Student> student) throws IOException{
        File directory=new File(".");
        File[] files= directory.listFiles();
        System.out.println("\nAvailable Databases:\n");
        int count=0;
        for(File f: files){
            if(f.isFile()&&f.getName().endsWith(".txt")){
                count ++;
                System.out.println(count+". "+f.getName());
            }
        }
        if(count==0){
            System.out.println("\nNo Databases Found!");
            return null;
        }
        File d=null;
        while(true){
            System.out.print("\nSelect Database no. : ");
            int a = sc.nextInt();
            if(a<1 || a>count){
                System.out.println("Invalid DB number! Select one from the list.");
            }else{
                int c=0;
                for(File f:files){
                    if(f.isFile() && f.getName().endsWith(".txt")){
                        c++;
                        if(c==a){
                            d=f;
                            break;
                        }
                    }
                }
                break;
            }
        }
        BufferedReader b= new BufferedReader(new FileReader(d));
        String line;
        while((line=b.readLine()) !=null){
            String[] data= line.split(",");
            int id= Integer.parseInt(data[0]);
            String name= data[1];
            double marks= Double.parseDouble(data[2]);
            Student s= new Student(id,name,marks);
            student.add(s);
        }
        b.close();
        System.out.println("\nDatabase Loaded Succesfully.\n");
        return d;
    }
    
    // Function to save all the updation 

    static void save(ArrayList<Student> student, File database) throws IOException{
        BufferedWriter b= new BufferedWriter(new FileWriter(database));
        for (Student s: student){
            b.write(s.ID+","+s.name+","+s.marks);
            b.newLine();
        }
        b.close();
    }


                                                             // SUB_MENU
    
    // Function to Add students

    static void addS(Scanner sc, ArrayList<Student> student){
    int r;
        while(true){
            try{
                System.out.print("Enter Student ID: ");
                r = sc.nextInt();
                sc.nextLine();
                break;
            }catch(InputMismatchException e){
                System.out.println("Invalid Input! Enter a valid Input.\n");
                sc.nextLine();
            }
        }
        // To check if the Student ID already exists or not
        for(Student s: student){
            if(s.ID==r){
                System.out.println("Student ID already exists!");
                return;
            }
        }
        String n;
        while(true){
            System.out.print("Enter Student Name: ");
            n = sc.nextLine();
            if(n.matches("[a-zA-Z ]+")){
                break;
            }
            System.out.println("Invalid name! Use alphabets only.");
        }        

        double m;
        while(true){
            try{
                System.out.print("Enter Student Marks (in %): ");
                m = sc.nextDouble();
                if(m >= 0 && m <= 100){
                    break;
                }
                System.out.println("Invalid Input! Enter between 0 and 100.\n");
            }catch(InputMismatchException e){
                System.out.println("Invalid Input! Enter a valid number.\n");
                sc.nextLine();
            }
        }
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
        int id;
        while(true){
            try{
                System.out.print("Enter Student ID: ");
                id = sc.nextInt();
                sc.nextLine();
                if(id>0){
                    break;
                }
                System.out.println("Invalid Input! ID cannot be Negative or Zero.");
            }catch(InputMismatchException e){
                System.out.println("Invalid Input! Enter a valid Input.\n");
                sc.nextLine();
            }
        }
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

    //Function to search student

    static void search(Scanner sc, ArrayList<Student> student){
        int id;
        while(true){
            try{
                System.out.print("Enter Student ID:");
                id=sc.nextInt();
                sc.nextLine();
                if(id>0){
                    break;
                }
                System.out.println("Invalid Input! ID cannot be Negative or Zero.");
            }catch(InputMismatchException e){
                System.out.println("Invalid Input! Enter a valid Input.\n");
                sc.nextLine();
            }
        }
        System.out.println("\n========Student========");
        boolean a=false;
        for(int i=0; i<student.size(); i++){
            Student s= student.get(i);
            if(s.ID==id){
                System.out.println("ID : "+ s.ID);
                System.out.println("Name : "+ s.name);
                System.out.println("Marks : "+ s.marks +" %");
                System.out.println("Grade : "+ s.getGrade());
                a=true;
                break;
            }
        }
        if(!a){
            System.out.println("\nNo Student Found !");
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
        int id;
        while(true){
            try{
                System.out.print("Enter Student ID:");
                id=sc.nextInt();
                sc.nextLine();
                if(id>0){
                    break;
                }
                System.out.println("Invalid Input! ID cannot be Negative or Zero.");
            }catch(InputMismatchException e){
                System.out.println("Invalid Input! Enter a valid Input.\n");
                sc.nextLine();
            }
        }
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
            double m;
             while(true){
                try{
                    System.out.print("Set new marks: ");
                    m= sc.nextDouble();
                    sc.nextLine();
                    if(m>=0 && m<=100 ){
                        s.marks=m;
                        System.out.print("Marks Updated Successfully!");
                        found = true;
                        break;
                    }
                    System.out.println("Invalid input! Enter marks between 0 to 100.");
                }catch(InputMismatchException e){
                    System.out.println("Invalid input! Enter marks in digits.");
                    sc.nextLine();
                }
             }
            }
        }
        if(found==false){
                System.out.println("Student not found!");
        }

    }

    // Function to Show Class Statistics
    static void statistics(ArrayList<Student> student){
        System.out.println("\n========Class Statistics=======");
        if(student.size()==0){
            System.out.println("No Students Found !");
            return;
        }
        int t=student.size();
        // Total students
        System.out.println("Total Students : " +t);
        int p=0,f=0;
        // Passed and Failed Students
        for(int i=0; i<student.size(); i++){
            Student s= student.get(i);
            if(s.marks>=60){
                p+=1;
            }else{
                f+=1;
            }
        }
        System.out.println("Passed Students : "+ p);
        System.out.println("Failed Students : "+ f);

        // Average marks
        double a=0;
        for(int i=0; i<student.size(); i++){
            Student s= student.get(i);
            a+= s.marks;
        }
        a/=t;
        System.out.printf("Average marks : %.2f%n", a);

        // Highest marks
        double m=0;
        for(int i=0; i<student.size(); i++){
            Student s= student.get(i);
            if(s.marks>m){
                m=s.marks;
            }
        }
        System.out.println("Highest Marks : "+ m);
        
        // Lowest marks
        double l=100;
        for(int i=0; i<student.size(); i++){
            Student s= student.get(i);
            if(s.marks<l){
                l=s.marks;
            }
        }
        System.out.println("Lowest Marks : "+ l);
    }
    public static void main(String []args) throws IOException{
        Scanner sc= new Scanner(System.in); 
        ArrayList<Student> student = new ArrayList<>();
        File database=null;
        int a;
        while(true){
            System.out.println("\n===== Student Grade Management System =====");
            System.out.println("");
            System.out.println("1.Create New Databse");
            System.out.println("2.Load Existing Database");           
            System.out.println("3.Exit\n");           
            int c;               
            while(true){
                try{
                System.out.print("Enter choice: ");
                c=sc.nextInt();
                break;
                }catch(InputMismatchException e){
                System.out.println("Invalid Input! Please enter a choice from the menu above.\n");
                sc.nextLine();
                }
            }           
                switch(c){
                    case 1: sc.nextLine();
                    create(sc);
                    break;
                    case 2:student.clear(); 
                        database=load(sc,student);
                        if(database==null){
                            break;
                        }
                    operations:
                    while(true){
                    System.out.println("\nOperation:");
                    System.out.println("1. Add Student");
                    System.out.println("2. Remove Student");
                    System.out.println("3. Search Student");
                    System.out.println("4. View all Students");
                    System.out.println("5. Update marks");
                    System.out.println("6. Show Statistics");
                    System.out.println("7. Return to Main menu\n");
                    
                    while(true){
                        try{
                            System.out.print("Enter choice: ");
                            a=sc.nextInt();
                            break;
                        }catch(InputMismatchException e){
                            System.out.println("Invalid Input! Please enter a choice from the menu above.\n");
                            sc.nextLine();
                        }
                    }  
                    
                    switch (a) {
                        case 1 : addS(sc, student);
                        sort(student);
                        save(student,database);
                        break;
                        case 2 : remS(sc, student);
                        save(student,database);
                        break;
                        case 3 : search(sc, student);
                        break;
                        case 4 : viewS(student);
                        break;
                        case 5 : updateS(sc, student);
                        save(student,database);
                        break;
                        case 6 : statistics(student);
                        break;
                        case 7 : System.out.println("Returning......");
                        break operations;
                        default: System.out.print("\nPlease enter a valid choice\n");
                        
                    }
                
            }    
            break;
            case 3 : System.out.println("Exiting......");
            sc.close();
            return;
            default: System.out.print("\nPlease enter a valid choice\n");

           }                     
        }
    }
}
