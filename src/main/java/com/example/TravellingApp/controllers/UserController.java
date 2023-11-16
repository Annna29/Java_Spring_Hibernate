package com.example.TravellingApp.controllers;

import com.example.TravellingApp.entities.User;
import com.example.TravellingApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/user")
public class UserController {
    private UserService userService;
  @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public ResponseEntity<User>addUser (@RequestBody User user){

      return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User>findUserById(@PathVariable  int id){
      return new ResponseEntity<>(userService.findUserById(id), HttpStatus.OK);
    }


}