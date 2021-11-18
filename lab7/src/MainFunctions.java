import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MainFunctions {
    private static Map<String, String> makeVocabulary(String fileName, int key, int value) {
        Map<String, String> vocabulary = new HashMap<>();
        File file = new File(fileName);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String line = new String(scanner.nextLine());
                String[] lineArray = line.split("_");
                vocabulary.put(lineArray[key], lineArray[value]);
            }
            scanner.close();
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        return vocabulary;
    }

    private static String searchRussianTranslation(String stationName, Map<String, String> vocabulary) throws MyException {
        if(vocabulary.containsKey(stationName))
            return vocabulary.get(stationName);
        else throw new MyException("There is no station named " + stationName +
                " Такой станцыі няма");
    }

    public static void solutionRu(String stationName, List<Train> trains) throws MyException {
        Station station = new Station();
        Train train = new Train();
        System.out.println("На какую дату искать поезда? Напишите в формате DD.MM.YYYY");
        Scanner sc = new Scanner(System.in);
        String date = sc.nextLine();
        List<Train> trainsOnDate = new ArrayList<>(Train.findTrains(date, stationName, trains));
        for(Train trainOnDate : trainsOnDate)
            System.out.print(trainOnDate.getTime() + " ");
        System.out.println("\n" + "Выберите время отправления");
        sc = new Scanner(System.in);
        String time = sc.nextLine();
        for(Train trainOnDate : trainsOnDate) {
            if(time.equals(trainOnDate.getTime())) {
                train = trainOnDate;
                break;
            }
        }
        for(Station station_ : train.getStations()) {
            if(station_.getStation().equals(stationName))
                station = station_;
        }
        Ticket ticket = new Ticket(train, stationName, time, train.getName(), station.getMinutes(), station.getPrice());
        System.out.println(ticket);
    }

    public static void solutionBy(String stationNameBeforeTranslation, List<Train> trains) throws MyException {
        Station station = new Station();
        Train train = new Train();
        Map<String, String> vocabulary = new HashMap<>
                (makeVocabulary("RussianBelarusian.txt", 1, 0));
        Map<String, String> reverseVocabulary = new HashMap<>
                (makeVocabulary("RussianBelarusian.txt", 0, 1));
        String stationName = new String
                (searchRussianTranslation(stationNameBeforeTranslation, vocabulary));
        System.out.println("На якую дату шукаць цягнікі? Напішыце ў фармаце DD.MM.YYYY");
        Scanner sc = new Scanner(System.in);
        String date = sc.nextLine();
        List<Train> trainsOnDate = new ArrayList<>(Train.findTrains(date, stationName, trains));
        for(Train trainOnDate : trainsOnDate)
            System.out.print(trainOnDate.getTime() + " ");
        System.out.println("\n" + "Абярыце час адпраўлення");
        sc = new Scanner(System.in);
        String time = sc.nextLine();
        for(Train trainOnDate : trainsOnDate) {
            if(time.equals(trainOnDate.getTime())) {
                train = trainOnDate;
                break;
            }
        }
        for(Station station_ : train.getStations()) {
            if(station_.getStation().equals(stationName))
                station = station_;
        }
        String name = new String(reverseVocabulary.get(train.getName()));
        Ticket ticket = new Ticket(train, stationNameBeforeTranslation, time, name, station.getMinutes(), station.getPrice());
        System.out.println(ticket);
    }

    public static void solutionEn(String stationNameBeforeTranslation, List<Train> trains) throws MyException {
        Station station = new Station();
        Train train = new Train();
        Map<String, String> vocabulary = new HashMap<>
                (makeVocabulary("RussianEnglish.txt", 1, 0));
        Map<String, String> reverseVocabulary = new HashMap<>
                (makeVocabulary("RussianEnglish.txt", 0, 1));
        String stationName = new String
                (searchRussianTranslation(stationNameBeforeTranslation, vocabulary));
        System.out.println("On what date you do want to search trains? Write in DD.MM.YYYY format");
        Scanner sc = new Scanner(System.in);
        String date = sc.nextLine();
        List<Train> trainsOnDate = new ArrayList<>(Train.findTrains(date, stationName, trains));
        for(Train trainOnDate : trainsOnDate)
            System.out.print(trainOnDate.getTime() + " ");
        System.out.println("\n" + "Choose the departure time");
        sc = new Scanner(System.in);
        String time = sc.nextLine();
        for(Train trainOnDate : trainsOnDate) {
            if(time.equals(trainOnDate.getTime())) {
                train = trainOnDate;
                break;
            }
        }
        for(Station station_ : train.getStations()) {
            if(station_.getStation().equals(stationName))
                station = station_;
        }
        String name = new String(reverseVocabulary.get(train.getName()));
        Ticket ticket = new Ticket(train, stationNameBeforeTranslation, time, name, station.getMinutes(), station.getPrice());
        System.out.println(ticket + "\n");
    }
}
