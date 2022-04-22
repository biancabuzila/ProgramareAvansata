import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {
        try {
            var continents = new ContinentDAO();
            continents.create("Europe");
            Database.getConnection().commit();
            var countries = new CountryDAO();
            int europeId = continents.findByName("Europe");
            countries.create("Romania", europeId);
            countries.create("Ukraine", europeId);
            Database.getConnection().commit();

            //print all the countries in Europe
            Statement stmt = Database.getConnection().createStatement();
            String sql = "SELECT * FROM countries WHERE id_continent=" + europeId;
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int code = rs.getInt("code");
                System.out.println(id + ", " + name + ", " + code);
            }

            Database.closeConnection();

        } catch (SQLException e) {
            System.err.println(e);
            Database.getConnection().rollback();
        }
    }
}