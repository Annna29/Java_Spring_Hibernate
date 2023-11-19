package com.example.TravellingApp.repositories;

import com.example.TravellingApp.entities.Destination;
import jakarta.persistence.EntityManager;
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
        TypedQuery<Destination> results = entityManager.createQuery("from Destination" , Destination.class);
        return results.getResultList();


    }

    public Destination getDestinationById(int id) {
        Destination foundDestination = entityManager.find(Destination.class,id);
       // System.out.println(foundDestination.getHotelName()+" " + foundDestination.getCountry());
        return foundDestination;
    }
}
