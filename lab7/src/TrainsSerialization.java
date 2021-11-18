import java.io.*;
import java.util.List;

public class TrainsSerialization {
    public static void serializeTrains(List<Train> trains)
    {
        try {
            FileOutputStream fos = new FileOutputStream("Trains.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(trains);
            oos.close();
            fos.close();
        } catch (IOException ioe) {
                ioe.printStackTrace();
        }
    }

    public static void deserealizeTrains(String fileName) {
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<Train> trains = (List<Train>) ois.readObject();
            for(Train train : trains) {
                System.out.println(train);
            }
        } catch (FileNotFoundException fnfex) {
            fnfex.printStackTrace();
        } catch (IOException ioex) {
            ioex.printStackTrace();
        } catch (ClassNotFoundException ccex) {
            ccex.printStackTrace();
        }
    }
}
