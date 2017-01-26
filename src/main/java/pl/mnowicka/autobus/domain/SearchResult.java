package pl.mnowicka.autobus.domain;

import java.util.Date;

/**
 * Created by magda on 2017-01-22.
 */

public class SearchResult {

    private String from;
    private String to;
    private Date departure;
    private Date arrival;
    private int freeSeats;
    private String price;

    public SearchResult() {

    }

    public SearchResult(String from, String to, Date departure, Date arrival, int freeSeats, String price) {
        this.from = from;
        this.to = to;
        this.departure = departure;
        this.arrival = arrival;
        this.freeSeats = freeSeats;
        this.price = price;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Date getDeparture() {
        return departure;
    }

    public void setDeparture(Date departure) {
        this.departure = departure;
    }

    public Date getArrival() {
        return arrival;
    }

    public void setArrival(Date arrival) {
        this.arrival = arrival;
    }

    public int getFreeSeats() {
        return freeSeats;
    }

    public void setFreeSeats(int freeSeats) {
        this.freeSeats = freeSeats;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
