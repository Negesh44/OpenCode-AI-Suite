package com.oaes.context.service;

import com.oaes.context.model.ProjectContext;
import com.oaes.storage.service.WorkspaceStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProjectContextService {

    private final WorkspaceStorageService storageService;

    public ProjectContext build(UUID workspaceId)
            throws IOException {

        Path root =
                storageService.getWorkspaceRoot(workspaceId);

        HashMap<String, String> files =
                new HashMap<>();

        Files.walk(root)
                .filter(Files::isRegularFile)
                .forEach(path -> {

                    try {

                        files.put(
                                root.relativize(path).toString(),
                                Files.readString(path)
                        );

                    } catch (IOException ignored) {
                    }

                });

        return ProjectContext.builder()
                .workspaceName(root.getFileName().toString())
                .files(files)
                .build();

    }

}