package com.example.demo.service;


import com.example.demo.client.MockyClient;
import com.example.demo.dto.Company;
import com.example.demo.dto.Visit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToObject;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@SpringBootTest
public class VisitServiceTest {

    @Autowired
    private VisitService visitService;

    @Autowired
    private MockyClient mockyClient;

    @Value("${max.visit.distance}")
    private double maxDistance;

    @Test
    public void testAllCompaniesHasVisit() {
        Company[] companies = mockyClient.getCompanies();
        Collection<Visit> visits = visitService.generateVisits();
        assertEquals(companies.length, visits.size());
    }

    @Test
    public void testAllVisitsAreWithInMaxDistance() {
        Collection<Visit> visits = visitService.generateVisits();
        visits.stream().forEach(visit -> assertEquals(visit.getDistance() <= maxDistance, true));
    }

    @Test
    public void testNoDuplicateVisit() {
        Collection<Visit> visits = visitService.generateVisits();
        Set<Visit> noDuplicateVisits = new HashSet<>(visits);
        assertThat(visits.size(), equalTo(noDuplicateVisits.size()));
    }
}
