package pl.mnowicka.autobus.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.mnowicka.autobus.entities.ConcreteTravel;
import pl.mnowicka.autobus.entities.Route;

import java.security.Timestamp;
import java.sql.Time;
import java.util.Date;
import java.util.List;

/**
 * Created by magda on 2017-01-24.
 */
@Repository
public interface ConcreteTravelRepository extends CrudRepository<ConcreteTravel, Long> {
    List<ConcreteTravel> findByDepartureTime(Date departureTime);

    List<ConcreteTravel> findByDepartureTimeGreaterThan(Date departureTime);

    List<ConcreteTravel> findByRouteByRouteId(Route routeByRouteId);
}
