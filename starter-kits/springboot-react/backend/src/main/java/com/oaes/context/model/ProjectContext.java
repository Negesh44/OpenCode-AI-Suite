package com.oaes.context.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectContext {

    private String projectName;

    private String packageName;

    private List<String> controllers;

    private List<String> services;

    private List<String> repositories;

    private List<String> entities;

    private List<String> dtos;

    private List<String> configs;

    private List<String> files;
}