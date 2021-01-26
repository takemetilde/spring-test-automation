package com.org.db.mysql;

import com.org.db.mysql.person.Person;
import com.org.db.mysql.person.PersonConfig;
import com.org.db.mysql.person.PersonDataService;
import com.org.db.mysql.user.UserConfig;
import com.org.db.mysql.user.User;
import com.org.db.mysql.user.UserDataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.text.html.Option;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {UserConfig.class, PersonConfig.class})
public class RepoTest {

    @Autowired
    UserDataService userDataService;

    @Autowired
    PersonDataService personDataService;

    @Test
    public void get() {
        Optional<User> user = userDataService.findById(1);
        System.out.println(user.get().getName());

        Optional<Person> person = personDataService.findById(2);
        System.out.println(person.get().getName());
    }

}
