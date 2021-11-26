public class Pilot {
    private int id;
    private String surname;
    private int experience;
    private String address;
    private String birthDate;
    private int salary;

    public Pilot() {}

    Pilot (int id, String surname, int experience, String address, String birthDate, int salary) {
        this.id = id;
        this.surname = surname;
        this.experience = experience;
        this.address = address;
        this.birthDate = birthDate;
        this.salary = salary;
    }

    public String getSurname() {
        return surname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "surname='" + surname + '\'' +
                ", experience=" + experience +
                ", address='" + address + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", salary=" + salary;
    }
}
