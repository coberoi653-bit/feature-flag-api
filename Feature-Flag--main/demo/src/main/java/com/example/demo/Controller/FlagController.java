package com.example.demo.Controller;

import com.example.demo.Model.Flag;
import com.example.demo.Service.FlagService;
import com.example.demo.dto.CreateFlagRequest;
import com.example.demo.dto.UpdateFlagStateRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class FlagController {
    private final FlagService flagService;

    public FlagController(FlagService flagService) {
        this.flagService = flagService;
    }

    @PostMapping("/orgs/{orgId}/projects/{projectId}/flags")
    @ResponseStatus(HttpStatus.CREATED)
    public Flag create(@PathVariable UUID projectId, @Valid @RequestBody CreateFlagRequest request) {
        return flagService.create(projectId, request.key(), request.name());
    }

    @GetMapping("/projects/{projectId}/flags")
    public List<Flag> getAllForProject(@PathVariable UUID projectId) {
        return flagService.getAllForProject(projectId);
    }

    @GetMapping("/flags/{flagId}")
    public Flag getById(@PathVariable UUID flagId) {
        return flagService.getById(flagId);
    }

    @PutMapping("/flags/{flagId}/state")
    public Flag setState(@PathVariable UUID flagId, @Valid @RequestBody UpdateFlagStateRequest request) {
        return flagService.setEnabled(flagId, request.enabled());
    }
}

