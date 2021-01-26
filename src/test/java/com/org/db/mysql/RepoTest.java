package com.org.db.mysql;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {UserRepository.class, MySqlConfig.class, UserDataService.class})
@EnableJpaRepositories
@EntityScan(basePackageClasses = User.class)
@AutoConfigureTestEntityManager
@AutoConfigureDataJpa
public class RepoTest {

    @Autowired
    UserDataService service;

    @Test
    public void get() {
        Optional<User> user = service.findById(1);
        System.out.println(user.get().getName());
    }

}
