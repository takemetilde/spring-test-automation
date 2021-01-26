package com.org.db.mysql.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonDataService {

    @Autowired
    PersonRepository repository;

    public Optional<Person> findById(int id) {
        return repository.findById(id);
    }
}
