package com.example.zadanie_rekrutacyjne.response;

import com.example.zadanie_rekrutacyjne.response.OwnerResponse;

public class RepoResponse {

    private String name;
    private OwnerResponse owner;
    private boolean fork;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OwnerResponse getOwner() {
        return owner;
    }

    public void setOwner(OwnerResponse owner) {
        this.owner = owner;
    }

    public boolean isFork() {
        return fork;
    }

    public void setFork(boolean fork) {
        this.fork = fork;
    }
}
