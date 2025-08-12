import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnection {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/online_ordering_proj";
    private static final String USER = "root";
    private static final String PASSWORD = "toor";

    public static Connection getConnection () {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
            System.out.println ("Database connection established");
        } catch (SQLException e) {
            System.out.println ("DB Connection failed!");
            System.out.println ("SQL State: " + e.getSQLState ());
            System.out.println ("Error Code: " + e.getErrorCode ());
            System.out.println ("Message: " + e.getMessage ());
            e.printStackTrace ();
        }

        return connection;
    }

    public static void getPrep (int senderId) {
        PreparedStatement pstmt = null;

        try {
            String SQL = "SELECT * FROM package WHERE package.senderId=?";
        }
    }
}
