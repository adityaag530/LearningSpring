package com.example.restservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @author adityagupta
 * @date 09/07/23
 */
@RestController
public class RestApi {
    // injecting custom properties from application.properties using @Value annotation
    @Value("${student.name}")
    public String studentName;
    @Value("${student.marks}")
    public String studentMarks;

    // author endpoint
    @GetMapping("/author")
    public String author(){
        return "User: "+ studentName + "\nMarks: "+ studentMarks;
    }

    @GetMapping("/")
    public String sayHello(){
        return "Hello Spring!";
    }

    @GetMapping("/page")
    public String printContact(){
        return "will be updated soon!..";
    }

}
