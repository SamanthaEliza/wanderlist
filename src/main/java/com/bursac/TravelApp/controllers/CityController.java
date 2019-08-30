package com.bursac.TravelApp.controllers;


import com.bursac.TravelApp.models.City;
import com.bursac.TravelApp.models.Country;
import com.bursac.TravelApp.models.User;
import com.bursac.TravelApp.models.data.CityDao;
import com.bursac.TravelApp.models.data.CountryDao;
import com.bursac.TravelApp.models.data.WanderListDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


@Controller
@RequestMapping("city")
public class CityController extends AbstractController {

    @Autowired
    private CityDao cityDao;
    @Autowired
    private CountryDao countryDao;
    @Autowired
    private WanderListDao wanderListDao;

    // Request path: /cites
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("cities", cityDao.findAll());
        model.addAttribute("title", "My Cites");

        return "city/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCityForm(Model model,  HttpServletRequest request) {

        model.addAttribute("title", "Add City");
        model.addAttribute(new City());
        model.addAttribute("country", countryDao.findAll());
        return "city/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCityForm(@ModelAttribute  @Valid City newCity,
                                       @RequestParam int countryId,
                                       Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add City");
            return "city/add";
        }

        Country country = countryDao.findById(countryId).orElse(null);
        newCity.setCountry(country);
        cityDao.save(newCity);
        return "redirect:";
    }

    //TODO move this functionality to wanderlists. No reason to remove cities.
//    @RequestMapping(value = "remove", method = RequestMethod.GET)
//    public String displayRemoveCityForm(Model model) {
//        model.addAttribute("cites", cityDao.findAll());
//        model.addAttribute("title", "Remove City");
//        return "city/remove";
//    }
//
//    @RequestMapping(value = "remove", method = RequestMethod.POST)
//    public String processRemoveCityForm(@RequestParam int[] cityIds) {
//
//        for (int cityId : cityIds){
//            cityDao.deleteById(cityId);
//        }
//
//        return "redirect:";
//    }

    @RequestMapping(value = "edit/{cityId}", method = RequestMethod.GET)
    public String displayEditCityForm(Model model, @PathVariable int cityId) {

        model.addAttribute("title", "Edit City");
        model.addAttribute("city", cityDao.findById(cityId));
        model.addAttribute("country", countryDao.findAll());
        return "city/edit";
    }

    @RequestMapping(value = "edit/{cityId}", method = RequestMethod.POST)
    public String processEditForm(Model model, @PathVariable int cityId,
                                  @ModelAttribute  @Valid City newCity,
                                  @RequestParam int countryId,
                                  Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add City");
            return "city/edit";
        }

        City editedCity = cityDao.findById(cityId).orElse(null);
        editedCity.setName(newCity.getName());
        editedCity.setDescription(newCity.getDescription());
        editedCity.setCountry(countryDao.findById(countryId).orElse(null));
        cityDao.save(editedCity);

        return "redirect:/city";
    }
}
