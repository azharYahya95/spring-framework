package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

    public static void main(String[] args) {
        //read spring config file
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("applicationContext.xml");
        //get the bean from Spring COntainer
        Coach baseballCoach = context.getBean("baseballCoach", Coach.class);

        Coach tennisCoach = context.getBean("thatSillyCoach", Coach.class);

        //call a method on a bean
        System.out.println(baseballCoach.getDailyFortune());

        System.out.println(tennisCoach.getDailyWorkout());

        //close the context
        context.close();
    }
}
