package pl.mnowicka.autobus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import pl.mnowicka.autobus.domain.ConcreteTravelDto;
import pl.mnowicka.autobus.entities.ConcreteTravel;
import pl.mnowicka.autobus.entities.Route;
import pl.mnowicka.autobus.repositories.ConcreteTravelRepository;
import pl.mnowicka.autobus.repositories.RouteRepository;

/**
 * Created by magda on 2017-02-25.
 */
public class ConcreteTravelService implements IConcreteTravelService {

    @Autowired
    private ConcreteTravelRepository repository;
    @Autowired
    private RouteRepository routeRepository;

    public void setRepository(ConcreteTravelRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @Override
    public ConcreteTravel addNewConcreteTravel(ConcreteTravelDto concreteTravelDto) {

        ConcreteTravel concreteTravel = new ConcreteTravel();
        concreteTravel.setDepartureTime(concreteTravelDto.getDepartureTime());
        concreteTravel.setDepartureTime(concreteTravelDto.getArrivalTime());
        concreteTravel.setRouteByRouteId(concreteTravelDto.getRouteByRouteId());
        concreteTravel.setStatus("pending");
        concreteTravel.setRouteByRouteId(routeRepository.findByDepartureAndDestination("Lublin", "Warszawa"));


        return repository.save(concreteTravel);

    }

}
