package pl.mnowicka.autobus.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import pl.mnowicka.autobus.domain.ConcreteTravelDto;
import pl.mnowicka.autobus.domain.RouteDto;
import pl.mnowicka.autobus.entities.ConcreteTravel;
import pl.mnowicka.autobus.entities.Route;
import pl.mnowicka.autobus.repositories.RouteRepository;
import pl.mnowicka.autobus.service.ConcreteTravelService;
import pl.mnowicka.autobus.service.RouteService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by magda on 2017-02-24.
 */
public class TravelController {

    private static final Logger logger = LoggerFactory.getLogger(RouteController.class);


    @Autowired
    private ConcreteTravelService service;

    @Autowired
    private RouteRepository routeRepository;

    @RequestMapping(value = "/adminPageTravel", method = RequestMethod.GET)
    public String showRegistrationForm(WebRequest request, Model model) {

        ConcreteTravelDto concreteTravelDto = new ConcreteTravelDto();
        model.addAttribute("concrete_travel", concreteTravelDto);
        return "adminPage";
    }


    @RequestMapping(value = "/adminPageTravel", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView addTravel(@ModelAttribute("concrete_travel") @Valid ConcreteTravelDto concreteTravelDto,
                                  BindingResult result, WebRequest request, Errors errors) {

        String viewName = "adminPage";


        if (!result.hasErrors()) {

            ConcreteTravel travel = addConcreteTravel(concreteTravelDto, result);
            viewName = "home";

        }

        return new ModelAndView(viewName, "travel", concreteTravelDto);

    }



    private ConcreteTravel addConcreteTravel(ConcreteTravelDto concreteTravelDto, BindingResult result) {
        return service.addNewConcreteTravel(concreteTravelDto);
    }


}
