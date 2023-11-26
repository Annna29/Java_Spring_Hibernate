package com.example.TravellingApp.controllers;

import com.example.TravellingApp.entities.Destination;
import com.example.TravellingApp.services.AdminService;
//import jakarta.validation.Valid;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private AdminService adminService;
     @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @DeleteMapping("/{id}")
    public void deleteDestinationById(@PathVariable int id){
         adminService.deleteDestinationById(id);


    }
    @PostMapping
    public ResponseEntity<Destination> addNewDestination(@Valid @RequestBody Destination destination){
         return new ResponseEntity<>(adminService.addNewDestination(destination), HttpStatus.CREATED);

    }

    @PutMapping
    public ResponseEntity<Destination> updateDestinationById(@RequestBody Destination destination){
         return new ResponseEntity<>(adminService.updateDestinationById(destination), HttpStatus.CREATED);

    }




}
