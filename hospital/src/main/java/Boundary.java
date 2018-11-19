import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Boundary {


    public static void main(String[] args) {
        System.out.println("Do you want to initialize the database? (Y/N)");
        Scanner scan = new Scanner(System.in);
        if (scan.nextLine().equals("Y")) {
            DatabaseManager.resetDatabase();
            DatabaseManager.initializeDatabase();
        }
        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. login");
            System.out.println("2. Register a new user");
            System.out.println("3. Exit");

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

                        String role = Controller.getUserRole(username1).toLowerCase();

//                        getDoctorFunctions(role);
                        if (role.equals("doctor")) {
                            while (true) {

                                System.out.println("1. addNewMedicine");
                                System.out.println("2. getMedicines");
                                System.out.println("3. Exit");
                                int choiceDoctor = new Integer(scan.nextLine());

                                switch (choiceDoctor) {
                                    case 1:
                                        System.out.println("Insert id:");
                                        long idMed = scan.nextLong();
                                        scan.nextLine();
                                        System.out.println("Insert name:");
                                        String nameMed = scan.nextLine();
                                        System.out.println("Insert company Name:");
                                        String compNameMed = scan.nextLine();
                                        Medicine med = new Medicine();
                                        med.setId(idMed);
                                        med.setName(nameMed);
                                        med.setCompanyName(compNameMed);
                                        if (Controller.addNewMedicine(med)) {
                                            System.out.println("Medicine inserted");
                                        } else {
                                            System.out.println("Failed while inserting medicine");
                                        }
                                        break;
                                    case 2:
                                        System.out.println((Controller.getMedicines()));
                                        break;
                                    case 3:
                                        break;

                                }

                                if (choiceDoctor == 3) {
                                    break;
                                }
                            }
                        } else if (role.equals("receptionist")){
                            //TODO add receptionist's functions
                            System.out.println("Recep");
                        } else {
                            System.out.println("**Could not find any functions for that role, please select one of these roles (doctor, receptionist) while REGISTERING to the system ");
                        }
                    } else {
                        System.out.println("Failed to log in");
                    }


                    break;
                case 2:
                    System.out.println("Insert username:");

                    String username = scan.nextLine();
                    System.out.println("Insert password:");
                    String password = scan.nextLine();

                    System.out.println("Please select one among these roles (doctor, receptionist)");

                    System.out.println("Insert role: ");
                    String role = scan.nextLine();

                    boolean registered = Controller.registerUser(username, password, role);

                    if (registered) {
                        System.out.println("User registered!");
                    } else {
                        System.out.println("Register failed!");
                    }
                    break;
//                case 3:
//                    System.out.println("Insert course title:");
//                    String courseTitle = scan.nextLine();
//                    System.out.println("Insert student ID:");
//                    String studentID = scan.nextLine();
//                    int enrolled = Controller.enrollStudent(studentID, courseTitle);
//                    if (enrolled == 0)
//                        System.out.println("Student enrolled in the course!");
//                    if (enrolled == -1)
//                        System.out.println("Student does not exist!");
//                    if (enrolled == -2)
//                        System.out.println("Course does not exist!");
//                    if (enrolled == -3)
//                        System.out.println("Student already enrolled in the course!");
//                    if (enrolled == -3)
//                        System.out.println("Query failed!");
//                    break;
//                case 4:
//                    System.out.println("Insert course title:");
//                    String course = scan.nextLine();
//                    List<Student> students = Controller.getStudents(course);
//                    System.out.println("Students enrolled for " + course + ":");
//                    for (Student s : students) {
//                        System.out.println(s.getID());
//                    }
//                    break;
                default:
                    choice = 3;
                    break;
            }
            if (choice == 3)
                break;
        }
        scan.close();
    }


    private static void getDoctorFunctions(String role) {
    }
}
