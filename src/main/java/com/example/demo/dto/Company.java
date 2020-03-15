package com.example.demo.dto;


import com.example.demo.CompanyNamingStrategy;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(CompanyNamingStrategy.class)
public class Company {

    private String name;
    private String address;
    private double latitude;
    private double longitude;
    private Contact contact;

    @JsonIgnore
    public double getLatitude() {
        return latitude;
    }

    @JsonSetter
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @JsonIgnore
    public double getLongitude() {
        return longitude;
    }

    @JsonSetter
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

}

