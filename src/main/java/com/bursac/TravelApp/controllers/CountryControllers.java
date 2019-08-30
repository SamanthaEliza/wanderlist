package com.bursac.TravelApp.controllers;

import com.bursac.TravelApp.models.City;
import com.bursac.TravelApp.models.Country;
import com.bursac.TravelApp.models.data.CountryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value ="edit/{countryId}", method = RequestMethod.GET)
    public String displayEditCountryForm(Model model, @PathVariable int countryId) {

        model.addAttribute("title", "Edit Country");
        model.addAttribute("country", countryDao.findById(countryId));
        model.addAttribute("country",countryDao.findAll());
        return "country/edit";
    }

    @RequestMapping(value ="edit/{countryId}", method = RequestMethod.POST)
    public String processEditForm(Model model, @PathVariable int cityId,
                                  @ModelAttribute @Valid Country newCountry,
                                  @RequestParam int countryId,
                                  Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Country");
            return "country/edit";
        }

        Country editedCountry = countryDao.findById(countryId).orElse(null);
        editedCountry.setName(newCountry.getName());
//        editedCountry.setDescription(newCountry.getDescription());
//        editedCountry.setCountry(countryDao.findById(countryId).orElse(null));
        countryDao.save(editedCountry);

        return "redirect/city";

    }
}