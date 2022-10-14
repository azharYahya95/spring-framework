package org.example;

public class BaseballCoach implements Coach{

    //step 2 create constructor
    private FortuneService fortuneService;

    public BaseballCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout(){
        return "Spend 30 minutes of batting practices";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    public void doMyStartupStuff(){
        System.out.println("Baseball Coach: do my startup stuff");
    }

    public void doMyCleanupStuff(){
        System.out.println("Baseball Coach: do my cleanup stuff");
    }
}
