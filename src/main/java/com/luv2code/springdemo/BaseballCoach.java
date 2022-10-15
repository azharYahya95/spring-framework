package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Do the reverse crunch before start playing";
    }
}
