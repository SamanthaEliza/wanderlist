package com.bursac.TravelApp.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Country {

    public static Country ALL;

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 3)
    private String name;

    private String language;

    private String currency;

    private String capital;

    private String drivingside;

    private String callingcode;

    private String est;


//    @OneToMany
//    @JoinColumn(name = "country_id")
//    private List<City> cities = new ArrayList<>();
//
//    public Country() {
//        this.id = id;
//        this.name = name;
//
//
//    }
//
//}

    @OneToMany
    @JoinColumn(name = "country_id")
    private List<City> cities = new ArrayList<>();

    public Country(String name, String language, String currency,
                   String capital, String drivingside, String est)  {
        this.name = name;
        this.language = language;
        this.currency = currency;
        this.capital = capital;
        this.drivingside = drivingside;
        this.est = est;
    }

    public Country() {  }

    public static Country[] values() {
        return new Country[0];
    }

    public static Country getValue() {
        return null;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {return language;}

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCurrency() {return currency;}

    public void setCurrency(String currency) {this.currency = currency;}

    public String getCapital() {return capital;}

    public void setCapital(String capital) {this.capital = capital;}

    public String getDrivingside() {return drivingside;}

    public void setDrivingside(String drivingside) {this.drivingside = drivingside;}

    public String getCallingcode() {return callingcode;}

    public void setCallingcode(String callingcode) {this.callingcode = callingcode;}

    public String getEst() {return est;}

    public void setEst(String est) {this.est = est;}


    public ArrayList<Country> findById(Country searchField, String keyword) {
        return null;
    }
}
