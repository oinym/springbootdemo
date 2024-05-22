package com.leumi.springboot3demo.users;


public record User(String id,
        String firstName,
        String lastName,
        String email,
        int age) {

    public User(String id, String firstName, String lastName, String email, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

}
