package com.example;

import java.util.HashSet;
import java.util.Set;

import Helpers.CORSFilter;
import jakarta.ws.rs.ApplicationPath;

@ApplicationPath("/api")
public class Application extends jakarta.ws.rs.core.Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();
        resources.add(CORSFilter.class);
        resources.add(controllers.CarController.class);
        return resources;
    }

}
