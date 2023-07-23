package com.learning.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/*
 * @author adityagupta
 * @date 10/07/23
 */
// @Component - marks a class as spring bean - makes it available for dependency injection

@Component
@Primary
public class CricketCoach implements Coach{
    public CricketCoach() {
        System.out.println("Inside Constructor: " + getClass().getSimpleName());
    }

    // defining init method
    @PostConstruct
    public void doMyStartUpTask(){
        System.out.println("Inside doMyStartUpTask: " + getClass().getSimpleName());
    }

    //defining destroy method
    @PreDestroy
    public void doMyCleanUpTask(){
        System.out.println("Inside doMyCleanUpTask: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes!.";
    }
}
