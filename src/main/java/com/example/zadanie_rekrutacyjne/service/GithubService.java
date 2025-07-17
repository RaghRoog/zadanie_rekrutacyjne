package com.example.zadanie_rekrutacyjne.service;

import com.example.zadanie_rekrutacyjne.response.BranchResponse;
import com.example.zadanie_rekrutacyjne.response.RepoResponse;
import com.example.zadanie_rekrutacyjne.dto.BranchDto;
import com.example.zadanie_rekrutacyjne.dto.RepositoryDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

@Service
public class GithubService {

    private final RestClient restClient;

    public GithubService(RestClient restClient) {
        this.restClient = restClient;
    }

    public List<RepositoryDto> fetchRepos(String username) {
        try {
            RepoResponse[] repos = restClient.get()
                    .uri("/users/{username}/repos", username)
                    .retrieve()
                    .body(RepoResponse[].class);

            return Arrays.stream(repos)
                    .filter(repo -> !repo.isFork())
                    .map(repo -> new RepositoryDto(
                            repo.getName(),
                            repo.getOwner().getLogin(),
                            fetchBranches(repo.getOwner().getLogin(), repo.getName())))
                    .toList();
        } catch (RestClientResponseException exception) {
            if (exception.getStatusCode() == HttpStatus.NOT_FOUND) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
            }
            throw exception;
        }
    }

    private List<BranchDto> fetchBranches(String owner, String repoName) {
        BranchResponse[] branches = restClient.get()
                .uri("/repos/{owner}/{repo}/branches", owner, repoName)
                .retrieve()
                .body(BranchResponse[].class);

        return Arrays.stream(branches)
                .map(b -> new BranchDto(b.getName(), b.getCommit().getSha()))
                .toList();
    }
}
