package pl.mnowicka.autobus.service;

import pl.mnowicka.autobus.domain.ConcreteTravelDto;
import pl.mnowicka.autobus.entities.ConcreteTravel;

/**
 * Created by magda on 2017-02-25.
 */
public interface IConcreteTravelService {

    ConcreteTravel addNewConcreteTravel(ConcreteTravelDto concreteTravelDto);
}
