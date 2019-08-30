package com.bursac.TravelApp.controllers;

import com.bursac.TravelApp.models.Activity;
import com.bursac.TravelApp.models.Country;
import com.bursac.TravelApp.models.data.ActivityDao;
import com.bursac.TravelApp.models.data.CityDao;
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
@RequestMapping("activity")
public class ActivityController extends AbstractController{

    @Autowired
    private ActivityDao activityDao;
    @Autowired
    private CityDao cityDao;


    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("activity", activityDao.findAll());
        model.addAttribute("title", "Activity");

        return "activity/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {

        model.addAttribute("title", "Activity");
        model.addAttribute("activity", new Activity());
        model.addAttribute("city", cityDao.findAll());
        return "activity/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model,
                      @ModelAttribute @Valid Activity activity, Errors errors) {

        if (errors.hasErrors()) {
            return "activity/add";
        }
        activityDao.save(activity);
        return "redirect:";
    }
}
