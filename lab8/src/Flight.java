public class Flight {
    private int flightNumber;
    private String arrivalDate;
    private String departureDate;
    private String pilotSurname;
    private int planeNumber;
    private String brand;
    private int kilometrage;
    private int flightCost;
    private String departurePoint;
    private String arrivalPoint;
    private int refuilingStationsQuantity;
    private int soldTicketsQuantity;
    private int cargoVolume;
    private Pilot pilot;

    public Flight() {}

    Flight(int flightNumber, String arrivalDate, String departureDate, Pilot pilot, Airplane airplane,
           int kilometrage, int flightCost, String departurePoint, String arrivalPoint,
           int refuilingStationsQuantity, int soldTicketsQuantity, int cargoVolume) {
        this.flightNumber = flightNumber; this.arrivalDate = arrivalDate;
        this.departureDate = departureDate; this.pilotSurname = pilot.getSurname();
        this.planeNumber = airplane.getNumber(); this.brand = airplane.getBrand();
        this.kilometrage = kilometrage; this.flightCost = flightCost;
        this.departurePoint = departurePoint; this.arrivalPoint = arrivalPoint;
        this.refuilingStationsQuantity = refuilingStationsQuantity; this.pilot = pilot;
        this.soldTicketsQuantity = soldTicketsQuantity; this.cargoVolume = cargoVolume;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setArrivalPoint(String arrivalPoint) {
        this.arrivalPoint = arrivalPoint;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public void setCargoVolume(int cargoVolume) {
        this.cargoVolume = cargoVolume;
    }

    public void setDeparturePoint(String departurePoint) {
        this.departurePoint = departurePoint;
    }

    public void setFlightCost(int flightCost) {
        this.flightCost = flightCost;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setKilometrage(int kilometrage) {
        this.kilometrage = kilometrage;
    }

    public void setPilotSurname(String pilotSurname) {
        this.pilotSurname = pilotSurname;
    }

    public void setPlaneNumber(int planeNumber) {
        this.planeNumber = planeNumber;
    }

    public void setRefuilingStationsQuantity(int refuilingStationsQuantity) {
        this.refuilingStationsQuantity = refuilingStationsQuantity;
    }

    public void setSoldTicketsQuantity(int soldTicketsQuantity) {
        this.soldTicketsQuantity = soldTicketsQuantity;
    }

    @Override
    public String toString() {
        return "flightNumber=" + flightNumber +
                ", arrivalDate='" + arrivalDate + '\'' +
                ", departureDate='" + departureDate + '\'' +
                ", planeNumber=" + planeNumber +
                ", brand='" + brand + '\'' +
                ", kilometrage=" + kilometrage +
                ", flightCost=" + flightCost +
                ", departurePoint='" + departurePoint + '\'' +
                ", arrivalPoint='" + arrivalPoint + '\'' +
                ", refuilingStationsQuantity=" + refuilingStationsQuantity +
                ", soldTicketsQuantity=" + soldTicketsQuantity +
                ", cargoVolume=" + cargoVolume +
                ", pilot=" + pilot;
    }
}
