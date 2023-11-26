package com.example.TravellingApp.entities;

import com.example.TravellingApp.util.Country;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;


@Entity
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private  int id;
   private boolean isPetFriendly;
   @NotNull
   private String hotelName;
   private int price;
   private int hotelRating;
   private Country country;

    public Destination() {
    }

    public Destination(boolean isPetFriendly, String hotelName, int price, int hotelRating, Country country) {
        this.isPetFriendly = isPetFriendly;
        this.hotelName = hotelName;
        this.price = price;
        this.hotelRating = hotelRating;
        this.country = country;
    }

    public Destination(int id, boolean isPetFriendly, String hotelName, int price, int hotelRating, Country country) {
        this.id = id;
        this.isPetFriendly = isPetFriendly;
        this.hotelName = hotelName;
        this.price = price;
        this.hotelRating = hotelRating;
        this.country = country;
    }

    public boolean isPetFriendly() {
        return isPetFriendly;
    }

    public void setPetFriendly(boolean petFriendly) {
        isPetFriendly = petFriendly;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getHotelRating() {
        return hotelRating;
    }

    public void setHotelRating(int hotelRating) {
        this.hotelRating = hotelRating;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
