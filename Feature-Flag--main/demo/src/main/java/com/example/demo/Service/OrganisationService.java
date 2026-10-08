package com.example.demo.Service;

import com.example.demo.Model.Organisation;
import com.example.demo.Repository.OrganisationRepository;
import com.example.demo.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrganisationService {

    OrganisationRepository organisationRepository;
    public OrganisationService(OrganisationRepository organisationRepository){
        this.organisationRepository=organisationRepository;
    }

    public Organisation create(String name){
        Organisation organisation = new Organisation(UUID.randomUUID(),name);
        return organisationRepository.save(organisation);

    }

     public List<Organisation> getAll(){

        return organisationRepository.findAll();
     }
     public Organisation getById(UUID id){
        return organisationRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Organisation" + id + "Not Found"));
     }
}
