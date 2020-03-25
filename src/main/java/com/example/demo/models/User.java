package com.example.demo.models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Integer id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
