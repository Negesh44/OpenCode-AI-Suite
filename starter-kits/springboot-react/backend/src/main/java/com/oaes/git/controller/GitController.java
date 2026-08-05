package com.oaes.git.controller;

import com.oaes.git.dto.CommitRequest;
import com.oaes.git.dto.GitStatusResponse;
import com.oaes.git.service.GitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/git")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class GitController {

    private final GitService gitService;

    @PostMapping("/init")
    public ResponseEntity<String> init(
            @RequestParam UUID workspaceId
    ) throws Exception {

        return ResponseEntity.ok(
                gitService.init(workspaceId)
        );

    }

    @GetMapping("/status")
    public ResponseEntity<GitStatusResponse> status(
            @RequestParam UUID workspaceId
    ) throws Exception {

        return ResponseEntity.ok(
                gitService.status(workspaceId)
        );

    }

    @PostMapping("/add")
    public ResponseEntity<String> add(
            @RequestParam UUID workspaceId
    ) throws Exception {

        return ResponseEntity.ok(
                gitService.addAll(workspaceId)
        );

    }

    @PostMapping("/commit")
    public ResponseEntity<String> commit(
            @RequestParam UUID workspaceId,
            @RequestBody CommitRequest request
    ) throws Exception {

        return ResponseEntity.ok(
                gitService.commit(workspaceId, request)
        );

    }

    @GetMapping("/log")
    public ResponseEntity<String> log(
            @RequestParam UUID workspaceId
    ) throws Exception {

        return ResponseEntity.ok(
                gitService.log(workspaceId)
        );

    }

    @GetMapping("/branches")
    public ResponseEntity<String> branches(
            @RequestParam UUID workspaceId
    ) throws Exception {

        return ResponseEntity.ok(
                gitService.branches(workspaceId)
        );

    }

    @PostMapping("/checkout")
    public ResponseEntity<String> checkout(
            @RequestParam UUID workspaceId,
            @RequestParam String branch
    ) throws Exception {

        return ResponseEntity.ok(
                gitService.checkout(
                        workspaceId,
                        branch
                )
        );

    }

    @PostMapping("/create-branch")
    public ResponseEntity<String> createBranch(
            @RequestParam UUID workspaceId,
            @RequestParam String branch
    ) throws Exception {

        return ResponseEntity.ok(
                gitService.createBranch(
                        workspaceId,
                        branch
                )
        );

    }

}