package ch.noseryoung.plj;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class represents a Departure from a train station
 *
 * @author Sina
 */
public class Departure {
  private String trainLabel;
  private String departureTime;
  private String destination;
  private String via;
  private String platform;

  /**
   * Instantiates a new Departure.
   */
  public Departure() {
  }

  /**
   * Instantiates a new Departure.
   *
   * @param trainLabel  the train label
   * @param departure   the departure
   * @param destination the destination
   * @param via         the via
   * @param platform    the platform
   */
  public Departure(String trainLabel, String departure, String destination, String via, String platform) {
    this.trainLabel = trainLabel;
    this.departureTime = departure;
    this.destination = destination;
    this.via = via;
    this.platform = platform;
  }

  /**
   * This method extracts data from a CSV file
   *
   * @return a List with all the data from the CSV as Departures
   * @throws FileNotFoundException if the file can't be found, this gets thrown
   */
  public static List<Departure> extractCsv() throws FileNotFoundException {
    Scanner csvFile = new Scanner(new File("src/abfahrten_zhb.csv"));
    ArrayList<Departure> departures = new ArrayList<>();
    while (csvFile.hasNextLine()) {
      String[] data = csvFile.nextLine().split(";");
      departures.add(new Departure(data[0], data[1], data[2], data[3], data[4]));
    }
    return departures;
  }

  /**
   * Checks if the parameter is before or after the Departure
   *
   * @param time a String with the time in the format HH:mm
   * @return true if the parameter is earlier than the Departure, false if the parameter is later than the Departure
   * @throws DateTimeParseException Exception if time String is in wrong format
   */
  public boolean isLater(String time) throws DateTimeParseException {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
    if((LocalTime.parse(this.getDepartureTime(), formatter).compareTo(LocalTime.parse(time, formatter))) > 0){
      return true;
    }
    return false;
  }

  /**
   * Gets train label.
   *
   * @return the train label
   */
  public String getTrainLabel() {
    return trainLabel;
  }

  /**
   * Sets train label.
   *
   * @param trainLabel the train label
   * @return the train label
   */
  public Departure setTrainLabel(String trainLabel) {
    this.trainLabel = trainLabel;
    return this;
  }

  /**
   * Gets departure time.
   *
   * @return the departure time
   */
  public String getDepartureTime() {
    return departureTime;
  }

  /**
   * Sets departure time.
   *
   * @param departureTime the departure time
   * @return the departure time
   */
  public Departure setDepartureTime(String departureTime) {
    this.departureTime = departureTime;
    return this;
  }

  /**
   * Gets destination.
   *
   * @return the destination
   */
  public String getDestination() {
    return destination;
  }

  /**
   * Sets destination.
   *
   * @param destination the destination
   * @return the destination
   */
  public Departure setDestination(String destination) {
    this.destination = destination;
    return this;
  }

  /**
   * Gets via.
   *
   * @return the via
   */
  public String getVia() {
    return via;
  }

  /**
   * Sets via.
   *
   * @param via the via
   * @return the via
   */
  public Departure setVia(String via) {
    this.via = via;
    return this;
  }

  /**
   * Gets platform.
   *
   * @return the platform
   */
  public String getPlatform() {
    return platform;
  }

  /**
   * Sets platform.
   *
   * @param platform the platform
   * @return the platform
   */
  public Departure setPlatform(String platform) {
    this.platform = platform;
    return this;
  }
}
