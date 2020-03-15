package com.example.demo.dto;

import com.example.demo.CompanyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode
@JsonNaming(CompanyNamingStrategy.class)
public class Contact {

    private String name;
    private String email;
    private String phone;

}
