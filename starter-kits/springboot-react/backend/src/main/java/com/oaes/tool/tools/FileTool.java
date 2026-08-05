package com.oaes.tool.tools;

import com.oaes.storage.service.WorkspaceStorageService;
import com.oaes.tool.dto.ToolRequest;
import com.oaes.tool.dto.ToolResponse;
import com.oaes.tool.enums.FileAction;
import com.oaes.tool.enums.ToolType;
import com.oaes.tool.service.Tool;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class FileTool implements Tool {

    private final WorkspaceStorageService workspaceStorageService;

    @Override
    public ToolType getType() {
        return ToolType.FILE;
    }

    @Override
    public ToolResponse execute(ToolRequest request) {

        try {

            FileAction action =
                    FileAction.valueOf(request.getAction().toUpperCase());

            Path file = workspaceStorageService.resolvePath(
                    request.getWorkspaceId(),
                    request.getPath()
            );

            switch (action) {

                case CREATE -> {

                    if (file.getParent() != null) {
                        Files.createDirectories(file.getParent());
                    }

                    if (request.getContent() != null &&
                            !request.getContent().isBlank()) {

                        Files.writeString(file, request.getContent());

                    } else {

                        if (Files.notExists(file)) {
                            Files.createFile(file);
                        }

                    }

                    return success(
                            "Created: " + request.getPath(),
                            file.toString()
                    );
                }

                case WRITE -> {

                    if (file.getParent() != null) {
                        Files.createDirectories(file.getParent());
                    }

                    Files.writeString(file, request.getContent());

                    return success(
                            "Written: " + request.getPath(),
                            file.toString()
                    );
                }

                case READ -> {

                    String content = Files.readString(file);

                    return success(
                            "Read: " + request.getPath(),
                            content
                    );
                }
                case UPDATE -> {

    if (file.getParent() != null) {
        Files.createDirectories(file.getParent());
    }

    Files.writeString(file, request.getContent());

    return success("File updated.", file.toString());

}

                case DELETE -> {

                    Files.deleteIfExists(file);

                    return success(
                            "Deleted: " + request.getPath(),
                            file.toString()
                    );
                }

                case LIST -> {

                    List<String> files = Files.list(file)
                            .map(Path::getFileName)
                            .map(Path::toString)
                            .toList();

                    return success(
                            "Listed: " + request.getPath(),
                            files
                    );
                }

                default ->
                        throw new RuntimeException("Unknown file action.");

            }

        } catch (Exception e) {

            e.printStackTrace();

            return ToolResponse.builder()
                    .success(false)
                    .message(e.getMessage())
                    .data(null)
                    .timestamp(LocalDateTime.now())
                    .build();

        }

    }

    private ToolResponse success(String message, Object data) {

        return ToolResponse.builder()
                .success(true)
                .message(message)
                .data(data)
                .timestamp(LocalDateTime.now())
                .build();

    }

}