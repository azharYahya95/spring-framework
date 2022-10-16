package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {
    public static void main(String[] args) {
        //load Spring config file
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(SportConfig.class);
        //retrieve bean from  Spring COntainer
        SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);

        //print out the resuults
        System.out.println(theCoach.getDailyWorkout());


        //run the injected properties
        System.out.println("email: "+theCoach.getEmail());

        System.out.println("team: "+theCoach.getTeam());

        //close the context
        context.close();
    }
}
