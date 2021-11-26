import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AirplanesSQL {
    public static void main(String[]args) {
        String userName = "root";
        String password = "MaestroBurgers_7";
        String connectionUrl = "jdbc:mysql://localhost:3306/airport";
        try (Connection connection = DriverManager.getConnection
                (connectionUrl, userName, password);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("INSERT INTO airplanes " +
                    "VALUES" +
                    "(NULL, '1234568','Boeing', '16.07.22', '110', '450')," +
                    "(NULL, '1234569','Boeing', '18.09.14', '120', '480')," +
                    "(NULL, '1234570','Boeing', '17.05.14', '120', '500')," +
                    "(NULL, '1234571','Airbus', '19.10.12', '125', '853')," +
                    "(NULL, '1234572','Airbus', '10.06.22', '120', '800')," +
                    "(NULL, '1234573','Boeing', '13.07.08', '120', '500')," +
                    "(NULL, '1234574','Boeing', '20.01.07', '115', '500')," +
                    "(NULL, '1234575','Boeing', '14.04.25', '116', '460')," +
                    "(NULL, '1234576','Airbus', '15.12.30', '135', '750')," +
                    "(NULL, '1234577','Airbus', '19.05.16', '130', '850')" +
                    ";");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
