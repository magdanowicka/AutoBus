package pl.mnowicka.autobus.service;

import pl.mnowicka.autobus.domain.RouteDto;
import pl.mnowicka.autobus.domain.UserDto;
import pl.mnowicka.autobus.entities.Route;
import pl.mnowicka.autobus.entities.User;
import pl.mnowicka.autobus.entities.VerificationToken;

/**
 * Created by magda on 2017-01-24.
 */
public interface IRouteService {

    Route addNewRoute(RouteDto routeDto);
    Route addNewBackRoute(RouteDto routeDto);

}