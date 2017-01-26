package pl.mnowicka.autobus.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by magda on 2017-01-26.
 */
@Entity
@Table(name = "concrete_travel", schema = "public", catalog = "AutoBus")
public class ConcreteTravel {
    private int id;
    private Serializable departureTime;
    private Serializable arrivalTime;
    private String status;
    private Integer routeId;
    private Route routeByRouteId;
    private List<Ticket> ticketsById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "departure_time")
    public Serializable getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Serializable departureTime) {
        this.departureTime = departureTime;
    }

    @Basic
    @Column(name = "arrival_time")
    public Serializable getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Serializable arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

//    @Basic
//    @Column(name = "route_id")
//    public Integer getRouteId() {
//        return routeId;
//    }
//
//    public void setRouteId(Integer routeId) {
//        this.routeId = routeId;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConcreteTravel that = (ConcreteTravel) o;

        if (id != that.id) return false;
        if (departureTime != null ? !departureTime.equals(that.departureTime) : that.departureTime != null)
            return false;
        if (arrivalTime != null ? !arrivalTime.equals(that.arrivalTime) : that.arrivalTime != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (routeId != null ? !routeId.equals(that.routeId) : that.routeId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (departureTime != null ? departureTime.hashCode() : 0);
        result = 31 * result + (arrivalTime != null ? arrivalTime.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (routeId != null ? routeId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "route_id", referencedColumnName = "id")
    public Route getRouteByRouteId() {
        return routeByRouteId;
    }

    public void setRouteByRouteId(Route routeByRouteId) {
        this.routeByRouteId = routeByRouteId;
    }

    @OneToMany(mappedBy = "concreteTravelByTravelId")
    public List<Ticket> getTicketsById() {
        return ticketsById;
    }

    public void setTicketsById(List<Ticket> ticketsById) {
        this.ticketsById = ticketsById;
    }
}
