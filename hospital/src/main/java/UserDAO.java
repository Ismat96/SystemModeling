import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public static boolean userWithIDExists(long userID){
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
                    "SELECT * FROM user WHERE userID = '"+userID+"'");
            while(result.next()){
                output= true;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return output;
    }

    public static boolean insertStudent(User user){
        Connection con = null;
        Statement stmt = null;
        int result = 0;
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            con = DriverManager.getConnection( "jdbc:hsqldb:hsql://localhost/hospitaldb", "SA", "");
            stmt = con.createStatement();
            result = stmt.executeUpdate("INSERT INTO user VALUES ('"+user.getID()+"','"+user.getUsername()+"','" + user.getPassword()+"','"+ user.getRole()+"');");
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


    public static User getUser(User user){
        Connection con = null;
        Statement stmt = null;
        ResultSet result = null;
//        ArrayList<Student> output = new ArrayList<Student>();

        User us = new User();
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            con = DriverManager.getConnection(
                    "jdbc:hsqldb:hsql://localhost/hospitaldb", "SA", "");
            stmt = con.createStatement();
            result = stmt.executeQuery(
                    "SELECT userID FROM user WHERE id = '"+user.getID()+"'");

            us.setID(result.getLong("userID"));

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return us;
    }
}
