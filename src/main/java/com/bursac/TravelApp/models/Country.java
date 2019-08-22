package com.bursac.TravelApp.models;

import org.hibernate.annotations.Generated;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Country {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 3, max = 15)
    private String name;

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

    public Country(String name) { this.name = name;
    }

    public Country() {
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


}
