package com.example.demo.Controller;

import com.example.demo.Model.Organisation;
import com.example.demo.Service.OrganisationService;
import com.example.demo.dto.CraeteOrganisationRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/orgs")
public class OrganisationController {

    OrganisationService organisationService;
    public OrganisationController(OrganisationService organizationService){
        this.organisationService =organizationService;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)

    public Organisation create(@Valid @RequestBody CraeteOrganisationRequest request){
        return organisationService.create(request.name());
    }

    @GetMapping
    public List<Organisation> getAll() {
        return organisationService.getAll();
    }

    @GetMapping ("/{orgId}")
    public Organisation getById(@PathVariable UUID orgId){

        return organisationService.getById(orgId);
    }
}
