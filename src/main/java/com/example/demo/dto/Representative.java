package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Optional;

@Data
@EqualsAndHashCode
public class Representative {

    private String location;
    private String name;
    private String email;
    private String phone;

    @JsonSetter
    public void setLocation(String location) {
        this.location = location;
    }

    @JsonIgnore
    public String getLocation() {
        return location;
    }

    @JsonIgnore
    public double getLatitude() {
        return Double.valueOf(Optional.of(getLocation()).orElse("").split(",")[0]);
    }

    @JsonIgnore
    public double getLongitude() {
        return Double.valueOf(Optional.of(getLocation()).orElse("").split(",")[1]);
    }

}
