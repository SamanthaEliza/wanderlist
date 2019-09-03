package com.bursac.TravelApp.models;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Activity {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3)
    private String name;
    


    @NotNull
    @Size(min=1, message = "Description must not be empty")
    private String description;

    @ManyToOne
    private City city;

    public Activity(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Activity() { }

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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}




//package com.bursac.TravelApp.models;
//
//import org.hibernate.annotations.Generated;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//public class Activity {
//
//    @Id
//    @GeneratedValue
//    private int id;
//
//    @NotNull
//    @Size(min = 3)
//    private String name;
//
////    @OneToMany
////    @JoinColumn(name = "country_id")
////    private List<City> cities = new ArrayList<>();
////
////    public Country() {
////        this.id = id;
////        this.name = name;
////
////
////    }
////
////}
//
//    @OneToMany
//    @JoinColumn(name = "activity_id")
//    private List<City> cities = new ArrayList<>();
//
//    public Activity(String name) { this.name = name;
//    }
//
//    public Activity() {
//    }
//
//    public int getId() {
//        return id;
//    }
//
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//
//}