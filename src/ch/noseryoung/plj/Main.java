package ch.noseryoung.plj;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    TrainDepartureAdmin trainDepartureAdmin = new TrainDepartureAdmin();
    List<Departure> ka = trainDepartureAdmin.getPlatformDepartures("12", "09:00");
  }
}
