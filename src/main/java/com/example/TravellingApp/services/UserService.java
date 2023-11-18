package com.example.TravellingApp.services;

import com.example.TravellingApp.entities.User;
import com.example.TravellingApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;
  @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user) {
      userRepository.saveUser(user);
      return user;
    }


    public User findUserById(int id){

      return userRepository.findUserById(id);
    }

  public List<User> getAllUsers() {
    return userRepository.getAllUsers();

  }

  public void deleteUserById(int id) {
    userRepository.deleteUserById(id);
  }

  public User updateUser(User user) {
    return userRepository.updateUser(user);
  }
}
