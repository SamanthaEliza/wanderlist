package com.bursac.TravelApp.controllers;

import com.bursac.TravelApp.models.Activity;
import com.bursac.TravelApp.models.City;
import com.bursac.TravelApp.models.Country;
import com.bursac.TravelApp.models.data.ActivityDao;
import com.bursac.TravelApp.models.data.CityDao;
import com.bursac.TravelApp.models.data.CountryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

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
//        model.addAttribute("city", cityDao.findAll());
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

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveCityForm(Model model) {
        model.addAttribute("activities", activityDao.findAll());
        model.addAttribute("title", "Remove Activity");
        return "activity/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveCityForm(@RequestParam int[] activityIds) {

        for (int activityId : activityIds){
            activityDao.deleteById(activityId);
        }

        return "redirect:";
    }


    @RequestMapping(value = "edit/{activityId}", method = RequestMethod.GET)
    public String displayEditCityForm(Model model, @PathVariable int activityId) {

        model.addAttribute("title", "Edit Activity");
        model.addAttribute("activity", activityDao.findAll());
        return "activity/edit";

    }

    @RequestMapping(value = "edit/{activityId}", method = RequestMethod.POST)
    public String processEditForm(Model model, @PathVariable int activityId,
                                  @ModelAttribute @Valid Activity newActivity,
//                                  @RequestParam int activityId,
                                  Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Activity");
            return "activity/edit";
        }

        Activity editedActivity = activityDao.findById(activityId).orElse(null);
        editedActivity.setName(newActivity.getName());
        editedActivity.setDescription(newActivity.getDescription());
        editedActivity.setItems(newActivity.getItems());
        editedActivity.setLocation(newActivity.getLocation());


        activityDao.save(editedActivity);

        return "redirect:/activity";
    }
}
