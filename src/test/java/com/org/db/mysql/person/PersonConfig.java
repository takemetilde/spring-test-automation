package com.org.db.mysql.person;

import com.org.db.mysql.user.User;
import com.org.db.mysql.user.UserDataService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackageClasses = PersonDataService.class)
@EnableJpaRepositories(
        entityManagerFactoryRef = "personEntityManagerFactory",
        transactionManagerRef = "personTransactionManager"
)
@AutoConfigureDataJpa
public class PersonConfig {

    @Bean(name = "testdb2DataSource")
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .url("jdbc:mysql://localhost:3306/testdb2")
                .username("test")
                .password("1987ofb")
                .build();
    }

    @Bean(name = "personEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(
            EntityManagerFactoryBuilder builder, @Qualifier("testdb2DataSource") DataSource dataSource) {

        return builder
                .dataSource(dataSource)
                .packages(Person.class)
                .persistenceUnit("person")
                .build();
    }

    @Bean(name = "personTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("personEntityManagerFactory") EntityManagerFactory userEntityManagerFactory) {
        return new JpaTransactionManager(userEntityManagerFactory);
    }
}
