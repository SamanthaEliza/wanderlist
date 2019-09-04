package com.bursac.TravelApp.controllers;

//import org.launchcode.models.Job;
//import org.launchcode.models.JobFieldType;
//import org.launchcode.models.forms.SearchForm;
//import org.launchcode.models.data.JobData;
import com.bursac.TravelApp.models.Country;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Objects;


@Controller
@RequestMapping("search")
public class SearchController {

    private Country country = Country.getValue();

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute(new SearchForm());
        return "search";
    }

    @RequestMapping(value = "results")
    public String search(Model model,
                         @ModelAttribute SearchForm searchForm) {

        ArrayList<Country> countries;

//        if (Objects.equals(searchForm.getSearchField(), Objects)) {
//            countries = country.findById(searchForm.getSearchField(), searchForm.getKeyword());
//        }
//        elseif: {
//            countries = country.findById(searchForm.getSearchField(), searchForm.getKeyword());
//        }

        model.addAttribute("Country", country);

        return "search";
    }

}