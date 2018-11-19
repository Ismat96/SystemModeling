import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OncologistDAO {
    public static List<Oncologist> getListOfOncologists() {
        Connection con = null;
        Statement stmt = null;
        ResultSet result = null;
        ArrayList<Oncologist> output = new ArrayList<Oncologist>();
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            con = DriverManager.getConnection(
                    "jdbc:hsqldb:hsql://localhost/universitydb", "SA", "");
            stmt = con.createStatement();
            result = stmt.executeQuery(
                    "SELECT * FROM oncologist");

            while(result.next()){
                Oncologist oncologist = new Oncologist();
                oncologist.setProfessionalID(Integer.parseInt(result.getString("professionalID")));
                oncologist.setName(result.getString("name"));
                oncologist.setSurname(result.getString("surname"));
                oncologist.setType(result.getString("type"));
                oncologist.setCareerLevel(result.getString("careerLevel"));
                output.add(oncologist);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return output;
    }
    public static List<Oncologist> getListOfOncologists(int professionalID) {
        List<Oncologist> allOncologist = getListOfOncologists();
        List<Oncologist> output = new ArrayList<Oncologist>();
        for (Oncologist oncologist : allOncologist){
            if (oncologist.getProfessionalID() == professionalID) {
                output.add(oncologist);
            }
        }
        return output;
    }
}
