package com.org.db;

import com.org.db.mongo.user.UserMongo;
import com.org.db.mongo.user.UserMongoConfig;
import com.org.db.mongo.user.UserMongoDataService;
import com.org.db.mysql.person.Person;
import com.org.db.mysql.person.PersonJpaConfig;
import com.org.db.mysql.person.PersonDataService;
import com.org.db.mysql.user.UserJpaConfig;
import com.org.db.mysql.user.UserJpa;
import com.org.db.mysql.user.UserJpaDataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {UserJpaConfig.class, PersonJpaConfig.class, UserMongoConfig.class})
public class RepoTest {

    @Autowired
    UserJpaDataService userDataService;

    @Autowired
    PersonDataService personDataService;

    @Autowired
    UserMongoDataService userMongoDataService;

    @Test
    public void testJpa() {
        Optional<UserJpa> user = userDataService.findById(1);
        System.out.println(user.get().getName());

        Optional<Person> person = personDataService.findById(2);
        System.out.println(person.get().getName());
    }

    @Test
    public void testMongo() {
        List<UserMongo> mongoUsers = userMongoDataService.findAll();
        System.out.println("Printing...");
        mongoUsers.forEach(m -> System.out.println(m.getName()));

    }

}
