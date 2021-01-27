package com.org.db.mysql.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserJpaDataService {

    @Autowired
    UserJpaRepository repository;

    public Optional<UserJpa> findById(int id) {
        return repository.findById(id);
    }
}
