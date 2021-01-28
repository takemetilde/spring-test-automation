package com.org.db.mongo.user;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Document(value = "user")
public class UserMongo {

    @Id
    private String id;

    private String name;

    private String email;

    public UserMongo(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
