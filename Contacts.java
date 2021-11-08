//Агинский Антон 8 группа
//Лаба 5
//Свое решение задачи "Контакты"

package ContactsTask;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contacts implements Iterator<String>, Iterable<String>, Comparable<Contacts> {
    private String name, cellPhone, workPhone, homePhone, email, webpage, address;
    private String[] DataArray = new String[7];

    //Конструкторы
    public Contacts(String name, String cellPhone) {
        this.setName(name);
        this.setCellPhone(cellPhone);
        for (int i = 2; i < dataGetters.length; i++) {
            setData(i, "");
        }
    }

    public Contacts(String name, String cellPhone, String workPhone,
                    String homePhone, String email, String webpage, String address)
    {
        this.setName(name); this.setCellPhone(cellPhone); this.setWorkPhone(workPhone);
        this.setHomePhone(homePhone); this.setEmail(email); this.setWebpage(webpage);
        this.setAddress(address);
    }

    public Contacts(String data) {
        String[] dataArray = data.split("[, ]");
        int i = 0;
        while(i < dataArray.length) {
            setData(i, dataArray[i]);
            i++;
        }
        if(i < 7) {
            while (i < 7) {
                setData(i, "");
                i++;
            }
        }
    }

    //Сеттеры и проверка переданной строчки на валидность
    public void setName(String name) {
        if(name.equals("")) {
            System.out.println("First field is required");
            System.exit(1);
        } else {
            this.name = name;
        }
    }

    public void setCellPhone(String cellPhone) {
        Pattern pattern = Pattern.compile("^(\\+375|80)(29|25|44|33)(\\d{3})(\\d{2})(\\d{2})$");
        Matcher matcher = pattern.matcher(cellPhone);
        if (matcher.find()) {
            this.cellPhone = cellPhone;
        } else {
            System.out.println("First field is required");
            System.exit(1);
        }
    }

    public void setWorkPhone(String workPhone) {
        Pattern pattern = Pattern.compile(
                "^(\\+375|80)(29|25|44|33)(\\d{3})(\\d{2})(\\d{2})$");
        Matcher matcher = pattern.matcher(workPhone);
        if (matcher.find()) {
            this.workPhone = workPhone;
        } else {
            this.workPhone = "";
        }
    }

    public void setHomePhone(String homePhone) {
        Pattern pattern = Pattern.compile(
                "^(80)(17)(\\d{3})(\\d{2})(\\d{2})$");
        Matcher matcher = pattern.matcher(homePhone);
        if (matcher.find()) {
            this.homePhone = homePhone;
        } else {
            this.homePhone = "";
        }
    }

    public void setEmail(String email) {
        Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$"
                , Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        if (matcher.find()) {
            this.email = email;
        } else {
            this.email = "";
        }
    }

    public void setWebpage(String webpage) {
        Pattern pattern = Pattern.compile(
                "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]$"
                , Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(webpage);
        if (matcher.find()) {
            this.webpage = webpage;
        } else {
            this.webpage = "";
        }
    }

    public void setAddress(String address) {
        Pattern pattern = Pattern.compile("^[A-Za-z0-9]$");
        Matcher matcher = pattern.matcher(address);
        if (matcher.find()) {
            this.address = address;
        } else {
            this.webpage = "";
        }
    }

    interface DataSetter {
        void setData(String data);
    }

    private DataSetter[] dataSetters = new DataSetter[] {
            new DataSetter() { public void setData(String data) { setName(data); } },
            new DataSetter() { public void setData(String data) { setCellPhone(data); } },
            new DataSetter() { public void setData(String data) { setWorkPhone(data); } },
            new DataSetter() { public void setData(String data) { setHomePhone(data); } },
            new DataSetter() { public void setData(String data) { setEmail(data); } },
            new DataSetter() { public void setData(String data) { setWebpage(data); } },
            new DataSetter() { public void setData(String data) { setAddress(data); } },
    };

    //Метод для изменения какого-то поля по номеру
    public void setData(int index, String data) {
        dataSetters[index].setData(data);
    }

    //Геттеры
    public String getName() {return this.name;}
    public String getCellPhone() {return this.cellPhone;}
    public String getWorkPhone() {return this.workPhone;}
    public String getHomePhone() {return this.homePhone;}
    public String getEmail() {return this.email;}
    public String getWebpage() {return this.webpage;}
    public String getAddress() {return this.address;}

    interface DataGetter {
        String getData();
    }

    private DataGetter[] dataGetters = new DataGetter[] {
            new DataGetter() { public String getData() { return getName(); } },
            new DataGetter() { public String getData() { return getCellPhone(); } },
            new DataGetter() { public String getData() { return getWorkPhone(); } },
            new DataGetter() { public String getData() { return getHomePhone(); } },
            new DataGetter() { public String getData() { return getEmail(); } },
            new DataGetter() { public String getData() { return getWebpage(); } },
            new DataGetter() { public String getData() { return getAddress(); } },
    };

    //Метод для доступа к полю по номеру
    private String getData(int index) {
        String data = dataGetters[index].getData();
        return data;
    }

    //Итератор
    private int pos = 0;

    public void reset() {
        pos = 0;
    }

    @Override
    public boolean hasNext() {
        return pos < dataGetters.length;
    }

    @Override
    public String next() {
        return (getData(pos++));
    }

    @Override
    public Iterator<String> iterator() {
        reset();
        return this;
    }

    ////////////
    @Override
    public String toString() {
        return  "name='" + name + '\'' +
                ", cellPhone='" + cellPhone + '\'' +
                ", workPhone='" + workPhone + '\'' +
                ", homePhone='" + homePhone + '\'' +
                ", email='" + email + '\'' +
                ", webpage='" + webpage + '\'';
    }

    //Компаратор
    public static Comparator<Contacts> getComparator(int index) {
        if ( index >= 7 || index < 0 ) {
            throw new IndexOutOfBoundsException();
        }
        return new Comparator<Contacts> () {
            @Override
            public int compare(Contacts user1, Contacts user2) {
                return user1.getData(index).compareTo(user2.getData((index)));
            }
        };
    }

    @Override
    public int compareTo(Contacts user) {
        return this.getData(0).compareTo(user.getData(0));
    }

    //Функции печати
    public static void printUser(Contacts user) {
        System.out.println(user.toString());
    }

    private static String[] fields = {"Name", "CellPhone", "WorkPhone",
            "HomePhone", "Email", "Web Page", "Address"};

    public static void printSorted(Contacts[] users, int index) {
        System.out.println( "Sorted by " + Contacts.fields[index] + " :");
        Arrays.sort(users, Contacts.getComparator(index));
        for(Contacts user : users) {
            printUser(user);
        }
    }
}
