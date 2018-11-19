import jdk.nashorn.internal.runtime.UserAccessorProperty;

import java.util.List;

public class Controller {

	public static boolean loginUser(String username, String password){
		boolean userExists = UserDAO.userWithUsernameExists(username);
		if(!userExists){
			return false;
		}
		if(userExists){
			if (validateUserPass(password)){
				return true;
			};
			return false;
		}else{
			return true;
		}
	}



	public static boolean registerUser(String username, String password, String role){
		boolean stExists = UserDAO.userWithUsernameExists(username);
		if(!stExists){
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setRole(role);
			UserDAO.insertUser(user);
		}
		if(stExists){
			return false;
		}else{
			return true;
		}
	}


	public static boolean addNewMedicine(Medicine med){
		return MedicineDAO.insertMedicine(med);
	}

	public static List<Medicine> getMedicines(){
		return MedicineDAO.getMedicines();
	}
//
//
//	public static int enrollStudent(String studentID, String courseTitle){
//		boolean stExists = StudentDAO.studentWithIDExists(studentID);
//		if(!stExists)
//			return -1;  // Student does not exist
//		boolean courseExists = CourseDAO.courseWithTitleExists(courseTitle);
//		if(!courseExists)
//			return -2;  // Course does not exist
//		boolean enrollExists = EnrollmentDAO.enrollmentExists(studentID, courseTitle);
//		if(enrollExists)
//			return -3;  // Student already enrolled in the course
//		boolean output = EnrollmentDAO.insertEnrollment(studentID, courseTitle);
//		if(output)
//			return 0;
//		else
//			return -4;
//	}


	public static List<Student> getStudents(String courseTitle) {
		return EnrollmentDAO.getStudents(courseTitle);
	}


	public static String getUserRole(String username) {
		return UserDAO.getUserRole(username);
	}


	private static boolean validateUserPass(String password) {
		return UserDAO.checkPass(password);
	}
}