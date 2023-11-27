package com.example.TravellingApp.services;

import com.example.TravellingApp.entities.Destination;
import com.example.TravellingApp.repositories.TravellingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravellingService {

   private TravellingRepository travellingRepository;

    public TravellingService(TravellingRepository travellingRepository) {
        this.travellingRepository = travellingRepository;
    }

    public List<Destination> getAllDestinations(){
        return travellingRepository.getAllDestinations();
    }

    public Destination getDestinationById(int id) {
        return travellingRepository.getDestinationById(id);
    }


    public List<Destination> getPetFriendlyDestination() {
        return travellingRepository.getPetFriendlyDestination();
    }



    public List<Destination> getDestinationByHotelName(String hotelName) {
        return travellingRepository.getDestinationByHotelName(hotelName);
    }

    public List<Destination> getDestinationByPet(boolean isPetFriendly) {
        return travellingRepository.getDestinationByPet(isPetFriendly);
    }

    public List<Destination> getDestinationByCountry(String countryName) {
        return travellingRepository.getDestinationByCountry(countryName);
    }

    public List<Destination> getDestinationByHotelRating(int hotelRating) {
        return travellingRepository.getDestinationByHotelRating(hotelRating);
    }

    public List<Destination> getDestinationByPriceRange(int min, int max) {
        return travellingRepository.getDestinationByPriceRange(min,max);
    }

    public List<Destination> getDestinationByCustomFilter(int min, int max, int hotelMin, int hotelMax) {
        return travellingRepository.getDestinationByCustomFilter(min,max,hotelMin,hotelMax);
    }
}
