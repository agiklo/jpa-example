package com.milewczyk.postgressqlfetchingdata.repository;

import com.milewczyk.postgressqlfetchingdata.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Page<Person>> findAllByAddress_City(String city, Pageable pageable);
}
