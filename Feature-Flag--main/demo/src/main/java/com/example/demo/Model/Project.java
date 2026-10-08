package com.example.demo.Model;

import java.util.UUID;

public class Project {
    private final UUID id;
    private final UUID organisationId;
    private final String name;

     public Project (UUID id, UUID organisationId, String name){
         this.id=id;
         this.organisationId=organisationId;
         this.name=name;
     }

    public UUID getId() {
        return id;
    }

    public UUID getOrganisationId() {
        return organisationId;
    }

    public String getName() {
        return name;
    }
}
