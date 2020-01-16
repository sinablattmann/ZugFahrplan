package ch.noseryoung.plj;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class contains all the methods used to get certain Departures
 * @author Sina
 */
public class TrainDepartureAdmin {

  /**
   * This method returns a list of 20 departures at a specific time
   * @param time  a String with a time in the format HH:mm
   * @return a list with the departures after time
   */
  List<Departure> getDepartures(String time) {
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
   * This method returns 2 departures on a platform at a specific time
   * @param platform  a String with the number of the platform
   * @param time  a String with a time in the format HH:mm
   * @return a List with the asked for departures on a platform
   */
  List<Departure> getPlatformDepartures(String platform, String time) {
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
    } catch (Exception e) {
      e.printStackTrace();
    }
    return departuresOnPlatform;
  }

  /**
   * This method returns all the Departures going to a city
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
