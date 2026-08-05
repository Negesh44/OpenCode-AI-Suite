package com.oaes.build.service;

import com.oaes.build.dto.FileFix;
import com.oaes.storage.service.WorkspaceStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileRewriteService {

    private final WorkspaceStorageService workspaceStorageService;

    public void rewrite(
            UUID workspaceId,
            List<FileFix> files
    ) throws Exception {

        for (FileFix fileFix : files) {

            Path file =
                    workspaceStorageService.resolvePath(
                            workspaceId,
                            fileFix.getPath()
                    );

            if (file.getParent() != null) {
                Files.createDirectories(file.getParent());
            }

            Files.writeString(
                    file,
                    fileFix.getContent()
            );

            System.out.println("Updated : " + file);

        }

    }

}