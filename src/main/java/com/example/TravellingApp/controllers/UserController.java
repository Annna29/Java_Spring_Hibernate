package com.example.TravellingApp.controllers;

import com.example.TravellingApp.entities.User;
import com.example.TravellingApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/user")
public class UserController {
    private UserService userService;
  @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // add a new user
    @PostMapping
    public ResponseEntity<User>addUser (@RequestBody User user){
      return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
    }
   // get user by id
    @GetMapping("/{id}")
    public ResponseEntity<User>findUserById(@PathVariable  int id){
      return new ResponseEntity<>(userService.findUserById(id), HttpStatus.OK);
    }
    // get all users
    @GetMapping
     public ResponseEntity<List<User>> getAllUsers(){
     return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }
    // delete user by id
    @DeleteMapping("/{id}")
     public ResponseEntity<Void>deleteUserById(@PathVariable int id){
      userService.deleteUserById(id);
    return new ResponseEntity(HttpStatus.OK);
    }
    // update a user
    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user){

      return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
    }



}
