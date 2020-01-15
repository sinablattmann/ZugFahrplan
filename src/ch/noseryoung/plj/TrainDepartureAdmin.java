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
        if (departure.isEarlier(time)) {
          departures.add(departure);
          counter++;
          if (counter > 19) {
            break;
          }
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
        if (departure.isEarlier(time) && departure.getPlatform().equals(platform)) {
          departuresOnPlatform.add(departure);
          counter++;
        }
        if (counter > 1) {
          break;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return departuresOnPlatform;
  }

  List<Departure> getDeparturesToCity(String city) {
    return new ArrayList<>();
  }
}
