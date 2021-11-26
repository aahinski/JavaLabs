import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FunctionsForMain {
    public static List<Pilot> getAllPilots() throws ClassNotFoundException, SQLException {
        String userName = "root";
        String password = "MaestroBurgers_7";
        String connectionUrl = "jdbc:mysql://localhost:3306/airport";
        try (Connection connection = DriverManager.getConnection
                (connectionUrl, userName, password); Statement statement = connection.createStatement()) {
            String sql = "Select * From pilots";
            ResultSet rst;
            rst = statement.executeQuery(sql);
            List<Pilot> pilotsList = new ArrayList<>();
            while (rst.next()) {
                Pilot pilot = new Pilot(rst.getInt("id"), rst.getString("surname"),
                        rst.getInt("experience"), rst.getString("address"),
                        rst.getString("birthDate"), rst.getInt("salary"));
                pilotsList.add(pilot);
            }
            return pilotsList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
    public static List<Airplane> getAllAirplanes() throws ClassNotFoundException, SQLException {
        String userName = "root";
        String password = "MaestroBurgers_7";
        String connectionUrl = "jdbc:mysql://localhost:3306/airport";
        try (Connection connection = DriverManager.getConnection
                (connectionUrl, userName, password); Statement statement = connection.createStatement()) {
            String sql = "Select * From airplanes";
            ResultSet rst;
            rst = statement.executeQuery(sql);
            List<Airplane> airplanesList = new ArrayList<>();
            while (rst.next()) {
                Airplane airplane = new Airplane(rst.getInt("id"), rst.getInt("number"),
                        rst.getString("brand"), rst.getString("releaseDate"),
                        rst.getInt("loadCapacity"), rst.getInt("peopleCapacity"));
                airplanesList.add(airplane);
            }
            return airplanesList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    private static Pilot searchPilotByID(int id, List<Pilot> pilots) {
        Pilot foundPilot = new Pilot();
        for (Pilot pilot : pilots) {
            if (id == pilot.getId()) {
                foundPilot = pilot;
            }
        }
        return foundPilot;
    }

    private static Airplane searchAirplaneByID(int id, List<Airplane> airplanes) {
        Airplane foundAirplane = new Airplane();
        for (Airplane airplane : airplanes) {
            if (id == airplane.getId()) {
                foundAirplane = airplane;
            }
        }
        return foundAirplane;
    }

    public static List<Flight> getAllFlights(List<Pilot> pilots, List<Airplane> airplanes) throws ClassNotFoundException, SQLException {
        String userName = "root";
        String password = "MaestroBurgers_7";
        String connectionUrl = "jdbc:mysql://localhost:3306/airport";
        try (Connection connection = DriverManager.getConnection
                (connectionUrl, userName, password); Statement statement = connection.createStatement()) {
            String sql = "Select * From flights";
            ResultSet rst;
            rst = statement.executeQuery(sql);
            List<Flight> airplanesList = new ArrayList<>();
            while (rst.next()) {
                Flight flight = new Flight(rst.getInt("flightNumber"), rst.getString("arrivalDate"),
                        rst.getString("departureDate"), searchPilotByID(rst.getInt("pilotID"), pilots),
                        searchAirplaneByID(rst.getInt("airplaneID"), airplanes), rst.getInt("kilometrage"),
                        rst.getInt("flightCost"), rst.getString("departurePoint"), rst.getString
                        ("arrivalPoint"), rst.getInt("refuilingStationsQuantity"), rst.getInt
                        ("soldTicketsQuantity"), rst.getInt("cargoVolume"));
                airplanesList.add(flight);
            }
            return airplanesList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public static Flight searchFlightByNumber(int number, List<Flight> flights) {
        Flight foundFlight = new Flight();
        for (Flight flight : flights) {
            if (number == flight.getFlightNumber()) {
                foundFlight = flight;
            }
        }
        return foundFlight;
    }

    public static List<User> getAllUsers() throws ClassNotFoundException, SQLException {
        String userName = "root";
        String password = "MaestroBurgers_7";
        String connectionUrl = "jdbc:mysql://localhost:3306/airport";
        try (Connection connection = DriverManager.getConnection
                (connectionUrl, userName, password); Statement statement = connection.createStatement()) {
            String sql = "Select * From users";
            ResultSet rst;
            rst = statement.executeQuery(sql);
            List<User> users = new ArrayList<>();
            while (rst.next()) {
                User user = new User(rst.getInt("id"), rst.getString("login"),
                        rst.getString("password"));
                users.add(user);
            }
            return users;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public static boolean authorization(List<User> users, String login, String password) {
        for (User user : users) {
            if (login.equals(user.getLogin()) && UsersSQL.encrypte
                    (password, "1010110001011100").equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }
}
