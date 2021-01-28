package com.org.db.mongo.person;

import com.mongodb.ConnectionString;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@ComponentScan(basePackageClasses = {PersonMongoDataService.class, PersonMongoRepository.class})
@EnableMongoRepositories(mongoTemplateRef = "personMongoTemplate")
@AutoConfigureDataMongo
public class PersonMongoConfig  {

    @Bean(name = "personMongoTemplate")
    MongoTemplate personMongoTemplate(@Qualifier("personMongoDbFactory") MongoDbFactory mongoDbFactory) {
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory );
        return mongoTemplate;
    }

    @Bean( name = "personMongoDbFactory")
    public MongoDbFactory personMongoDbFactory() {
        MongoCredential mongoCredential = MongoCredential.createCredential("root", "admin", "example".toCharArray());
        return new SimpleMongoClientDbFactory(
                MongoClients.create(new ConnectionString("mongodb://127.0.0.1:27017")), "testdb2"
        );
    }

}
