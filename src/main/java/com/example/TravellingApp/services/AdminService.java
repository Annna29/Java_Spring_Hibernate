package com.example.TravellingApp.services;

import com.example.TravellingApp.entities.Destination;
import com.example.TravellingApp.repositories.AdminRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public void deleteDestinationById(int id) {
         adminRepository.deleteDestinationById(id);
    }

    public Destination addNewDestination(Destination destination) {
        adminRepository.saveDestination(destination);
        return destination ;
    }

    public Destination updateDestinationById(Destination destination) {
       return adminRepository.updateDestinationByd(destination);
    }
}
