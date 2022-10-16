package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("thatSillyCoach")
//@Scope("prototype")
public class TennisCoach implements Coach{

    private FortuneService fortuneService;
    public TennisCoach() {
        System.out.println(">TennisCoach: inside default constructor");
    }

    //define init method
    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println(">> TennisCoach: inside of doMyStartupStuff()");
    }

    //define my destroy method
    @PreDestroy
    public void doMyCleanupStuff(){
        System.out.println(">> TennisCoach: inside of doMyCleanupStuff()");
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
