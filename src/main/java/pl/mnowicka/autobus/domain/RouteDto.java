package pl.mnowicka.autobus.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by magda on 2017-02-23.
 */
public class RouteDto {

    @NotNull
    @NotEmpty
    private String departure;

    @NotNull
    @NotEmpty
    private String destination;

    @NotNull
    @NotEmpty
    private String length;


    private boolean selected;


    public String getDeparture() {
        return departure;
    }

    public String getDestination() {
        return destination;
    }

    public String getLength() {
        return length;
    }

    public boolean isSelected() { return selected; }


    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public void setSelected(boolean selected) { this.selected = selected; }

}
