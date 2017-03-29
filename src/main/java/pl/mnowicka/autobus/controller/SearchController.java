package pl.mnowicka.autobus.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import pl.mnowicka.autobus.entities.ConcreteTravel;
import pl.mnowicka.autobus.entities.Route;

import pl.mnowicka.autobus.repositories.ConcreteTravelRepository;
import pl.mnowicka.autobus.repositories.RouteRepository;
import pl.mnowicka.autobus.config.ViewsAggregate;


import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;

@RestController
public class SearchController {

    public static final Logger logger = LoggerFactory.getLogger(SearchController.class);


    @Autowired
    RouteRepository routeRepository;

    @Autowired
    ConcreteTravelRepository concreteTravelRepository;

    @RequestMapping(value = "/searchresults", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView search(@RequestParam(value = "departure") String departure, @RequestParam(value = "destination") String destination, @RequestParam(value = "departureTime") @DateTimeFormat(iso = ISO.DATE) Date departureTime, String pSearchTerm, HttpServletRequest request, HttpServletResponse response) {

        List<ConcreteTravel> searchResults = new ArrayList<>();

        String odjazd = departure;
        String przyjazd = destination;

        Route route = routeRepository.findByDepartureAndDestination(departure, destination);
        Integer id = route.getId();
        logger.info("route results" + id);

        try {
            logger.info("dearture time" + departureTime);
            searchResults = concreteTravelRepository.findByRouteByRouteId(route);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
        }

        ModelAndView mav = new ModelAndView(ViewsAggregate.SEARCHRESULTS, "searchResults", searchResults);

        mav.addObject("searchResults", searchResults);
        mav.addObject("odjazd", odjazd);
        mav.addObject("przyjazd", przyjazd);

        if (id != 1) return new ModelAndView(ViewsAggregate.NOMATCH, "searchResults", searchResults);
        return mav;
    }


}

