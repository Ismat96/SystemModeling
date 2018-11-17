import java.util.List;
import java.util.Scanner;

public class Boundary {


    public static void main(String[] args) {
        System.out.println("Do you want to initialize the database? (Y/N)");
        System.out.println("dsadsa");
        Scanner scan = new Scanner(System.in);
        if (scan.nextLine().equals("Y")) {
            DatabaseManager.resetDatabase();
            DatabaseManager.initializeDatabase();
        }
        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. login");
            System.out.println("2. Register a new user");
            System.out.println("3. Enroll an existing student in an existing course");
            System.out.println("4. Get students");
            System.out.println("5. Exit");
            int choice = new Integer(scan.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Insert username:");
                    String username1 = scan.nextLine();
                    System.out.println("Insert password:");
                    String pass = scan.nextLine();
                    boolean login = Controller.loginUser(username1, pass);
                    if (login) {
                        System.out.println("Logged in!");
                    } else {
                        System.out.println("Failed to log in");
                    }
                    break;
                case 2:
                    System.out.println("Insert username:");

                    String username = scan.nextLine();
                    System.out.println("Insert password:");
                    String password = scan.nextLine();

                    System.out.println("Insert role: ");
                    String role = scan.nextLine();

                    boolean registered = Controller.registerUser(username, password, role);

                    if (registered) {
                        System.out.println("User registered!");
                    } else {
                        System.out.println("Register failed!");
                    }
                    break;
                case 3:
                    System.out.println("Insert course title:");
                    String courseTitle = scan.nextLine();
                    System.out.println("Insert student ID:");
                    String studentID = scan.nextLine();
                    int enrolled = Controller.enrollStudent(studentID, courseTitle);
                    if (enrolled == 0)
                        System.out.println("Student enrolled in the course!");
                    if (enrolled == -1)
                        System.out.println("Student does not exist!");
                    if (enrolled == -2)
                        System.out.println("Course does not exist!");
                    if (enrolled == -3)
                        System.out.println("Student already enrolled in the course!");
                    if (enrolled == -3)
                        System.out.println("Query failed!");
                    break;
                case 4:
                    System.out.println("Insert course title:");
                    String course = scan.nextLine();
                    List<Student> students = Controller.getStudents(course);
                    System.out.println("Students enrolled for " + course + ":");
                    for (Student s : students) {
                        System.out.println(s.getID());
                    }
                    break;
                default:
                    choice = 5;
                    break;
            }
            if (choice == 5)
                break;
        }
        scan.close();
    }
}
