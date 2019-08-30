package com.bursac.TravelApp.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class City {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3)
    private String name;

    private String language;

    private String airport;

    private String climate;

    private String population;

    private String timezone;

    @NotNull
    @Size(min=1, message = "Description must not be empty")
    private String description;

    @ManyToOne
    private Country country;

    @OneToMany
    @JoinColumn(name = "activity_id")
    private List<Activity> activities = new ArrayList<>();

    @ManyToMany(mappedBy = "cities")
    private List<WanderList> wanderlist;


    public City(String name, String language, String description) {
        this.name = name;
        this.language = language;
        this.description = description;
        this.airport = airport;
        this.climate = climate;
        this.population = population;
        this.timezone = timezone;
    }

    public City() { }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getLanguage() {return language;}

    public void setLanguage(String language) {this.language = language;}

    public String getAirport() {return airport;}

    public void setAirport(String airport) {this.airport = airport;}

    public String getClimate() {return climate;}

    public void setClimate(String climate) {this.climate = climate;}

    public String getPopulation() {return population;}

    public void setPopulation(String population) {this.population = population;}

    public String getTimezone() {return timezone;}

    public void setTimezone(String timezone) {this.timezone = timezone;}


}
