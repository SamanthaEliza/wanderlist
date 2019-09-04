package com.bursac.TravelApp.controllers;

//import org.launchcode.models.JobFieldType;


import com.bursac.TravelApp.models.Country;

public class SearchForm {

    // The search options
    private Country[] fields = Country.values();

    // The selected search options
    private Country searchField = Country.ALL;

    // The search string
    private String keyword;

    public Country getSearchField() {
        return searchField;
    }

    public void setSearchField(Country searchField) {
        this.searchField = searchField;
    }

    public Country[] getFields() {
        return fields;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}