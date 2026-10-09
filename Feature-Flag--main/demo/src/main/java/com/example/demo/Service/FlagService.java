package com.example.demo.Service;

import com.example.demo.Model.Flag;
import com.example.demo.Model.Project;
import com.example.demo.Repository.FlagRepository;
import com.example.demo.exception.ConflictException;
import com.example.demo.exception.NotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FlagService {
    private final ProjectService projectService;
    private final FlagRepository flagRepository;

    public FlagService(ProjectService projectService, FlagRepository flagRepository) {
        this.projectService = projectService;
        this.flagRepository = flagRepository;
    }

    public Flag create(UUID projectId, String key, String name) {
        Project project = projectService.getById(projectId);  // 404 if it doesn't exist

        if (flagRepository.existsByProjectIdAndKey(projectId, key)) {
            throw new ConflictException("A flag with key '" + key + "' already exists in this project");
        }

        Flag flag = new Flag(UUID.randomUUID(), project.getOrganisationId(), project.getId(), key, name, false);
        return flagRepository.save(flag);
    }

    public Flag getById(UUID id) {
        return flagRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Flag " + id + " not found"));
    }

    public List<Flag> getAllForProject(UUID projectId) {
        projectService.getById(projectId);  // 404 if it doesn't exist
        return flagRepository.findByProjectId(projectId);
    }

    public Flag setEnabled(UUID flagId, boolean enabled) {
        Flag flag = getById(flagId);
        flag.setEnabled(enabled);
        return flagRepository.save(flag);
    }
    public void deleteById(UUID id){
        flagRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Flag " + id + " not found"));
        flagRepository.deleteFlag(id);
    }
}
