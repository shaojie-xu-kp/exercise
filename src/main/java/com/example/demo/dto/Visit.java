package com.example.demo.dto;

import com.example.demo.util.Haversine;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class Visit {

    private Representative representative;
    private Company company;

    @JsonIgnore
    private double distance;

    public Visit(Representative representative, Company company) {
        this.representative = representative;
        this.company = company;
        this.distance = Haversine.distance(company, representative);
    }
}
