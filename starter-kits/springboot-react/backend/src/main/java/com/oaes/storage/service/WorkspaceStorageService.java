package com.oaes.storage.service;

import com.oaes.exception.ResourceNotFoundException;
import com.oaes.storage.config.StorageProperties;
import com.oaes.workspace.entity.Workspace;
import com.oaes.workspace.repository.WorkspaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WorkspaceStorageService {

    private final StorageProperties properties;
    private final WorkspaceRepository workspaceRepository;

    public Path getWorkspaceRoot(UUID workspaceId) {

        Workspace workspace = workspaceRepository.findById(workspaceId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Workspace not found"));

        String folderName =
                workspace.getName().replaceAll("[^a-zA-Z0-9-_]", "_")
                        + "-"
                        + workspace.getId();

        return Path.of(
                properties.getWorkspaceRoot(),
                folderName
        );
    }

    public Path resolvePath(UUID workspaceId, String relativePath) {

        Path root = getWorkspaceRoot(workspaceId);

        Path resolved = root.resolve(relativePath).normalize();

        if (!resolved.startsWith(root)) {
            throw new RuntimeException("Access outside workspace is not allowed.");
        }

        return resolved;
    }

    public void initializeWorkspace(Workspace workspace)
            throws IOException {

        Path root = getWorkspaceRoot(workspace.getId());

        Files.createDirectories(root);

        Files.createDirectories(root.resolve("backend"));
        Files.createDirectories(root.resolve("frontend"));
        Files.createDirectories(root.resolve("docs"));
        Files.createDirectories(root.resolve(".oaes"));

        Path readme = root.resolve("README.md");

        if (Files.notExists(readme)) {

            Files.writeString(
                    readme,
                    "# " + workspace.getName() + "\n\nCreated by OAES.\n"
            );

        }

    }

}