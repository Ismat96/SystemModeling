import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PatientFolderDAO {
    public static boolean studentWithIDExists(String studentID){
        Connection con = null;
        Statement stmt = null;
        ResultSet result = null;
        boolean output = false;
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            con = DriverManager.getConnection(
                    "jdbc:hsqldb:hsql://localhost/universitydb", "SA", "");
            stmt = con.createStatement();
            result = stmt.executeQuery(
                    "SELECT * FROM student WHERE studentID = '"+studentID+"'");
            while(result.next()){
                output= true;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return output;
    }

}
