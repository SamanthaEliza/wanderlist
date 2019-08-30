package com.bursac.TravelApp.controllers;

import com.bursac.TravelApp.models.City;
import com.bursac.TravelApp.models.WanderList;
import com.bursac.TravelApp.models.data.CityDao;
import com.bursac.TravelApp.models.data.WanderListDao;
import com.bursac.TravelApp.models.forms.AddWanderListForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "wanderlist")
public class WanderListController extends AbstractController {

//    @Autowired
//    private com.bursac.TravelApp.models.data.WanderListDao WanderListDao;
    @Autowired
    private WanderListDao wanderListDao;


    @Autowired
    private CityDao cityDao;


    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("title", "WanderList");
        model.addAttribute("wanderlists", wanderListDao.findAll());

        return "wanderlist/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("title", "Add wanderlist");
        model.addAttribute("wanderlist", new WanderList());
        return "wanderlist/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid WanderList newwanderlist,
                      Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add wanderlist");
            return "wanderlist/add";
        }

        wanderListDao.save(newwanderlist);
        return "redirect:view/" + newwanderlist.getId();
    }

    @RequestMapping(value = "view/{id}", method = RequestMethod.GET)
    public String view(Model model, @PathVariable int id) {

        WanderList wanderlist = wanderListDao.findById(id).orElse(null);

        model.addAttribute("title", wanderlist.getName());
        model.addAttribute("wanderlist", wanderlist);
        return "wanderlist/view";
    }

    @RequestMapping(value = "add-item/{wanderlistId}", method = RequestMethod.GET)
    public String addItem(Model model, @PathVariable int wanderlistId) {

        WanderList wanderlist = wanderListDao.findById(wanderlistId).orElse(null);

        AddWanderListForm itemForm = new AddWanderListForm((wanderlist), cityDao.findAll());

        model.addAttribute("title", "Add item to menu: " + wanderlist.getName());
        model.addAttribute("form", itemForm);

        return "wanderlist/add-item";
    }

    @RequestMapping(value = "add-item/{wanderlistId}", method = RequestMethod.POST)
    public String addItem(Model model, @ModelAttribute @Valid AddWanderListForm itemForm,
                          Errors errors, @PathVariable int wanderlistId) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Item");
            model.addAttribute("city", cityDao.findAll());
            return "wanderList/add-item/" + wanderlistId;
        }

        WanderList wanderList = wanderListDao.findById(itemForm.getWanderlistId()).orElse(null);
        City city = cityDao.findById(itemForm.getCityId()).orElse(null);

        wanderList.addItem(city);
        wanderListDao.save(wanderList);

        return "redirect:../view/" + wanderList.getId();
    }
}


