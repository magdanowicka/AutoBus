package pl.mnowicka.autobus.controller;

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


import java.security.Timestamp;
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


    @RequestMapping(value = "/searchTest", method = RequestMethod.GET)

    //public ModelAndView search(@RequestParam(value = "departure") String departure, @RequestParam(value = "destination") String destination,@RequestParam(value = "departureTime") Date departureTime) {
        public ModelAndView search(@RequestParam(value = "departureTime") @DateTimeFormat(iso=ISO.DATE) Date departureTime) {

            List<ConcreteTravel> searchResults = new ArrayList<>();
        //List<Route> searchResults = new ArrayList<>();
        try {
            logger.info("dearture time" + departureTime);
            //logger.info("searchQuery: " + destination + departure);
            //searchResults = routeRepository.findByDepartureAndDestination(departure, destination);
            searchResults = concreteTravelRepository.findByDepartureTimeGreaterThan(departureTime);

        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
        }

        ModelAndView mav = new ModelAndView("results");
        mav.addObject("searchResults", searchResults);

        return mav;

    }


}


//    @RequestMapping( value = "search", method = RequestMethod.GET)
//    public ModelAndView search(@RequestParam(value="from") String from, @RequestParam(value="to") String to) {
//        List<SearchResult> results = new ArrayList<>();
//        for (int i=0; i<10; i++) {
//            SearchResult result = new SearchResult();
//            result.setFrom(from);
//            result.setTo(to);
//            result.setArrival(new Date());
//            results.add(result);
//        }
//        ModelAndView mav = new ModelAndView("search");
//        mav.addObject("results", results);
//        return mav;
//    }
//
//
//}
