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
}
