public class Airplane {
    private int id;
    private int number;
    private String brand;
    private String releaseDate;
    private int loadCapacity;
    private int peopleCapacity;

    Airplane(){}

    Airplane(int id, int number, String brand, String releaseDate, int loadCapacity, int peopleCapacity) {
        this.id = id;
        this.number = number;
        this.brand = brand;
        this.releaseDate = releaseDate;
        this.loadCapacity = loadCapacity;
        this.peopleCapacity = peopleCapacity;
    }

    public int getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setPeopleCapacity(int peopleCapacity) {
        this.peopleCapacity = peopleCapacity;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
