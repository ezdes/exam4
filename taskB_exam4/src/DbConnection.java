import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static final String url = "jdbc:postgresql://localhost:5432/exam4";
    private static final String user = "postgres";
    private static final String password = "2m3410lt";

    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        }

        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
