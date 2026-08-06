package com.oaes.memory.service;

import com.oaes.memory.model.ProjectFile;
import com.oaes.storage.service.WorkspaceStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ProjectMemoryService {

    private final WorkspaceStorageService workspaceStorageService;

    public List<ProjectFile> load(UUID workspaceId)
            throws IOException {

        Path root =
                workspaceStorageService.getWorkspaceRoot(workspaceId);

        List<ProjectFile> files =
                new ArrayList<>();

        try (Stream<Path> stream = Files.walk(root)) {

            stream.filter(Files::isRegularFile)
                    .filter(path -> path.toString().endsWith(".java"))
                    .forEach(path -> {

                        try {

                            files.add(
                                    ProjectFile.builder()
                                            .path(root.relativize(path).toString())
                                            .content(Files.readString(path))
                                            .build()
                            );

                        } catch (IOException ignored) {
                        }

                    });

        }

        return files;
    }

}