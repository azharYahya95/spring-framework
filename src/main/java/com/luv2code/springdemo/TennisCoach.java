package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("thatSillyCoach")
public class TennisCoach implements Coach{

    private FortuneService fortuneService;
    public TennisCoach() {
        System.out.println(">TennisCoach: inside default constructor");
    }

    @Autowired
    @Qualifier("happyFortuneService")
    public void setFortuneService(FortuneService fortuneService){
        System.out.println(">TennisCoach: inside setFortuneService method");
        fortuneService = this.fortuneService;
    }

    @Autowired
    @Qualifier("happyFortuneService")
    public void doSomeCrazyStuff(FortuneService fortuneService){
        System.out.println(">TennisCoach: inside doSomeCrazyStuff method");
        fortuneService = this.fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice Your Backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return null;
    }
}
