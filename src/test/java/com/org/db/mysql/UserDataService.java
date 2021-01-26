package com.org.db.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDataService {

    @Autowired
    UserRepository repository;

    public Optional<User> findById(int id) {
        return repository.findById(id);
    }
}
