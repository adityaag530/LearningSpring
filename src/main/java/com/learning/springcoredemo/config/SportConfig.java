package com.learning.springcoredemo.config;
/*
 * @author adityagupta
 * @date 22/07/23
 */

import com.learning.springcoredemo.common.Coach;
import com.learning.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    // below is custom bean id
    @Bean("watery")
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
