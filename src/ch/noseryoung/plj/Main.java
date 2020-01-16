package ch.noseryoung.plj;

import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    TrainDepartureAdmin trainDepartureAdmin = new TrainDepartureAdmin();
    Scanner scanner = new Scanner(System.in);
    System.out.println("Press 1 for departures at a specific time" +
            "\nPress 2 for departures on a specific platform" +
            "\nPress 3 for departures to a chosen train station" +
            "\nPress 4 to stop the program");
    String choice = scanner.nextLine();
    switch (choice) {
      case "1":
        System.out.println("Please enter a time (format: HH:mm): ");
        String time = scanner.nextLine();
        System.out.println("\nThese are the departures after " + time + ":\n");
        for (Departure departure : trainDepartureAdmin.getDepartures(time)) {
          System.out.println(departure.getDepartureTime() + " " + departure.getTrainLabel() + " " + departure.getDestination() + " " + departure.getPlatform());
        }
        break;
      case "2":
        System.out.println("\nPlease enter a platform (example: 43):");
        String platform = scanner.nextLine();
        System.out.println("\nPlease enter a time (format: HH:mm): ");
        String timePlatform = scanner.nextLine();
        System.out.println("\nThese are the departures after " + timePlatform + " on platform " + platform + ":\n");
        for (Departure departure : trainDepartureAdmin.getPlatformDepartures(platform, timePlatform)) {
          System.out.println(departure.getDepartureTime() + " " + departure.getTrainLabel() + " " + departure.getDestination() + " " + departure.getPlatform());
        }
        break;
      case "3":
        System.out.println("\nPlease enter a train station (example: Zuerich HB):");
        String city = scanner.nextLine();
        for (Departure departure : trainDepartureAdmin.getDeparturesToCity(city)) {
          System.out.println(departure.getDepartureTime() + " " + departure.getTrainLabel() + " " + departure.getDestination() + " " + departure.getPlatform());
        }
        break;
      case "4":
        System.exit(0);
      default:
        break;
    }

    List<Departure> ka = trainDepartureAdmin.getPlatformDepartures("21", "09:00");
    List<Departure> kaa = trainDepartureAdmin.getDeparturesToCity("Erlenbach ZH");
  }
}
