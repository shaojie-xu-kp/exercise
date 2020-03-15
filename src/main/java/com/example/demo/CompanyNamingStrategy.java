package com.example.demo;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;

public class CompanyNamingStrategy extends PropertyNamingStrategy {

    @Override
    public String nameForField(MapperConfig config, AnnotatedField field, String defaultName) {
        return defaultName.toUpperCase();
    }

    @Override
    public String nameForGetterMethod(MapperConfig config, AnnotatedMethod method, String defaultName) {
        return defaultName;
    }

    @Override
    public String nameForSetterMethod(MapperConfig config, AnnotatedMethod method, String defaultName) {
        return defaultName.toUpperCase();
    }
}
