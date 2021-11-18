/*Агинский Антон Викторович 8 группа лаба 7
8 задача Железнодорожная система

Реализованные классы:
Route - маршрут (все станции маршрута, его идентификационный номер, без даты и времени отправления)
Station - станция (цена, время до станции)
Train - наследуется от Route, содержит дату и время отправления, номер поезда
Ticket - билет, который в конце выводиться на консоль польщователю

MyException - класс с исключениями
TrainsSerialization - сериализация всех поездов
MainFunctions - функции для мэйна
 */


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String [] args) throws MyException {
        List<Route> routes = new ArrayList<>
                (Route.readFileAndReturnRoutesList("Routes.txt"));
        List<Train> trains = new ArrayList<>
                (Train.readFileAndReturnTrainsList("Schedule.txt", routes));

        TrainsSerialization.serializeTrains(trains);
        TrainsSerialization.deserealizeTrains("Trains.bin");

        System.out.println("\n" + "Нажмите 1, если хотите продолжить на русском" + "\n" +
                "Націсніце 2, калі хочаце працягнуць на беларускай" + "\n" +
                "Click 3 if you want to continue in English");
        Scanner sc = new Scanner(System.in);
        String strNumber = sc.nextLine();
        int number = Integer.parseInt(strNumber);
        switch(number) {
            case(1):
                System.out.println("Введите станцию направления");
                sc = new Scanner(System.in);
                String station = sc.nextLine();
                MainFunctions.solutionRu(station, trains);
                break;
            case(2):
                System.out.println("Абярыце станцыю напраўлення");
                sc = new Scanner(System.in);
                station = sc.nextLine();
                MainFunctions.solutionBy(station, trains);
                break;
            case(3):
                System.out.println("Choose the destination station");
                sc = new Scanner(System.in);
                station = sc.nextLine();
                MainFunctions.solutionEn(station, trains);
                break;
            default:
                throw new MyException("Invalid number");
        }
    }
}
