package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

    public static void main(String[] args) {
        //step 1: create application COntext
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("applicationContext.xml");

        //step 2: retrieve bean from container
            //by calling this, it will generate constructor and setter method in background
        CricketCoach coach = context.getBean("CricketCoach", CricketCoach.class);

        //step 3: call methods on bean
        System.out.println(coach.getDailyFortune());
        System.out.println(coach.getDailyWorkout());

        //call new method to get literal values
        System.out.println(coach.getEmailAddress());
        System.out.println(coach.getTeam());

        //step 4: close context
        context.close();
    }
}
