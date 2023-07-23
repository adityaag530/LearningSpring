package com.learning.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/*
 * @author adityagupta
 * @date 10/07/23
 */
// @Component - marks a class as spring bean - makes it available for dependency injection
//@Lazy makes the bean intialization only when needed. ideally spring intializes all beans at the start to make it available.

@Component
@Lazy
public class TennisCoach implements Coach{
    public TennisCoach() {
        System.out.println("Inside Constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Try practicing with both hands!.";
    }
}
