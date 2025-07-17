package com.example.zadanie_rekrutacyjne;

import com.example.zadanie_rekrutacyjne.dto.BranchDto;
import com.example.zadanie_rekrutacyjne.dto.RepositoryDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ZadanieRekrutacyjneApplicationTests {

    @LocalServerPort
    private int port;

    private final RestTemplate restTemplate = new RestTemplate();

    @Test
    void test() {
        String username = "microsoft";
        String url = "http://localhost:" + port + "/api/github/" + username;

        ResponseEntity<RepositoryDto[]> response = restTemplate.getForEntity(url, RepositoryDto[].class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        RepositoryDto[] repos = response.getBody();

        assertThat(repos).isNotNull();
        assertThat(repos.length).isGreaterThan(0);

        for (RepositoryDto repo : repos) {
            assertThat(repo.getName()).isNotBlank();
            assertThat(repo.getOwnerLogin()).isEqualToIgnoringCase(username);
            List<BranchDto> branches = repo.getBranches();
            assertThat(branches).isNotNull();
            assertThat(branches.size()).isGreaterThan(0);
            for (BranchDto branch : branches) {
                assertThat(branch.getName()).isNotBlank();
                assertThat(branch.getLastCommitSha()).isNotBlank();
            }
        }
    }
}
