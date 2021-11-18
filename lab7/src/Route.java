import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Route implements Serializable {
    protected transient int routeID;
    protected String name;
    protected ArrayList<Station> stations;

    public Route() {}

    Route(String data) {
        String[] dataArray = data.split(": ");
        this.routeID = Integer.parseInt(dataArray[0]);
        this.name = dataArray[1];
        this.stations = toStationsList(dataArray[2]);
    }

    private ArrayList<Station> toStationsList(String str) {
        ArrayList<Station> stationsList = new ArrayList<>();
        String[] dataArray = str.split("; ");
        for (String data : dataArray)
            stationsList.add(new Station(data));
        return stationsList;
    }

    public static List<Route> readFileAndReturnRoutesList(String fileName) {
        List<Route> routes = new ArrayList<Route>();
        File file = new File(fileName);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String line = new String(scanner.nextLine());
                routes.add(new Route(line));
            }
            scanner.close();
        } catch(FileNotFoundException e){
            e.printStackTrace();
        }
        return routes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.name + ": ");
        for(Station station : this.stations)
            sb.append(station.toString() + "-");
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}

class Train extends Route implements Serializable{
    String date;
    String time;
    int trainID;

    Train(){}

    Train(String data, List<Route> routes) {
        String[] dataArray = data.split(" ");
        this.date = dataArray[0];
        this.time = dataArray[1];
        this.trainID = Integer.parseInt(dataArray[2]);
        this.routeID = Integer.parseInt(dataArray[3]);
        for (Route route : routes) {
            if (route.routeID == this.routeID) {
                this.name = route.name;
                this.stations = route.stations;
                break;
            }
        }
    }

    public int getTrainID() { return this.trainID; }
    public String getTime() {
        return this.time;
    }
    public String getDate() { return this.date; }
    public String getName() { return this.name; }

    public ArrayList<Station> getStations() { return this.stations; }

    public static List<Train> readFileAndReturnTrainsList(String fileName, List<Route> routes) {
        List<Train> trains = new ArrayList<Train>();
        File file = new File(fileName);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String line = new String(scanner.nextLine());
                trains.add(new Train(line, routes));
            }
            scanner.close();
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        return trains;
    }

    public static List<Train> findTrains(String date, String station, List<Train> trains) throws MyException {
        List<Train> trainsOnDate = new ArrayList<>();
        for(Train train : trains) {
            for(Station station_ : train.stations) {
                if (station.equals(station_.toString()) && date.equals(train.date)) {
                    trainsOnDate.add(train);
                }
            }
        }
        if (trainsOnDate.size() == 0)
            throw new MyException("\n" + "There are no trains on this date" + "\n" +
                    "На эту дату нет поездов" + "\n" + "На гэты дзень няма цягнікоў");
        return trainsOnDate;
    }

    @Override
    public String toString() {
        return this.trainID + " " + this.time + " " + this.name + " " + this.stations.toString();
    }
}
