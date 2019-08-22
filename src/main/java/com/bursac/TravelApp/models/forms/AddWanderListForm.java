package com.bursac.TravelApp.models.forms;

import com.bursac.TravelApp.models.City;
import com.bursac.TravelApp.models.WanderList;


public class AddWanderListForm {

    private WanderList wanderlist;
    private Iterable<City> cities;
    private int wanderlistId;
    private int cityId;

    public AddWanderListForm() {}

    public AddWanderListForm(WanderList wanderlist, Iterable<City> cities) {
        this.wanderlist = wanderlist;
        this.cities = cities;
    }

    public WanderList getWanderList() {
        return wanderlist;
    }

    public void setWanderList(WanderList wanderList) {
        this.wanderlist = wanderList;
    }

    public Iterable<City> getCities() {
        return cities;
    }

    public void setCities(Iterable<City> cities) {
        this.cities = cities;
    }

    public int getWanderlistId() {
        return wanderlistId;
    }

    public void setWanderlistId(int wanderlistId) {
        this.wanderlistId = wanderlistId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
}

