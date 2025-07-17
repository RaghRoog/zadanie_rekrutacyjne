package com.example.zadanie_rekrutacyjne.dto;

import java.util.List;

public class RepositoryDto {

    private String name;
    private String ownerLogin;
    private List<BranchDto> branches;

    public RepositoryDto(String name, String ownerLogin, List<BranchDto> branches) {
        this.name = name;
        this.ownerLogin = ownerLogin;
        this.branches = branches;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerLogin() {
        return ownerLogin;
    }

    public void setOwnerLogin(String ownerLogin) {
        this.ownerLogin = ownerLogin;
    }

    public List<BranchDto> getBranches() {
        return branches;
    }

    public void setBranches(List<BranchDto> branches) {
        this.branches = branches;
    }
}
