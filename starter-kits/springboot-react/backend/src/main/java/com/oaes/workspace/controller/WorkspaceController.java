package com.oaes.workspace.controller;

import com.oaes.workspace.dto.WorkspaceRequest;
import com.oaes.workspace.dto.WorkspaceResponse;
import com.oaes.workspace.service.WorkspaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/workspaces")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class WorkspaceController {

    private final WorkspaceService workspaceService;

    @PostMapping
    public ResponseEntity<WorkspaceResponse> createWorkspace(
            @RequestBody WorkspaceRequest request) {

        return ResponseEntity.ok(
                workspaceService.createWorkspace(request)
        );
    }

    @GetMapping
    public ResponseEntity<List<WorkspaceResponse>> getAllWorkspaces() {

        return ResponseEntity.ok(
                workspaceService.getAllWorkspaces()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkspaceResponse> getWorkspace(
            @PathVariable UUID id) {

        return ResponseEntity.ok(
                workspaceService.getWorkspace(id)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkspace(
            @PathVariable UUID id) {

        workspaceService.deleteWorkspace(id);

        return ResponseEntity.noContent().build();
    }
}