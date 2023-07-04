import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private int studentID;
    private String name;
    private int age;
    private int grade;
    private double GPA;

    public Student(int studentID, String name, int age, int grade, double GPA) {
        this.studentID = studentID;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.GPA = GPA;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getGrade() {
        return grade;
    }

    public double getGPA() {
        return GPA;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        return "Student ID: " + studentID +
                "\nName: " + name +
                "\nAge: " + age +
                "\nGrade: " + grade +
                "\nGPA: " + GPA + "\n";
    }
}

class StudentManagementSystem {
    private ArrayList<Student> studentRecords;

    public StudentManagementSystem() {
        studentRecords = new ArrayList<>();
    }

    public void addStudent(Student student) {
        studentRecords.add(student);
        System.out.println("Student added successfully!");
    }

    public void displayStudentDetails(int studentID) {
        for (Student student : studentRecords) {
            if (student.getStudentID() == studentID) {
                System.out.println(student);
                return;
            }
        }
        System.out.println("Student with ID " + studentID + " not found.");
    }

    public void searchStudentByName(String name) {
        boolean found = false;
        for (Student student : studentRecords) {
            if (student.getName().equalsIgnoreCase(name)) {
                System.out.println(student);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No students found with the name: " + name);
        }
    }

    public void searchStudentByGrade(int grade) {
        boolean found = false;
        for (Student student : studentRecords) {
            if (student.getGrade() == grade) {
                System.out.println(student);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No students found in grade " + grade);
        }
    }

    public void updateStudentInfo(int studentID, String name, int age, int grade, double GPA) {
        for (Student student : studentRecords) {
            if (student.getStudentID() == studentID) {
                student.setName(name);
                student.setAge(age);
                student.setGrade(grade);
                student.setGPA(GPA);
                System.out.println("Student information updated successfully!");
                return;
            }
        }
        System.out.println("Student with ID " + studentID + " not found.");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem system = new StudentManagementSystem();

        while (true) {
            System.out.println("\n---- Student Management System ----");
            System.out.println("1. Add a student");
            System.out.println("2. Display student details");
            System.out.println("3. Search student by name");
            System.out.println("4. Search student by grade");
            System.out.println("5. Update student information");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter student ID: ");
                    int studentID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student age: ");
                    int age = scanner.nextInt();
                    System.out.print("Enter student grade: ");
                    int grade = scanner.nextInt();
                    System.out.print("Enter student GPA: ");
                    double GPA = scanner.nextDouble();

                    Student student = new Student(studentID, name, age, grade, GPA);
                    system.addStudent(student);
                    break;
                case 2:
                    System.out.print("Enter student ID: ");
                    studentID = scanner.nextInt();
                    system.displayStudentDetails(studentID);
                    break;
                case 3:
                    System.out.print("Enter student name: ");
                    name = scanner.nextLine();
                    system.searchStudentByName(name);
                    break;
                case 4:
                    System.out.print("Enter student grade: ");
                    grade = scanner.nextInt();
                    system.searchStudentByGrade(grade);
                    break;
                case 5:
                    System.out.print("Enter student ID: ");
                    studentID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter updated student name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter updated student age: ");
                    age = scanner.nextInt();
                    System.out.print("Enter updated student grade: ");
                    grade = scanner.nextInt();
                    System.out.print("Enter updated student GPA: ");
                    GPA = scanner.nextDouble();

                    system.updateStudentInfo(studentID, name, age, grade, GPA);
                    break;
                case 6:
                    System.out.println("Exiting the program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
