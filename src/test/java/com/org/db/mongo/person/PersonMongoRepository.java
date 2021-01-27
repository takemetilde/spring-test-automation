package com.org.db.mongo.person;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonMongoRepository extends MongoRepository<PersonMongo, String> {

    public PersonMongo findByName(String name);
}