package com.example.demo.controller;


import com.example.demo.dto.Visit;
import com.example.demo.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/visits")
public class VisitController {

    @Autowired
    private VisitService visitService;

    @GetMapping
    public Collection<Visit> getVisits(){
        return visitService.generateVisits();
    }

}
