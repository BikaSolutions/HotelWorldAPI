package com.acme.hotel_world_api.system.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "hotels")
public class Hotel {
    
    //attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String name;

    @NotNull
    private String address;

    @NotNull
    private Long phone;
    //relation

    //getters and setters

    public Long getId(){
        return id;
    }

    public Hotel setId(Long id){
        this.id = id;
        return this;
    }

    public String getName(){
        return name;
    }

    public Hotel setName(String name){
        this.name = name;
        return this;
    }
    
    public String getAddress(){
        return address;
    }

    public Hotel setAddress(String address){
        this.address = address;
        return this;
    }

    public Long getPhone(){
        return phone;
    }

    public Hotel setPhone(Long phone){
        this.phone = phone;
        return this;
    }
}
