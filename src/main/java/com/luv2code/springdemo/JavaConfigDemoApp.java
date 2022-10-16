package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigDemoApp {
    public static void main(String[] args) {
        //load Spring config file
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(SportConfig.class);
        //retrieve bean from  Spring COntainer
        Coach theCoach = context.getBean("thatSillyCoach", Coach.class);
        Coach alphaCoach = context.getBean("thatSillyCoach", Coach.class);

        //check if they are same
        boolean result = (theCoach == alphaCoach);

        //print out the resuults
        System.out.println("Pointing to the same object: "+ result);

        //close the context
        context.close();
    }
}
//need to modify on SportConfig class to run this