package com.oaes.workspace.service;

import com.oaes.exception.ResourceNotFoundException;
import com.oaes.workspace.dto.WorkspaceRequest;
import com.oaes.workspace.dto.WorkspaceResponse;
import com.oaes.workspace.entity.Workspace;
import com.oaes.workspace.repository.WorkspaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WorkspaceService {

    private final WorkspaceRepository workspaceRepository;

    public WorkspaceResponse createWorkspace(WorkspaceRequest request) {

        Workspace workspace = Workspace.builder()
                .name(request.getName())
                .description(request.getDescription())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        workspace = workspaceRepository.save(workspace);

        return map(workspace);
    }

    public List<WorkspaceResponse> getAllWorkspaces() {

        return workspaceRepository.findAll()
                .stream()
                .map(this::map)
                .toList();
    }

    public WorkspaceResponse getWorkspace(UUID id) {

        Workspace workspace = workspaceRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Workspace not found"));

        return map(workspace);
    }

    public void deleteWorkspace(UUID id) {

        Workspace workspace = workspaceRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Workspace not found"));

        workspaceRepository.delete(workspace);
    }

    private WorkspaceResponse map(Workspace workspace) {

        return WorkspaceResponse.builder()
                .id(workspace.getId())
                .name(workspace.getName())
                .description(workspace.getDescription())
                .createdAt(workspace.getCreatedAt())
                .updatedAt(workspace.getUpdatedAt())
                .build();
    }
}