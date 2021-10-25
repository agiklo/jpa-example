package com.milewczyk.postgressqlfetchingdata.mapper;

import com.milewczyk.postgressqlfetchingdata.model.Person;
import com.milewczyk.postgressqlfetchingdata.model.dtos.PersonDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface PersonMapper {

    @Mapping(target = "addressId", source = "address.addressId")
    @Mapping(target = "street", source = "address.street")
    @Mapping(target = "city", source = "address.city")
    @Mapping(target = "country", source = "address.country")
    PersonDTO mapPersonToPersonDTO(Person person);
}
