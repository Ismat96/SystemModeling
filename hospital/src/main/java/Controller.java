import java.util.List;

public class Controller {

	public static boolean createCourse(String title){
		boolean courseExists = CourseDAO.courseWithTitleExists(title);
		if(!courseExists){
			Course course = new Course();
			course.setTitle(title);
			CourseDAO.insertCourse(course);
		}
		if(courseExists){
			return false;
		}else{
			return true;
		}
	}
	
	public static boolean registerStudent(String studentID){
		boolean stExists = StudentDAO.studentWithIDExists(studentID);
		if(!stExists){
			Student student = new Student();
			student.setID(studentID);
			StudentDAO.insertStudent(student);
		}
		if(stExists){
			return false;
		}else{
			return true;
		}
	}

	public static int enrollStudent(String studentID, String courseTitle){
		boolean stExists = StudentDAO.studentWithIDExists(studentID);
		if(!stExists)
			return -1;  // Student does not exist
		boolean courseExists = CourseDAO.courseWithTitleExists(courseTitle);
		if(!courseExists)
			return -2;  // Course does not exist
		boolean enrollExists = EnrollmentDAO.enrollmentExists(studentID, courseTitle);
		if(enrollExists)
			return -3;  // Student already enrolled in the course
		boolean output = EnrollmentDAO.insertEnrollment(studentID, courseTitle);
		if(output)
			return 0;
		else
			return -4;
	}


	public static List<Student> getStudents(String courseTitle) {
		return EnrollmentDAO.getStudents(courseTitle);
	}
}