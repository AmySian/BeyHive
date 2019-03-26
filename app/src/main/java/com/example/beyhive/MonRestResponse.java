package com.example.beyhive;

import java.util.List;

public class MonRestResponse {
    private List<MonApi> beyhive;

    public List<MonApi> getResults() {
        return beyhive;
    }

    public void setResults(List<MonApi> results) {
        this.beyhive = beyhive;
    }
}
