import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseManager {

	public static void initializeDatabase(){
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/hospitaldb", "SA", "");
			stmt = con.createStatement();
			stmt.executeUpdate("CREATE TABLE student (studentID varchar(20) NOT NULL, PRIMARY KEY (studentID));");
			stmt.executeUpdate("CREATE TABLE patient (patientID varchar(20) PRIMARY KEY," +
														   "name varchar(30)," +
															"surname varchar(30)," +
															"date DATE," +
															"insuranceCode varchar(60)" +
					");");
			stmt.executeUpdate("CREATE TABLE patientFolder (ID int PRIMARY KEY," +
																 "patientID varchar(30)," +
																 "visitID varchar(30)" +
					");");
			stmt.executeUpdate("CREATE TABLE course (title varchar(20) NOT NULL, PRIMARY KEY (title));");
			stmt.executeUpdate("CREATE TABLE enrollment (studentID varchar(20) NOT NULL, title varchar(20) NOT NULL, PRIMARY KEY (studentID,title), FOREIGN KEY (studentID) REFERENCES student(studentID), FOREIGN KEY (title) REFERENCES course(title));");


			stmt.executeUpdate("CREATE TABLE user (username varchar(20) NOT NULL,  PRIMARY KEY,  password varchar(20) NOT NULL, role varchar(50) NOT NULL);");


			System.out.println("Database initialized successfully");
		}catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	public static void resetDatabase(){
		Connection con = null;
		Statement stmt = null;

		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/universitydb", "SA", "");
			stmt = con.createStatement();
			stmt.executeUpdate("DROP TABLE enrollment;");
			stmt.executeUpdate("DROP TABLE student;");
			stmt.executeUpdate("DROP TABLE course;");
			System.out.println("Database reset successfully");
		}  catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}



}
