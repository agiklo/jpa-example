package com.milewczyk.postgressqlfetchingdata.controller;

import com.milewczyk.postgressqlfetchingdata.model.dtos.PersonDTO;
import com.milewczyk.postgressqlfetchingdata.service.PersonService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping(path = "/api/v1/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public ResponseEntity<Page<PersonDTO>> getAllPerson() {
        return status(HttpStatus.OK).body(personService.getAllPerson());
    }

    @GetMapping("/search/id/{id}")
    public ResponseEntity<PersonDTO> getPersonById(@PathVariable("id") Long id) {
        return status(HttpStatus.OK).body(personService.getPersonById(id));
    }

    @GetMapping("/search/city/")
    public ResponseEntity<Page<PersonDTO>> getAllPersonByCity(@RequestParam("city") String city, Pageable pageable) {
        return status(HttpStatus.OK).body(personService.getPersonByCity(city, pageable));
    }
}
