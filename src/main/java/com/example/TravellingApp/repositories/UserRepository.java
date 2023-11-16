package com.example.TravellingApp.repositories;

import com.example.TravellingApp.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Transient;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    private EntityManager entityManager;
     @Autowired
    public UserRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Transactional
    public void saveUser(User user){
         entityManager.persist(user);
    }

    public User findUserById(int id) {

         return entityManager.find(User.class,id);

    }
}
