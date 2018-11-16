import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class PatientFolderDAO {

    public static boolean insertFolder(PatientFolder patientFolder) {
        Connection con = null;
        Statement stmt = null;
        int result = 0;
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/hospitalDB", "SA", "");
            stmt = con.createStatement();
            result = stmt.executeUpdate(
                    "INSERT INTO patientFolder VALUES ('" + patientFolder.getID() + "', '" +
                                                                patientFolder.getPatientID() + "', '" +
                                                                patientFolder.getVisitID() + "', '" +
                                                            "' )");
            con.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        if (result == 0) {
            return false;
        } else {
            return true;
        }
    }
    public static boolean patientFolderExist ( int ID){
        Connection con = null;
        Statement stmt = null;
        ResultSet result = null;
        boolean output = false;
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            con = DriverManager.getConnection(
                    "jdbc:hsqldb:hsql://localhost/hospitaldb", "SA", "");
            stmt = con.createStatement();
            result = stmt.executeQuery(
                    "SELECT * FROM patientFolder WHERE ID = '" + ID + "'");
            while (result.next()) {
                output = true;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return output;
    }


    public static boolean deletePatientFolder ( int patientFolderID){
            Connection con = null;
            Statement stmt = null;
            int result = 0;
            try {
                Class.forName("org.hsqldb.jdbc.JDBCDriver");
                con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/universitydb", "SA", "");
                stmt = con.createStatement();
                result = stmt.executeUpdate("DELETE FROM patientFolder WHERE ID = '" + patientFolderID + "'");
                con.commit();
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
            if (result == 0) {
                return false;
            } else {
                return true;
            }


            //public static boolean deletePatientFolder


        }
}
