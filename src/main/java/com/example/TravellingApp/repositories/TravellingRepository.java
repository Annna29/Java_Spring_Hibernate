package com.example.TravellingApp.repositories;

import com.example.TravellingApp.entities.Destination;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TravellingRepository {

    private EntityManager entityManager;

    public TravellingRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Destination> getAllDestinations() {
        TypedQuery<Destination> results = entityManager.createQuery("FROM Destination" , Destination.class);
        return results.getResultList();


    }

    public Destination getDestinationById(int id) {
        Destination foundDestination = entityManager.find(Destination.class,id);
       // System.out.println(foundDestination.getHotelName()+" " + foundDestination.getCountry());
        return foundDestination;
    }


    public List<Destination> getPetFriendlyDestination() {
        TypedQuery<Destination> results = entityManager.createQuery("FROM Destination WHERE isPetFriendly = true", Destination.class);
        return results.getResultList();
    }



    public List<Destination> getDestinationByHotelName(String hotelName) {
        TypedQuery<Destination> results = entityManager.createQuery("FROM Destination WHERE hotelName like :hotelName", Destination.class);
        results.setParameter("hotelName", "%" + hotelName + "%");
        return results.getResultList();
    }

    public List<Destination> getDestinationByPet(boolean isPetFriendly) {
        TypedQuery<Destination> results = entityManager.createQuery("FROM Destination WHERE isPetFriendly = :isPetFriendly", Destination.class);
        results.setParameter("isPetFriendly", isPetFriendly);
    return results.getResultList();}

    public List<Destination> getDestinationByCountry(String countryName) {
        int countryType=0;

        if(countryName.equalsIgnoreCase("romania"))
            countryType=1;
        if(countryName.equalsIgnoreCase("greece"))
            countryType=2;
        if(countryName.equalsIgnoreCase("italy"))
            countryType=3;
        if(countryName.equalsIgnoreCase("spain"))
            countryType=4;
        if(countryName.equalsIgnoreCase("hungary"))
            countryType=5;
        if(countryName.equalsIgnoreCase("germany"))
            countryType=6;
        if(countryName.equalsIgnoreCase("norway"))
            countryType=7;
        if(countryName.equalsIgnoreCase("japan"))
            countryType=9;
        if(countryName.equalsIgnoreCase("portugal"))
            countryType=10;
        if(countryName.equalsIgnoreCase("france"))
            countryType=8;


        String qString= String.format("Select * from Destination where country = %d ",countryType);
        Query q = entityManager.createNativeQuery(qString, Destination.class);
        return q.getResultList();
    }

    public List<Destination> getDestinationByHotelRating(int hotelRating) {
        TypedQuery<Destination> results = entityManager.createQuery("FROM Destination WHERE hotelRating =: hotelRating",Destination.class);
        results.setParameter("hotelRating", hotelRating);
        return results.getResultList();


    }

    public List<Destination> getDestinationByPriceRange(int min, int max) {
        TypedQuery<Destination> results = entityManager.createQuery("FROM Destination WHERE price> : min AND price< :max", Destination.class);
        results.setParameter("min", min);
        results.setParameter("max", max);
        return results.getResultList();

    }

    public List<Destination> getDestinationByCustomFilter(int min, int max, int hotelMin, int hotelMax) {
        TypedQuery<Destination> results = entityManager.createQuery("FROM Destination WHERE price>=:min AND price<= :max " +
                "AND hotelRating>= :hotelMin AND hotelRating<=:hotelMax AND isPetFriendly = true", Destination.class);
        results.setParameter("min",min);
        results.setParameter("max",max);
        results.setParameter("hotelMin",hotelMin);
        results.setParameter("hotelMax", hotelMax);
        return results.getResultList();
    }
}
