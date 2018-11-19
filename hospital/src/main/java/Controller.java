import jdk.nashorn.internal.runtime.UserAccessorProperty;

import java.util.List;

public class Controller {

	public static boolean loginUser(String username, String password) {
		boolean userExists = UserDAO.userWithUsernameExists(username);
		if (!userExists) {
			return false;
		}
		if (userExists) {
			if (validateUserPass(password)) {
				return true;
			}
			;
			return false;
		} else {
			return true;
		}
	}

	//<<<<<<< HEAD
	public static boolean deletePatientFolder(int ID) {
		boolean result = false;
		boolean patientFldrExist = PatientFolderDAO.patientFolderExist(ID);
		if (patientFldrExist) {
			result = PatientFolderDAO.deletePatientFolder(ID);
		}
		return result;
	}

	public static boolean openFolder(String patientID, String specialistID) {

		Patient patient = PatientDAO.getPatient(patientID);

		PatientFolder patientFolder = new PatientFolder();
		patientFolder.setPatientID(patient.getPatientID());
		patientFolder.setOncologistID(specialistID);
		return PatientFolderDAO.insertFolder(patientFolder);

	}

	public static boolean registerStudent(String studentID) {
		boolean stExists = StudentDAO.studentWithIDExists(studentID);
//=======


		public static boolean registerUser (String username, String password, String role){
			boolean stExists = UserDAO.userWithUsernameExists(username);
//>>>>>>> 192a5a8fc875b366436a72c6f858b330faf78fcb
			if (!stExists) {
				User user = new User();
				user.setUsername(username);
				user.setPassword(password);
				user.setRole(role);
				UserDAO.insertUser(user);
			}
			if (stExists) {
				return false;
			} else {
				return true;
			}
		}

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


//	public static List<Student> getStudents(String courseTitle) {
//		return EnrollmentDAO.getStudents(courseTitle);
//	}


		public static String getUserRole (String username){
			return UserDAO.getUserRole(username);
		}


		private static boolean validateUserPass (String password){
			return UserDAO.checkPass(password);
		}
	}
}