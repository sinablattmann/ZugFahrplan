package ch.noseryoung.plj;

import java.io.FileNotFoundException;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class contains all the methods used to get certain Departures
 * @author Sina
 */
public class TrainDepartureAdmin {

  /**
   * This method returns a list of 20 departures after a specific time
   * It takes a String which is the time and loops through the departure data searching for
   * departures that take place after that.
   * @param time  a String with a time in the format HH:mm
   * @return a list with the departures after time
   * @throws DateTimeParseException Exception if time String is in wrong format
   */
  List<Departure> getDepartures(String time) throws DateTimeParseException{
    List<Departure> departuresAtTime = new ArrayList<>();
    try {
      List<Departure> departures = Departure.extractCsv();
      for (Departure departure : departures) {
        if (departure.isLater(time) && departuresAtTime.size() < 21) {
          departuresAtTime.add(departure);
        }
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return departuresAtTime;
  }

  /**
   * This method returns 2 departures on a platform after a specific time.
   * This method first loops through the data and checks if the departure time is after "time"
   * if that's true it loops through the different parts in the data to search for
   * the matching platform.
   * @param platform  a String with the number of the platform
   * @param time  a String with a time in the format HH:mm
   * @return a List with the asked for departures on a platform
   * @throws DateTimeParseException Exception if time String is in wrong format
   */
  List<Departure> getPlatformDepartures(String platform, String time) throws DateTimeParseException{
    List<Departure> departuresOnPlatform = new ArrayList<>();
    try {
      List<Departure> departures = Departure.extractCsv();
      for (Departure departure : departures) {
        if (departure.isLater(time) && departuresOnPlatform.size() < 2) {
          String[] parts = departure.getPlatform().split("\\W");
          for (String part : parts) {
            if (part.equals(platform)) {
              departuresOnPlatform.add(departure);
              break;
            }
          }
        }
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return departuresOnPlatform;
  }

  /**
   * This method returns all the Departures going to a city
   * This method loops through the data and gets all the Via cities separately and loops
   * through them to search for the "city". If the departure contains the city it adds it to the list.
   * @param city  a String with the city
   * @return a List with all the Departures to the specific city
   */
  List<Departure> getDeparturesToCity(String city) {
    List<Departure> departuresToCity = new ArrayList<>();
    try {
      List<Departure> departures = Departure.extractCsv();
      for (Departure departure : departures) {
        String[] parts = departure.getVia().split("- ");
        for (String part : parts) {
          if (part.equals(city)) {
            departuresToCity.add(departure);
            break;
          }
        }
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return departuresToCity;
  }
}
