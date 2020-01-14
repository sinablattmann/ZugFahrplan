package ch.noseryoung.plj;

import java.time.LocalDate;

public class TrainDepartureAdmin {
    private String trainLabel;
    private LocalDate departureTime;
    private String destination;
    private String via;
    private String pltaform;

    public TrainDepartureAdmin() {
    }

    public TrainDepartureAdmin(String trainLabel, LocalDate departure, String destination, String via, String pltaform) {
        this.trainLabel = trainLabel;
        this.departureTime = departure;
        this.destination = destination;
        this.via = via;
        this.pltaform = pltaform;
    }

    public String getTrainLabel() {
        return trainLabel;
    }

    public void setTrainLabel(String trainLabel) {
        this.trainLabel = trainLabel;
    }

    public LocalDate getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDate departureTime) {
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

    public String getPltaform() {
        return pltaform;
    }

    public void setPltaform(String pltaform) {
        this.pltaform = pltaform;
    }
}
