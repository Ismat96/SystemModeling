import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MedicineDAO {

    public static boolean insertMedicine(Medicine medicine){
        Connection con = null;
        Statement stmt = null;
        int result = 0;
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            con = DriverManager.getConnection( "jdbc:hsqldb:hsql://localhost/hospitaldb", "SA", "");
            stmt = con.createStatement();

            result = stmt.executeUpdate("INSERT INTO medicine VALUES ('"+medicine.getId()+"','"+medicine.getName()+"','" +medicine.getCompanyName()+"');");
            con.commit();
        }catch (Exception e) {
            e.printStackTrace(System.out);
        }
        if(result == 0){
            return false;
        }
        else{
            return true;
        }
    }

    public static List<Medicine> getMedicines(){
        Connection con = null;
        Statement stmt = null;
        ResultSet result = null;
        ArrayList<Medicine> output = new ArrayList<Medicine>();
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            con = DriverManager.getConnection(
                    "jdbc:hsqldb:hsql://localhost/hospitaldb", "SA", "");
            stmt = con.createStatement();
            result = stmt.executeQuery(
                    "SELECT * FROM medicine ");

            while(result.next()){
                Medicine m = new Medicine();
                m.setId(result.getLong("id"));
                m.setName(result.getString("name"));
                m.setCompanyName(result.getString("companyName"));
                output.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return output;
    }

}
