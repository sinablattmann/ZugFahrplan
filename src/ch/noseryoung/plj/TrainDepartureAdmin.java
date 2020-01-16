package ch.noseryoung.plj;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class TrainDepartureAdmin {

  List<Departure> getDepartures(String time) {
    List<Departure> departuresAtTime = new ArrayList<>();
    try {
      int counter = 0;
      List<Departure> departures = Departure.extractCsv();
      for (Departure departure : departures) {
        if (departure.isLater(time) && counter < 20) {
          departuresAtTime.add(departure);
          counter++;
        }
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return departuresAtTime;
  }

  List<Departure> getPlatformDepartures(String platform, String time) {
    List<Departure> departuresOnPlatform = new ArrayList<>();
    try {
      List<Departure> departures = Departure.extractCsv();
      int counter = 0;
      for (Departure departure : departures) {
        if (departure.isLater(time) && counter < 2) {
          String[] parts = departure.getPlatform().split("\\W");
          for (String part : parts) {
            if (part.equals(platform)) {
              departuresOnPlatform.add(departure);
              counter++;
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
