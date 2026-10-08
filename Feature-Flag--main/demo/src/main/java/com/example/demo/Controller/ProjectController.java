package com.example.demo.Controller;

import com.example.demo.Model.Project;
import com.example.demo.Service.ProjectService;
import com.example.demo.dto.CreateProjectRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class ProjectController {
    ProjectService projectService;
     public ProjectController(ProjectService projectService){
         this.projectService=projectService;
     }

     @PostMapping ("/orgs/{orgId}/projects")
     @ResponseStatus(HttpStatus.CREATED)
    public Project create(@PathVariable UUID orgId, @Valid @RequestBody CreateProjectRequest request){
        return projectService.create(orgId,request.name());
     }

     @GetMapping("/projects/{projectId}")
    public Project getById(@PathVariable UUID projectId){
         return projectService.getById(projectId);
     }

     @GetMapping("/orgs/{orgId}/projects")
     public List<Project> getByOrganisationId(@PathVariable UUID orgId){
         return projectService.getByOrganisationId(orgId);
     }
}
