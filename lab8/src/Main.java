import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[]args) throws SQLException, ClassNotFoundException, MyException {
        System.out.println("Enter your login");
        Scanner sc = new Scanner(System.in);
        String login = sc.nextLine();
        System.out.println("Enter your password");
        sc = new Scanner(System.in);
        String password = sc.nextLine();
        List<User> users = new ArrayList<>(FunctionsForMain.getAllUsers());
        if(FunctionsForMain.authorization(users, login, password) == true) {
            List<Airplane> airplanes = new ArrayList<>(FunctionsForMain.getAllAirplanes());
            List<Pilot> pilots = new ArrayList<>(FunctionsForMain.getAllPilots());
            List<Flight> flights = new ArrayList<>(FunctionsForMain.getAllFlights(pilots, airplanes));
            System.out.println("Enter flight number");
            sc = new Scanner(System.in);
            String flightNumberStr = sc.nextLine();
            int flightNumber = Integer.parseInt(flightNumberStr);
            System.out.println(FunctionsForMain.searchFlightByNumber(flightNumber, flights));
        }
        else throw new MyException("Invalid login or password");
    }
}
