package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemo {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

        Coach theCoach = context.getBean("myCoach", Coach.class);

        Coach alphaCoach = context.getBean("myCoach", Coach.class);

        //check if the bean same
        boolean result = (theCoach == alphaCoach);

        System.out.println("Pointing to the same object? : "+result);

        System.out.println("Memory location for theCoach: "+theCoach);

        System.out.println("Memory location for alphaCoach: "+alphaCoach);

        context.close();
    }
}
