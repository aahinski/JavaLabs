import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class FlightsSQL {
    public static void main(String[]args) {
        String userName = "root";
        String password = "MaestroBurgers_7";
        String connectionUrl = "jdbc:mysql://localhost:3306/airport";
        try (Connection connection = DriverManager.getConnection
                (connectionUrl, userName, password);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("INSERT INTO flights " +
                    "VALUES" +
                    "(1, '12345','21.07.21', '21.07.21', '800', '100000', 'Minsk', 'Moscow', '0', '400', NULL, '1', '1')," +
                    "(NULL, '12346','21.09.15', '21.09.14', '7000', '400000', 'Minsk', 'New York', '2', NULL, '100', '2', '2')," +
                    "(NULL, '12347','21.05.14', '21.05.14', '600', '80000', 'Warsaw', 'Minsk', '0', '480', NULL, '3', '3')," +
                    "(NULL, '12348','21.10.13', '21.10.12', '4000', '275000', 'Vladivostok', 'Minsk', '1', '400', NULL, '4', '4')," +
                    "(NULL, '12349','21.06.22', '21.06.22', '1000', '140000', 'Minsk', 'Copenhagen', '0', NULL, '125', '5', '5')," +
                    "(NULL, '12350','21.07.09', '21.07.08', '4000', '300000', 'Beijing', 'Minsk', '1', '800', NULL, '6', '6')," +
                    "(NULL, '12351','21.01.07', '21.01.07', '200', '60000', 'Minsk', 'Vilnius', '0', '500', NULL, '7', '7')," +
                    "(NULL, '12352','21.04.27', '21.04.25', '6000', '350000', 'Minsk', 'Shanhay', '2', '500', NULL, '8', '8')," +
                    "(NULL, '12353','21.12.31', '21.12.30', '5500', '300000', 'Minsk', 'Bangkok', '2', NULL, '125', '9', '9')," +
                    "(NULL, '12354','21.05.16', '21.05.16', '1000', '150000', 'Paris', 'Minsk', '1', '700', NULL, '10', '10')" +
                    ";");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
