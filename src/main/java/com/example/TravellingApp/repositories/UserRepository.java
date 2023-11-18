package com.example.TravellingApp.repositories;

import com.example.TravellingApp.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Transient;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    public List<User> getAllUsers() {
        TypedQuery<User> results = entityManager.createQuery("from User", User.class);
        return results.getResultList();
    }

    @Transactional
    public void deleteUserById(int id) {
         User foundUser = entityManager.find(User.class,id);
         entityManager.remove(foundUser);
    }
        @Transactional
    public User updateUser(User user) {
         return entityManager.merge(user);
    }
}
