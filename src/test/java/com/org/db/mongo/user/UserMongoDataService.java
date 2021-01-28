package com.org.db.mongo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserMongoDataService {

    @Autowired
    UserMongoRepository userRepository;

    public List<UserMongo> findAll() {
        return userRepository.findAll();
    }

    public UserMongo findByName(String name) {
        return userRepository.findByName(name);
    }

}
