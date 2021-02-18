import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NewsDb {

    public static boolean insert(String header, String text) {
        String sql = "insert into news(news_header, news_text, news_date) values(?, ?, now())";

        int result = 0;

        try (Connection conn = DbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, header);
            stmt.setString(2, text);
            result = stmt.executeUpdate();
        }

        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result > 0;
    }

    public static void show(int id) {
        String sql = "SELECT news_header, news_text FROM news WHERE news_id = ?";

        try (Connection conn = DbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql))
            {
                stmt.setInt(1, id);

                try (ResultSet rs = stmt.executeQuery();) {
                    while (rs.next()) {
                        System.out.println(rs.getString("news_header") + " " + rs.getString("news_text"));
                    }
                }
            }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean delete(int id) {
        String sql = "DELETE FROM news WHERE news_id = ?";

        int result = 0;

        try (Connection conn = DbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             stmt.setInt(1, id);
             result = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result > 0;
    }

    public static boolean update(int id) {
        String sql = "UPDATE news SET news_header = ?, news_text = ? WHERE news_id = ?";

        int result = 0;

        try (Connection conn = DbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             stmt.setString(1, Main.generate());
             stmt.setString(2, Main.generate());
             stmt.setInt(3, id);
             result = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result > 0;
    }
}
