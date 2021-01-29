package com.org.db;

import com.org.db.mongo.person.PersonMongo;
import com.org.db.mongo.person.PersonMongoConfig;
import com.org.db.mongo.person.PersonMongoDataService;
import com.org.db.mongo.user.UserMongo;
import com.org.db.mongo.user.UserMongoConfig;
import com.org.db.mongo.user.UserMongoDataService;
import com.org.db.mysql.person.Person;
import com.org.db.mysql.person.PersonJpaConfig;
import com.org.db.mysql.person.PersonJpaDataService;
import com.org.db.mysql.user.UserJpaConfig;
import com.org.db.mysql.user.UserJpa;
import com.org.db.mysql.user.UserJpaDataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {UserJpaConfig.class, PersonJpaConfig.class, UserMongoConfig.class, PersonMongoConfig.class})
@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
public class RepoTest {

    @Autowired
    UserJpaDataService userDataService;

    @Autowired
    PersonJpaDataService personDataService;

    @Autowired
    UserMongoDataService userMongoDataService;

    @Autowired
    PersonMongoDataService personMongoDataService;

    @Test
    public void testJpa() {
//        Optional<UserJpa> user = userDataService.findById(1);
//        System.out.println(user.get().getName());

        Optional<Person> person = personDataService.findById(2);
        System.out.println(person.get().getName());
    }

    @Test
    public void testMongo() {
        List<UserMongo> mongoUsers = userMongoDataService.findAll();
        mongoUsers.forEach(m -> System.out.println(m.getName()));

        List<PersonMongo> mongoPersons = personMongoDataService.findAll();
        System.out.println("Printing...");
        mongoPersons.forEach(m -> System.out.println(m.getAddress()));

    }

}
