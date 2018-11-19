import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * UseDAO.java
 */
public class UserDAO {

    /**
     * checks whether user with specified username exists or not
     * @param username
     * @return returns true if user exists false otherwise
     */
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


//    public static boolean login(String username, String password){
//        Connection con = null;
//        Statement stmt = null;
//        ResultSet result = null;
//        boolean output = false;
//        try {
//            Class.forName("org.hsqldb.jdbc.JDBCDriver");
//            con = DriverManager.getConnection(
//                    "jdbc:hsqldb:hsql://localhost/hospitaldb", "SA", "");
//            stmt = con.createStatement();
//            result = stmt.executeQuery(
//                    "SELECT * FROM user WHERE username = '"+username+"'");
//            while(result.next()){
//                String pass = result.getString("password");
//                if (pass.equals(password)){
//                    output= true;
//                }else {
//                    output = false;
//                }
//
//            }

//        } catch (Exception e) {
//            e.printStackTrace(System.out);
//        }
//        return output;
//    }

    /**
     * Inserts new user to the system
     * @param user
     * @return true if user inserted false otherwise
     */
    public static boolean insertUser(User user){
        Connection con = null;
        Statement stmt = null;
        int result = 0;
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            con = DriverManager.getConnection( "jdbc:hsqldb:hsql://localhost/hospitaldb", "SA", "");
            stmt = con.createStatement();
            result = stmt.executeUpdate("INSERT INTO user VALUES ('"+user.getUsername()+"','" + user.getPassword()+"','"+ user.getRole()+"');");
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


    /**
     * checks password of user
     * @param password
     * @return true if password is correct false otherwise
     */
    public static boolean checkPass(String password){
        Connection con = null;
        Statement stmt = null;
        ResultSet result = null;
//        ArrayList<Student> output = new ArrayList<Student>();
        boolean output = false;
        User us = new User();
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            con = DriverManager.getConnection(
                    "jdbc:hsqldb:hsql://localhost/hospitaldb", "SA", "");
            stmt = con.createStatement();
            result = stmt.executeQuery(
                    "SELECT * FROM user WHERE password = '"+password+"'");

//            us.setUsername(result.getString("username"));
//            us.setPassword(result.getString("password"));
//            us.setRole(result.getString("role"));

            while(result.next()){


                output= true;
            }

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return output;
    }

    /**
     * Returns user by username
     * @param username
     * @return User role
     */
    public static String getUserRole(String username){
        Connection con = null;
        Statement stmt = null;
        ResultSet resultSet = null;
        User user = new User();
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            con = DriverManager.getConnection(
                    "jdbc:hsqldb:hsql://localhost/hospitaldb", "SA", "");
            stmt = con.createStatement();
            resultSet = stmt.executeQuery(
                    "SELECT * FROM user WHERE username = '"+username+"'");

            while(resultSet.next()) {
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(resultSet.getString("role"));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return user.getRole();
    }
}
