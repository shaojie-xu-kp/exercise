package com.example.demo.service;

import com.example.demo.client.MockyClient;
import com.example.demo.dto.Company;
import com.example.demo.dto.Representative;
import com.example.demo.dto.Visit;
import com.example.demo.util.Haversine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;

@Service
public class VisitService {

    @Autowired
    private MockyClient mockyClient;

    @Value("${max.visit.distance}")
    private double maxDistance;

    public Collection<Visit> generateVisits() {
        Company[] companies = mockyClient.getCompanies();
        Representative[] representatives = mockyClient.getRepresentatives();
        return assignRepresentativeToCompany(representatives, companies);
    }

    private Collection<Visit> assignRepresentativeToCompany(Representative[] representatives, Company[] companies) {

        Map<Representative, Visit> representativeVisitMap = new HashMap<>();
        Map<Company, Visit> companyVisitMap = new HashMap<>();

        LinkedList<Company> companyQueue = new LinkedList<>(Arrays.asList(companies));

        while (!companyQueue.isEmpty()) {
            Company companyToAssign = companyQueue.pop();
            for (int i = 0; i < representatives.length; i++) {
                Representative representative = representatives[i];
                double distance = Haversine.distance(companyToAssign, representative);
                Visit visit = representativeVisitMap.get(representative);

                if (Objects.nonNull(visit)) {
                    if (visit.getDistance() > distance) {
                        companyQueue.push(visit.getCompany());
                        representativeVisitMap.put(representative, new Visit(representative, companyToAssign));
                    }
                } else {
                    if (distance < maxDistance) {
                        representativeVisitMap.put(representative, new Visit(representative, companyToAssign));
                    }
                }
            }
        }

        for (Visit visit : representativeVisitMap.values()) {
            Company company = visit.getCompany();
            Representative representative = visit.getRepresentative();
            if (Objects.nonNull(companyVisitMap.get(company))) {
                Visit existingVisit = companyVisitMap.get(company);
                if (existingVisit.getDistance() > visit.getDistance()) {
                    companyVisitMap.put(company, new Visit(representative, company));
                }
            } else {
                companyVisitMap.put(company, visit);
            }
        }

        return companyVisitMap.values();
    }

}
