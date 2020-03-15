package com.example.demo.client;

import com.example.demo.dto.Company;
import com.example.demo.dto.Representative;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MockyClient {

    @Value("${company.url}")
    private String companyUrl;

    @Value("${representative.url}")
    private String representativeUrl;


    public Company[] getCompanies(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Company[]> response= restTemplate.getForEntity(companyUrl, Company[].class);
        return response.getBody();
    }

    public Representative[] getRepresentatives() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Representative[]> response= restTemplate.getForEntity(representativeUrl, Representative[].class);
        return response.getBody();
    }
}
