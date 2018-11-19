import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VisitDAO {
    public static List<Oncologist> getAvailableOncologists(String date){
        Connection con = null;
        Statement stmt = null;
        ResultSet availableOncologistID = null;
        ArrayList<Oncologist> oncologists = new ArrayList<Oncologist>();
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            con = DriverManager.getConnection(
                    "jdbc:hsqldb:hsql://localhost/hospitaldb", "SA", "");
            stmt = con.createStatement();
            availableOncologistID = stmt.executeQuery(
                                        "select A.oncologistID as oncologistID, " +
                                                    "count(*)" +
                                            "from (select * from visit where date = '" + date + "') as A" +
                                            "group by A.oncologistID, A.patientID" +
                                            "Having count(*) < 10");
            while(availableOncologistID.next()){
                List<Oncologist> oncologist = OncologistDAO.getListOfOncologists(Integer.parseInt(availableOncologistID.getString("oncologistID")));
                oncologists.addAll(oncologist);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return oncologists;
    }
    public static boolean insertFolder(Visit visit) {
        Connection con = null;
        Statement stmt = null;
        int result = 0;
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/hospitalDB", "SA", "");
            stmt = con.createStatement();
            result = stmt.executeUpdate(
                    "INSERT INTO visit VALUES ('" + visit.getID() + "', '" +
                            visit.getPatientID() + "', '" +
                            visit.getOncologistID() + "', '" +
                            visit + "', '" +
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
    public static boolean insertVisit(Visit visit) {

        return true;
    }

}
