package com.example.TravellingApp.controllers;

import com.example.TravellingApp.entities.Destination;
import com.example.TravellingApp.services.TravellingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(path="/destinations")
public class TravellingController {

    private TravellingService travellingService;


    @Autowired
    public TravellingController(TravellingService travellingService) {
        this.travellingService = travellingService;
    }



    @GetMapping
    public List<Destination> getAllDestinations(){
        return travellingService.getAllDestinations();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Destination> getDestinationById(@PathVariable int id){
        return new ResponseEntity<>(travellingService.getDestinationById(id), HttpStatus.OK);
    }




}
