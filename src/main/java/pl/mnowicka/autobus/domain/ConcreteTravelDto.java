package pl.mnowicka.autobus.domain;

import org.hibernate.validator.constraints.NotEmpty;
import pl.mnowicka.autobus.entities.Route;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by magda on 2017-02-25.
 */
public class ConcreteTravelDto {

    @NotNull
    @NotEmpty
    private Date departureTime;

    @NotNull
    @NotEmpty
    private Date arrivalTime;

    private String departureHour;
    private String srrivalHour;

    private String departureDate;
    private String arrivalDate;

    @NotNull
    @NotEmpty
    private Route routeByRouteId;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @NotNull
    @NotEmpty
    private String status;


    public Date getDepartureTime() {
        return departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public String getDepartureHour() {

        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm");
        departureHour = DATE_FORMAT.format(departureTime);
        return departureHour;
    }

    public String getArrivalHour() {

        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm");
        departureHour = DATE_FORMAT.format(arrivalTime);
        return srrivalHour;
    }

    public String getDepartureDate() {

        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("YYYY-MM-dd");
        departureHour = DATE_FORMAT.format(departureTime);
        return departureDate;
    }

    public String getArrivalDate() {

        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("YYYY-MM-dd");
        departureHour = DATE_FORMAT.format(arrivalTime);
        return arrivalDate;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @ManyToOne
    @JoinColumn(name = "route_id", referencedColumnName = "id")
    public Route getRouteByRouteId() {
        return routeByRouteId;
    }

    public void setRouteByRouteId(Route routeByRouteId) {
        this.routeByRouteId = routeByRouteId;
    }


}
