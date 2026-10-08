package com.example.demo.Repository;

import com.example.demo.Model.Organisation;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryOrganisationRepository implements OrganisationRepository{

    private final Map<UUID, Organisation> store = new ConcurrentHashMap<>();

    @Override

    public Organisation save( Organisation organisation){
        store.put(organisation.getId(), organisation);
        return organisation;
    }

    @Override

    public List<Organisation> findAll(){
        return new ArrayList<>(store.values());
    }
    @Override
    public Optional<Organisation> findById(UUID id){
        return Optional.ofNullable(store.get(id));
    }


}
