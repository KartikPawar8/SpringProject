package com.city.mode.model;

public class MyModel {

    private Long id;
    private String name;

    // Constructors
    public MyModel() {
    }

    public MyModel(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // toString, equals, and hashCode methods can be added as needed
}
