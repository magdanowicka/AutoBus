package pl.mnowicka.autobus.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.mnowicka.autobus.entities.Route;

import java.util.List;

/**
 * Created by magda on 2017-01-24.
 */
@Repository
public interface RouteRepository extends CrudRepository<Route, Long> {

    public List<Route> findByDepartureLike(String departure);

    public Route findByDepartureAndDestination(String departure, String destination);

    public List<Route> findAll();

}
