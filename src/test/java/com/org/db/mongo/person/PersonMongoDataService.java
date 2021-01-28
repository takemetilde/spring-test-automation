package com.org.db.mongo.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonMongoDataService {

    @Autowired
    PersonMongoRepository personRepository;

    public List<PersonMongo> findAll() {
        return personRepository.findAll();
    }

    public PersonMongo findByName(String name) {
        return personRepository.findByName(name);
    }

}
