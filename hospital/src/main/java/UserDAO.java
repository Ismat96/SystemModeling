import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public static boolean userWithUsernameExists(String username){
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
                    "SELECT * FROM user WHERE username = '"+username+"'");
            while(result.next()){
                output= true;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return output;
    }


    public static boolean login(String username, String password){
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
                    "SELECT * FROM user WHERE username = '"+username+"'");
            while(result.next()){
                String pass = result.getString("password");
                if (pass.equals(password)){
                    output= true;
                }else {
                    output = false;
                }

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
            result = stmt.executeUpdate("INSERT INTO user VALUES ('"+user.getUsername()+"','"+user.getUsername()+"','" + user.getPassword()+"','"+ user.getRole()+"');");
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
                    "SELECT userID FROM user WHERE id = '"+user.getUsername()+"'");

            us.setUsername(result.getString("username"));

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return us;
    }
}
