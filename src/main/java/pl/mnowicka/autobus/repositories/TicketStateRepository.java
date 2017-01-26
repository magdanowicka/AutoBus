package pl.mnowicka.autobus.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.mnowicka.autobus.entities.TicketState;

/**
 * Created by magda on 2017-01-24.
 */
@Repository
public interface TicketStateRepository extends CrudRepository<TicketState, Long> {
}
