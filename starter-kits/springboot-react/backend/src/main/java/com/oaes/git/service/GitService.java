package com.oaes.git.service;

import com.oaes.git.dto.CommitRequest;
import com.oaes.git.dto.GitStatusResponse;
import com.oaes.git.util.GitCommandRunner;
import com.oaes.storage.service.WorkspaceStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GitService {

    private final GitCommandRunner gitRunner;
    private final WorkspaceStorageService storageService;

    private Path workspace(UUID workspaceId) {

        return storageService.getWorkspaceRoot(workspaceId);

    }

    public String init(UUID workspaceId) throws Exception {

        return gitRunner.run(
                workspace(workspaceId),
                "git",
                "init"
        );

    }

    public GitStatusResponse status(UUID workspaceId)
            throws Exception {

        String result = gitRunner.run(
                workspace(workspaceId),
                "git",
                "status"
        );

        return GitStatusResponse.builder()
                .repository(true)
                .status(result)
                .build();

    }

    public String addAll(UUID workspaceId)
            throws Exception {

        return gitRunner.run(
                workspace(workspaceId),
                "git",
                "add",
                "."
        );

    }

    public String commit(
            UUID workspaceId,
            CommitRequest request
    ) throws Exception {

        return gitRunner.run(
                workspace(workspaceId),
                "git",
                "commit",
                "-m",
                request.getMessage()
        );

    }

    public String branches(UUID workspaceId)
            throws Exception {

        return gitRunner.run(
                workspace(workspaceId),
                "git",
                "branch"
        );

    }

    public String checkout(
            UUID workspaceId,
            String branch
    ) throws Exception {

        return gitRunner.run(
                workspace(workspaceId),
                "git",
                "checkout",
                branch
        );

    }

    public String createBranch(
            UUID workspaceId,
            String branch
    ) throws Exception {

        return gitRunner.run(
                workspace(workspaceId),
                "git",
                "checkout",
                "-b",
                branch
        );

    }

    public String log(UUID workspaceId)
            throws Exception {

        return gitRunner.run(
                workspace(workspaceId),
                "git",
                "log",
                "--oneline"
        );

    }

}