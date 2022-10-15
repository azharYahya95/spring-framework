package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

    public static void main(String[] args) {
        //read spring config file
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("applicationContext.xml");
        //get the bean from Spring COntainer
        Coach theCoach = context.getBean("thatSillyCoach", Coach.class);
        Coach baseballCoach = context.getBean("baseballCoach", Coach.class);

        //call a method on a bean
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(baseballCoach.getDailyWorkout());

        //close the context
        context.close();
    }
}
