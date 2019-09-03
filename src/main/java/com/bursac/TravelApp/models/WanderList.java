package com.bursac.TravelApp.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
public class WanderList {

    @Id
    @GeneratedValue
    private int id;

//    @ManyToOne
//    private User user;

    @NotNull
    @Size(min=3)
    private String name;

//    private String wanderlist;

    private String description;

    private String location;

    @ManyToMany
    private List<City> cities;

    public WanderList() {    }

    public WanderList(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<City> getCities() { return cities;
    }

//    public void addItem(City item) {
//        cities.add(item);
//    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

//    public String getWanderlist() {return wanderlist; }
//
//    public void setWanderlist(String wanderlist) {this.wanderlist = wanderlist;}

    public String getDescription() {return description;}

    public void setDescription(String descripton) {this.description = descripton;}

    public String getLocation() {return location;}

    public void setLocation(String location) {this.location = location;}

    public void add(City city) {
    }
}
