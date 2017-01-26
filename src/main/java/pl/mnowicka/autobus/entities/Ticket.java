package pl.mnowicka.autobus.entities;

import javax.persistence.*;

/**
 * Created by magda on 2017-01-26.
 */
@Entity
@Table(name = "ticket", schema = "public", catalog = "AutoBus")
public class Ticket {
    private int id;
    private int travelId;
    private int userId;
    private int seatNumber;
    private double price;
    private String status;
    private ConcreteTravel concreteTravelByTravelId;
    private User userByUserId;
    private TicketState ticketStateByStatus;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    @Basic
//    @Column(name = "travel_id")
//    public int getTravelId() {
//        return travelId;
//    }
//
//    public void setTravelId(int travelId) {
//        this.travelId = travelId;
//    }
//
//    @Basic
//    @Column(name = "user_id")
//    public int getUserId() {
//        return userId;
//    }
//
//    public void setUserId(int userId) {
//        this.userId = userId;
//    }

    @Basic
    @Column(name = "seat_number")
    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    @Basic
    @Column(name = "price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

//    @Basic
//    @Column(name = "status")
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket that = (Ticket) o;

        if (id != that.id) return false;
        if (travelId != that.travelId) return false;
        if (userId != that.userId) return false;
        if (seatNumber != that.seatNumber) return false;
        if (Double.compare(that.price, price) != 0) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + travelId;
        result = 31 * result + userId;
        result = 31 * result + seatNumber;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "travel_id", referencedColumnName = "id", nullable = false)
    public ConcreteTravel getConcreteTravelByTravelId() {
        return concreteTravelByTravelId;
    }

    public void setConcreteTravelByTravelId(ConcreteTravel concreteTravelByTravelId) {
        this.concreteTravelByTravelId = concreteTravelByTravelId;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "status", referencedColumnName = "status", nullable = false)
    public TicketState getTicketStateByStatus() {
        return ticketStateByStatus;
    }

    public void setTicketStateByStatus(TicketState ticketStateByStatus) {
        this.ticketStateByStatus = ticketStateByStatus;
    }
}
