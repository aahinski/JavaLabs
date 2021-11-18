import java.io.Serializable;

public class Station implements Serializable {
    private String station;
    private int minutes;
    private double price;

    Station() {}

    Station(String data) {
        String[] dataArray = data.split(", ");
        this.station = dataArray[0];
        this.minutes = Integer.parseInt(dataArray[1]);
        this.price = Double.parseDouble(dataArray[2]);
    }

    public int getMinutes() { return this.minutes; }
    public double getPrice() { return this.price; }
    public String getStation() { return this.station; }

    @Override
    public String toString() {
        return this.station;
    }
}
