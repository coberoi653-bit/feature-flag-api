package com.example.demo.Service;

import com.example.demo.Model.Organisation;
import com.example.demo.Model.Project;
import com.example.demo.Repository.OrganisationRepository;
import com.example.demo.Repository.ProjectRepository;
import com.example.demo.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProjectService {

    OrganisationService organisationService;
    ProjectRepository projectRepository;
    public ProjectService(OrganisationService organisationService ,ProjectRepository projectRepository){
        this.organisationService=organisationService;
        this.projectRepository=projectRepository;

    }
    public Project create(UUID organisationId, String name){
        Organisation organisation = organisationService.getById(organisationId);
        Project project = new Project(UUID.randomUUID(),organisation.getId(),name);
        return projectRepository.save(project);
    }


    public Project getById(UUID id){
        return projectRepository.findById(id).orElseThrow(() -> new NotFoundException("Project " + id + " not found"));
     }

     public List<Project> getByOrganisationId(UUID organisationId){
        organisationService.getById(organisationId);
       return projectRepository.findByOrganisationId(organisationId);
     }

}
