package com.milewczyk.postgressqlfetchingdata.service;

import com.milewczyk.postgressqlfetchingdata.mapper.PersonMapper;
import com.milewczyk.postgressqlfetchingdata.model.Person;
import com.milewczyk.postgressqlfetchingdata.model.dtos.PersonDTO;
import com.milewczyk.postgressqlfetchingdata.repository.PersonRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    public PersonService(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    public Page<PersonDTO> getPersonByCity(String city, Pageable pageable) {
        return personRepository.findAllByAddress_City(city, pageable)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("There is no person with city name %s does not exists", city)))
                .map(personMapper::mapPersonToPersonDTO);
    }

    public PersonDTO getPersonById(Long id) {
        Person findedPerson = personRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Peron with id %d does not exists", id)));
        return personMapper.mapPersonToPersonDTO(findedPerson);
    }

    public Page<PersonDTO> getAllPerson() {
        var findedPersons = personRepository.findAll()
                .stream()
                .map(personMapper::mapPersonToPersonDTO)
                .collect(Collectors.toList());
        return new PageImpl<>(findedPersons);
    }
}
