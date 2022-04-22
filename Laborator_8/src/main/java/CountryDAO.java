import java.sql.*;

public class CountryDAO {

    public void create(String name, int idContinent) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement("INSERT INTO countries (name, id_continent) VALUES (?,?)")) {
            pstmt.setString(1, name);
            pstmt.setInt(2, idContinent);
            pstmt.executeUpdate();
        }
    }

    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id FROM countries WHERE name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    public String findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT name FROM countries WHERE id='" + id + "'")) {
            return rs.next() ? rs.getString(1) : null;
        }
    }
}
