package com.example.demo.Repository;

import com.example.demo.Model.Organisation;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrganisationRepository {

    Organisation save(Organisation organisation);

    List<Organisation> findAll();

    Optional<Organisation> findById(UUID id);

}