package com.example.demo.client;

import com.example.demo.client.MockyClient;
import com.example.demo.dto.Company;
import com.example.demo.dto.Representative;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Objects;

import static org.junit.Assert.*;

@SpringBootTest
public class MockyClientTest {

    @Autowired
    private MockyClient mockyClient;

    @Test
    public void testCompanies() {
        Company company1 = Arrays.stream(mockyClient.getCompanies())
                .filter(c -> Objects.nonNull(c.getContact()))
                .filter(c -> c.getContact().getEmail().equals("JayneADaniel@jourrapide.com"))
                .findFirst().get();
        assertEquals(company1.getName(),"ALBERTSONS COS.");
        assertEquals(company1.getAddress(), "250 PARKCENTER BOULEVARD");
        assertEquals(company1.getLatitude(), 43.59974, 0);
        assertEquals(company1.getLongitude(), -116.18099, 0);
        assertEquals(company1.getContact().getName(), "Daniel Jayne");
        assertEquals(company1.getContact().getPhone(), "(07) 4961 5112");
    }

    @Test
    public void testRepresentatives() {
        Representative representative1 = Arrays.stream(mockyClient.getRepresentatives())
                .filter(representative -> representative.getName().equals("Rep 1"))
                .findFirst().get();
        assertEquals(representative1.getEmail(),"rep1@salesforce.com");
        assertEquals(representative1.getPhone(),"00000001");
        assertEquals(representative1.getLocation(), "43.488597, -116.530103");
        assertEquals(representative1.getLatitude(), 43.488597, 0);
        assertEquals(representative1.getLongitude(), -116.530103, 0);
    }
}
