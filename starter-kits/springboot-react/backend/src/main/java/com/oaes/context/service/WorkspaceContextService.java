package com.oaes.context.service;

import com.oaes.context.model.ProjectContext;
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
public class WorkspaceContextService {

    private final WorkspaceStorageService workspaceStorageService;

    public ProjectContext build(UUID workspaceId) throws IOException {

        Path root =
                workspaceStorageService.getWorkspaceRoot(workspaceId);

        List<String> controllers = new ArrayList<>();
        List<String> services = new ArrayList<>();
        List<String> repositories = new ArrayList<>();
        List<String> entities = new ArrayList<>();
        List<String> dtos = new ArrayList<>();
        List<String> configs = new ArrayList<>();
        List<String> files = new ArrayList<>();

        try (Stream<Path> stream = Files.walk(root)) {

            stream.filter(Files::isRegularFile)
                    .forEach(path -> {

                        String name = path.getFileName().toString();

                        files.add(root.relativize(path).toString());

                        if (name.endsWith("Controller.java")) {
                            controllers.add(name);
                        }

                        if (name.endsWith("Service.java")) {
                            services.add(name);
                        }

                        if (name.endsWith("Repository.java")) {
                            repositories.add(name);
                        }

                        if (name.endsWith("Entity.java")) {
                            entities.add(name);
                        }

                        if (name.endsWith("DTO.java")) {
                            dtos.add(name);
                        }

                        if (name.contains("Config")) {
                            configs.add(name);
                        }

                    });

        }

        return ProjectContext.builder()
                .projectName(root.getFileName().toString())
                .controllers(controllers)
                .services(services)
                .repositories(repositories)
                .entities(entities)
                .dtos(dtos)
                .configs(configs)
                .files(files)
                .build();
    }

}