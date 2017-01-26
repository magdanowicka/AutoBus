package pl.mnowicka.autobus.controller;

import org.springframework.boot.Banner;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.mnowicka.autobus.domain.SearchResult;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class SearchController {


    @RequestMapping( value = "search", method = RequestMethod.GET)
    public ModelAndView search(@RequestParam(value="from") String from, @RequestParam(value="to") String to) {
        List<SearchResult> results = new ArrayList<>();
        for (int i=0; i<10; i++) {
            SearchResult result = new SearchResult();
            result.setFrom(from);
            result.setTo(to);
            result.setArrival(new Date());
            results.add(result);
        }
        ModelAndView mav = new ModelAndView("search");
        mav.addObject("results", results);
        return mav;
    }


}
