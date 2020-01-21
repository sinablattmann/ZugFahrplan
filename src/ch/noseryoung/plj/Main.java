package ch.noseryoung.plj;

import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

/**
 * The Main class
 *
 * @author Sina
 */
public class Main {
  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    TrainDepartureAdmin trainDepartureAdmin = new TrainDepartureAdmin();
    Scanner scanner = new Scanner(System.in);
    String choice = "1";
    do {
      System.out.println("Menu" +
              "\n---------------------");
      System.out.println("1 see departures at a specific time" +
              "\n2 see departures on specific platform" +
              "\n3 see departures which pass a certain train station" +
              "\n4 exit program");
      System.out.print("> ");
      choice = scanner.nextLine();
      switch (choice) {
        case "1":
          do {
            System.out.print("Please enter a time (format: HH:mm): ");
            String time = scanner.nextLine();
            try {
              List<Departure> departures = trainDepartureAdmin.getDepartures(time);
              System.out.println("\nThese are the departures after " + time + ":\n");
              for (Departure departure : departures) {
                System.out.println(departure.getDepartureTime() + " " + departure.getTrainLabel() + " " + departure.getDestination() + " " + departure.getPlatform());
              }
              break;
            } catch (DateTimeParseException e) {
              System.out.println("You have entered a wrong time format, please try again");
            }
          } while (true);

          break;
        case "2":
          System.out.print("\nPlease enter a platform (example: 43):");
          String platform = scanner.nextLine();

          do {
            System.out.print("\nPlease enter a time (format: HH:mm): ");
            String timePlatform = scanner.nextLine();
            try {
              List<Departure> platformDepartures = trainDepartureAdmin.getPlatformDepartures(platform, timePlatform);
              System.out.println("\nThese are the departures after " + timePlatform + " on platform " + platform + ":\n");
              for (Departure departure : platformDepartures) {
                System.out.println(departure.getDepartureTime() + " " + departure.getTrainLabel() + " " + departure.getDestination() + " " + departure.getPlatform());
              }
              break;
            } catch (DateTimeParseException e) {
              System.out.println("You have entered a wrong time format, please try again");
            }
          } while (true);
          break;
        case "3":
          System.out.print("\nPlease enter a train station (example: Zuerich HB):");
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
    }while(true);
  }
}
