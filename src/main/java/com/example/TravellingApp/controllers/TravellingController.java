package com.example.TravellingApp.controllers;

import com.example.TravellingApp.entities.Destination;
import com.example.TravellingApp.services.TravellingService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path="/destinations")
@Validated
public class TravellingController {

    private TravellingService travellingService;


    @Autowired
    public TravellingController(TravellingService travellingService) {
        this.travellingService = travellingService;
    }


    // get all destinations
    @GetMapping
    public List<Destination> getAllDestinations(){
        return travellingService.getAllDestinations();
    }

    // get destination by id
    @GetMapping("/{id}")
    public ResponseEntity<Destination> getDestinationById(@PathVariable int id){
        return new ResponseEntity<>(travellingService.getDestinationById(id), HttpStatus.OK);
    }
    // get just pet friendly destinations
    @GetMapping("/petfriendly-destinations")
    public ResponseEntity<List<Destination>> getPetFriendlyDestination(){

        return new ResponseEntity<>(travellingService.getPetFriendlyDestination(),HttpStatus.OK);
    }

    // get destinations with filter by hotel name
    @GetMapping("/hotel-name")
    public ResponseEntity<List<Destination>>getDestinationByHotelName(@RequestParam(required = false)String hotelName){
        return new ResponseEntity<>(travellingService.getDestinationByHotelName(hotelName), HttpStatus.OK);
    }

    // get destinations by boolean filter isPetFriendly ( T / F)
    @GetMapping("/pet-friendly-destination")
    public ResponseEntity<List<Destination>>getNotPetFriendlyDestination(@RequestParam(required = false)boolean isPetFriendly){
        return new ResponseEntity<>(travellingService.getDestinationByPet(isPetFriendly),HttpStatus.OK);
    }
    // get destinations by country
    @GetMapping("/country")
    public ResponseEntity<List<Destination>>getDestinationByCountry(@RequestParam String countryName){
        return new ResponseEntity<>(travellingService.getDestinationByCountry(countryName), HttpStatus.OK);
    }
    // get destinations by hotel-rating
    @GetMapping("/hotel-rating-destinations")
    public ResponseEntity<List<Destination>>getDestinationByHotelRating(@RequestParam int hotelRating){
        return new ResponseEntity<>(travellingService.getDestinationByHotelRating(hotelRating),HttpStatus.OK);
    }
    // get destinations by price range ( min, max)
    @GetMapping("/price-range")
    public ResponseEntity<List<Destination>>getDestinationByPriceRange(@RequestParam @Min(35) @Max(6000) int min, @RequestParam @Min(35) @Max(6000) int max){
        return new ResponseEntity<>(travellingService.getDestinationByPriceRange(min,max),HttpStatus.OK);
    }



}
