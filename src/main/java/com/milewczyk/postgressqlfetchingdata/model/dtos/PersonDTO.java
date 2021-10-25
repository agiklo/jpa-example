package com.milewczyk.postgressqlfetchingdata.model.dtos;

import com.milewczyk.postgressqlfetchingdata.model.Address;
import com.milewczyk.postgressqlfetchingdata.model.enums.Gender;


public class PersonDTO {

    private Long personId;
    private String firstName;
    private String lastName;
    private Gender gender;
    private Address address;
    private String email;
    private String phone;
    private Long addressId;
    private String street;
    private String city;
    private String country;
}
