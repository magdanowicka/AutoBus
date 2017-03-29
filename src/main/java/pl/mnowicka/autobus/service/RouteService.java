package pl.mnowicka.autobus.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.mnowicka.autobus.domain.RouteDto;
import pl.mnowicka.autobus.domain.UserDto;
import pl.mnowicka.autobus.entities.Route;
import pl.mnowicka.autobus.entities.User;
import pl.mnowicka.autobus.entities.VerificationToken;
import pl.mnowicka.autobus.repositories.RouteRepository;
import pl.mnowicka.autobus.repositories.UserRepository;
import pl.mnowicka.autobus.repositories.VerificationTokenRepository;

/**
 * Created by magda on 2017-01-24.
 */
@Service
public class RouteService implements IRouteService {


    @Autowired
    private RouteRepository repository;

    public void setRepository(RouteRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @Override
    public Route addNewRoute(RouteDto routeDto) {

        Route route = new Route();
        route.setDeparture(routeDto.getDeparture());
        route.setDestination(routeDto.getDestination());
        route.setLength(routeDto.getLength());

        return repository.save(route);

    }

    @Transactional
    @Override
    public Route addNewBackRoute(RouteDto routeDto) {

        Route route = new Route();
        route.setDeparture(routeDto.getDestination());
        route.setDestination(routeDto.getDeparture());
        route.setLength(routeDto.getLength());

        return repository.save(route);

    }




}