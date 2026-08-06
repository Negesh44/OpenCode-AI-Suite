package com.oaes.memory.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectRetrieverService {

    public List<String> retrieve(
            List<String> projectFiles,
            String goal
    ) {

        if (projectFiles == null || projectFiles.isEmpty()) {
            return List.of();
        }

        String[] keywords = goal
                .toLowerCase()
                .replaceAll("[^a-z0-9 ]", " ")
                .split("\\s+");

        List<FileScore> scoredFiles = new ArrayList<>();

        for (String file : projectFiles) {

            String lower = file.toLowerCase();

            int score = 0;

            for (String keyword : keywords) {

                if (keyword.length() < 3) {
                    continue;
                }

                if (lower.contains(keyword)) {
                    score++;
                }
            }

            if (score > 0) {
                scoredFiles.add(new FileScore(file, score));
            }
        }

        scoredFiles.sort(
                Comparator.comparingInt(FileScore::score)
                        .reversed()
        );

        List<String> result = new ArrayList<>();

        for (FileScore file : scoredFiles) {

            result.add(file.path());

            if (result.size() >= 15) {
                break;
            }
        }

        if (result.isEmpty()) {

            int limit = Math.min(10, projectFiles.size());

            result.addAll(
                    projectFiles.subList(0, limit)
            );
        }

        return result;
    }

    private record FileScore(
            String path,
            int score
    ) {
    }

}