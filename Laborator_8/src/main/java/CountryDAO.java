import java.sql.*;

public class CountryDAO {
    private String name;
    private int code;
    private ContinentDAO continent;

    public void create(String name, int idContinent) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement("insert into countries (name, id_continent) values (?,?)")) {
            pstmt.setString(1, name);
            pstmt.setInt(2, code);
            pstmt.setInt(3, idContinent);
            pstmt.executeUpdate();
        }
    }

    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select id from countries where name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    public String findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select name from countries where id='" + id + "'")) {
            return rs.next() ? rs.getString(2) : null;
        }
    }
}
