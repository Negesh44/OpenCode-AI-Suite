package com.oaes.git.service;

import com.oaes.git.dto.CommitRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GitAutomationService {

    private final GitService gitService;

    public void autoCommit(UUID workspaceId, String goal) {

        try {

            gitService.init(workspaceId);

        } catch (Exception ignored) {
        }

        try {

            gitService.addAll(workspaceId);

            CommitRequest request = CommitRequest.builder()
                    .message("AI: " + goal)
                    .build();

            gitService.commit(
                    workspaceId,
                    request
            );

        } catch (Exception ignored) {
        }

    }

}