import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PilotsSQL {
    public static void main(String[]args) {
        String userName = "root";
        String password = "MaestroBurgers_7";
        String connectionUrl = "jdbc:mysql://localhost:3306/airport";
        try (Connection connection = DriverManager.getConnection
                (connectionUrl, userName, password);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("INSERT INTO pilots " +
                    "VALUES" +
                    "(1, 'Ahinski', 'Minsk, Esenina 9-20', '90.01.30', '3', '5000')," +
                    "(NULL, 'Kuznetsou','Minsk, Ignatovskogo 5-36', '90.07.01', '4', '4500')," +
                    "(NULL, 'Malieu','Minsk, Churlionisa 25-77', '88.08.31', '3', '4800')," +
                    "(NULL, 'Mavrodi','Moscow, Vagankovskoye 4', '65.05.14', '20', '8000')," +
                    "(NULL, 'Reid','LA, Fiveinone 67', '87.10.12', '5', '5500')," +
                    "(NULL, 'Holland','Dortmund, Psycho 56-89', '92.06.22', '1', '3500')," +
                    "(NULL, 'Evra','Marseille, Chicken 78-8', '80.08.24', '10', '6000')," +
                    "(NULL, 'Dorokhov','Samara, Shalfeeva 9-7', '85.01.07', '5', '5000')," +
                    "(NULL, 'Rhoades','New York, Heart 76', '90.04.25', '2', '4000')," +
                    "(NULL, 'Jean','Chicago, Blacked 7-78', '92.12.30', '1', '2900')," +
                    "(NULL, 'Kushanashvili','Kutaisi, Kashchenko, 56-78', '63.05.16', '30', '10000')" +
                    ";");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
