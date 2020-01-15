package ch.noseryoung.plj;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Departure {
  private String trainLabel;
  private String departureTime;
  private String destination;
  private String via;
  private String platform;

  public Departure() {
  }

  public Departure(String trainLabel, String departure, String destination, String via, String platform) {
    this.trainLabel = trainLabel;
    this.departureTime = departure;
    this.destination = destination;
    this.via = via;
    this.platform = platform;
  }

  public static List<Departure> extractCsv() throws FileNotFoundException {
    Scanner csvFile = new Scanner(new File("C:\\Work\\Source\\projects-idea\\Fahrplan\\src\\abfahrten_zhb.csv"));
    ArrayList<Departure> departures = new ArrayList<>();
    while (csvFile.hasNextLine()) {
      String[] data = csvFile.nextLine().split(";");
      departures.add(new Departure(data[0], data[1], data[2], data[3], data[4]));
    }
    return departures;
  }


  public boolean isEarlier(String time){
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
    if((LocalTime.parse(this.getDepartureTime(), formatter).compareTo(LocalTime.parse(time, formatter))) > 0){
      return true;
    }
    return false;
  }

  public String getTrainLabel() {
    return trainLabel;
  }

  public void setTrainLabel(String trainLabel) {
    this.trainLabel = trainLabel;
  }

  public String getDepartureTime() {
    return departureTime;
  }

  public void setDepartureTime(String departureTime) {
    this.departureTime = departureTime;
  }

  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }

  public String getVia() {
    return via;
  }

  public void setVia(String via) {
    this.via = via;
  }

  public String getPlatform() {
    return platform;
  }

  public void setPlatform(String platform) {
    this.platform = platform;
  }
}
