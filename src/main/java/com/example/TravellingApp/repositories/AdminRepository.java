package com.example.TravellingApp.repositories;

import com.example.TravellingApp.entities.Destination;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class AdminRepository {

    private EntityManager entityManager;

    public AdminRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
      @Transactional
    public void deleteDestinationById(int id) {
        Destination foundDestination = entityManager.find(Destination.class, id);
        entityManager.remove(foundDestination);
    }
      @Transactional
    public void saveDestination(Destination destination) {
         entityManager.persist(destination);


    }
      @Transactional
    public Destination updateDestinationByd(Destination destination) {
        entityManager.merge(destination);
        return destination;

    }
}
