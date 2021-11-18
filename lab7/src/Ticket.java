import java.util.Date;

public class Ticket {
    private Train train;
    private String name;
    private String station;
    private String arrivalTime;
    private double price;

    Ticket() {}

    private String calculateArrivalTime(String departureTime,int time) {
        int minutes = Integer.parseInt(departureTime.substring(3, 5)) + time;
        int hours = Integer.parseInt(departureTime.substring(0, 2));
        if(minutes > 60) {
            minutes = minutes - 60;
            hours = hours + 1;
            Integer hrs = hours;
            Integer min = minutes;
            StringBuilder sb = new StringBuilder(hrs.toString() + ":" + min.toString());
            return sb.toString();
        } else if(minutes == 60) {
            hours = hours + 1;
            Integer hrs = hours;
            StringBuilder sb = new StringBuilder(hrs.toString() + ":00");
            return sb.toString();
        } else {
            Integer hrs = hours;
            Integer min = minutes;
            StringBuilder sb = new StringBuilder(hrs.toString() + ":" + min.toString());
            return sb.toString();
        }
    }

    Ticket(Train train, String station, String departureTime, String name, int time, double price) {
        this.train = train;
        this.station = station;
        this.arrivalTime = calculateArrivalTime(departureTime, time);
        this.price = price;
        this.name = name;
        Date date = new Date();
        System.out.println(date);
    }

    @Override
    public String toString() {
        return this.train.getTrainID() + " " + this.train.getDate() + " " + this.train.getTime() +
                " " + this.name + "\n" + this.arrivalTime + " " + this.station + " " + this.price;
    }
}
