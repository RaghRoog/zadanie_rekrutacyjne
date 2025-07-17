package com.example.zadanie_rekrutacyjne.controller;

import com.example.zadanie_rekrutacyjne.dto.RepositoryDto;
import com.example.zadanie_rekrutacyjne.service.GithubService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/github")
public class GithubController {

    private final GithubService githubService;

    public GithubController(GithubService githubService) {
        this.githubService = githubService;
    }

    @GetMapping("/{username}")
    public List<RepositoryDto> getRepos(@PathVariable String username) {
        return githubService.fetchRepos(username);
    }
}
