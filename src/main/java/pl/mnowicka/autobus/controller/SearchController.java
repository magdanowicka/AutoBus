package pl.mnowicka.autobus.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.mnowicka.autobus.domain.SearchResult;
import pl.mnowicka.autobus.entities.ConcreteTravel;
import pl.mnowicka.autobus.entities.Route;
import pl.mnowicka.autobus.repositories.ConcreteTravelRepository;
import pl.mnowicka.autobus.repositories.RouteRepository;
import pl.mnowicka.autobus.search.TravelSearch;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class SearchController {

    public static final Logger logger = LoggerFactory.getLogger(SearchController.class);

//    @Autowired
//    private TravelSearch travelSearch;


    @Autowired
    RouteRepository routeRepository;


    /**
     * Index main page.
     */
    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "Try to go here: " +
                "<a href='/searchTest?q=hola'>/searchTest?q=hola</a>";
    }


    /**
     * Show search results for the given query.
     *
     * @param q The search query.
     */
    @RequestMapping("/searchTest")
    public String search(String q, Model model) {
        List<Route> searchResults = new ArrayList<>();
        try {
            logger.info("searchQuery: "+q);
            searchResults = routeRepository.findByDepartureLike(q);

        }
        catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
        }
        model.addAttribute("searchResults", searchResults);
        return "search";
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
