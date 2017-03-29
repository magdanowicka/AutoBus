package pl.mnowicka.autobus.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by magda on 2017-01-26.
 */
@Entity
@Table(name = "route", schema = "public", catalog = "AutoBus")
public class Route {
    private int id;
    private String departure;
    private String destination;
    private String length;
    private List<ConcreteTravel> concreteTravelsById;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "route_id_generator")
    @SequenceGenerator(name = "route_id_generator", sequenceName = "route_id_seq", initialValue = 2, allocationSize = 1)
    @Column(name = "id", updatable = false, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "departure")
    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    @Basic
    @Column(name = "destination")
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Basic
    @Column(name = "length")
    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Route that = (Route) o;

        if (id != that.id) return false;
        if (departure != null ? !departure.equals(that.departure) : that.departure != null) return false;
        if (destination != null ? !destination.equals(that.destination) : that.destination != null) return false;
        if (length != null ? !length.equals(that.length) : that.length != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (departure != null ? departure.hashCode() : 0);
        result = 31 * result + (destination != null ? destination.hashCode() : 0);
        result = 31 * result + (length != null ? length.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "routeByRouteId")
    public List<ConcreteTravel> getConcreteTravelsById() {
        return concreteTravelsById;
    }

    public void setConcreteTravelsById(List<ConcreteTravel> concreteTravelsById) {
        this.concreteTravelsById = concreteTravelsById;
    }
}
