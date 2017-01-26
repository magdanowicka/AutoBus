package pl.mnowicka.autobus.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by magda on 2017-01-26.
 */
@Entity
@Table(name = "ticket_state", schema = "public", catalog = "AutoBus")
public class TicketState {
    private String status;
    private List<Ticket> ticketsByStatus;

    @Id
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TicketState that = (TicketState) o;

        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return status != null ? status.hashCode() : 0;
    }

    @OneToMany(mappedBy = "ticketStateByStatus")
    public List<Ticket> getTicketsByStatus() {
        return ticketsByStatus;
    }

    public void setTicketsByStatus(List<Ticket> ticketsByStatus) {
        this.ticketsByStatus = ticketsByStatus;
    }
}
