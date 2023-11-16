package com.example.TravellingApp.entities;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profileId")
    private Profile profile;


    public User() {
    }

    public User(Profile profile) {
        this.profile = profile;
    }

    public User(int id, Profile profile) {
        this.id = id;
        this.profile = profile;
    }

    public User(int id) {
        this.id = id;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
