package com.bursac.TravelApp.controllers;

import com.bursac.TravelApp.models.Country;
import com.bursac.TravelApp.models.data.CountryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


@Controller
@RequestMapping("country")
public class CountryControllers extends AbstractController {

    @Autowired
    private CountryDao countryDao;

    // Request path: /city
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("country", countryDao.findAll());
        model.addAttribute("title", "Country");

        return "country/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {

        model.addAttribute("title", "Country");
        model.addAttribute("country", new Country());
        return "country/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model,
                      @ModelAttribute @Valid Country country, Errors errors) {

        if (errors.hasErrors()) {
            return "country/add";
        }
        countryDao.save(country);
        return "redirect:";

    }

//    @RequestMapping(value ="edit/{countryId}", method = RequestMethod.GET)
//    public String
}