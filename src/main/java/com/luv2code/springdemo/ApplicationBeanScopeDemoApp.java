package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationBeanScopeDemoApp {
    public static void main(String[] args) {
        //load Spring config file
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("applicationContext.xml");
        //retrieve bean from  Spring COntainer
        Coach theCoach = context.getBean("thatSillyCoach", Coach.class);
        Coach alphaCoach = context.getBean("thatSillyCoach", Coach.class);

        //check if they are same
        boolean result = (theCoach == alphaCoach);

        //print out the resuults
        System.out.println("Pointing to the same object: "+ result);

        System.out.println("Memory Location for theCoach: "+ theCoach);

        System.out.println("Memory Location for alphaCoach: "+ alphaCoach);

        //close the context
        context.close();
    }
}
