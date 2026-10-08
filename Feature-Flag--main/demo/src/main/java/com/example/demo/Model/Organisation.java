package com.example.demo.Model;

import java.util.UUID;

public class Organisation {
    private final UUID id;
    private final String name;

     public Organisation(UUID id, String name){
        this.id=id;
        this.name=name;
    }
    public UUID getId(){
        return id;
    }
    public String getName(){
        return name;
    }
}
