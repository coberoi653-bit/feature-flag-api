package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;

public record CraeteOrganisationRequest ( @NotBlank  String name){}
