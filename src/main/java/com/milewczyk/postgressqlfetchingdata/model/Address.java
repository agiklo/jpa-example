package com.milewczyk.postgressqlfetchingdata.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;
    private String street;
    private String city;
    private String country;

    public Address() {
    }

    public Address(Long id, String street, String city, String country) {
        this.addressId = id;
        this.street = street;
        this.city = city;
        this.country = country;
    }

    public Long getId() {
        return addressId;
    }

    public void setId(Long id) {
        this.addressId = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
