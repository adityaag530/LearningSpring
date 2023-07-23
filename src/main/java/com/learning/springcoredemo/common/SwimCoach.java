package com.learning.springcoredemo.common;
/*
 * @author adityagupta
 * @date 22/07/23
 */

// not using component as we are considering this class as third party
public class SwimCoach implements Coach{

    public SwimCoach(){
        System.out.println("In Constructor: " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Practice Swimming Daily for 1HOUR!..";
    }
}
