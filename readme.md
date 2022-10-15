## Spring Configuration with Annotation - Inversion of control

1. ### What are java annotations
   1. Special labels added to java classes
   2. provide meta-data about class
   3. Process at compile-time/run-time for special processing


2. ### Why using Spring Configuration with annotations
   1. XML configurations can be verbose
   2. Annotations minimize the XML configuration


3. ### How beans is register to Spring Container using Java annotations?
   1. Spring will scan your Java class first for special annotations
   2. Then its automatically register beans in the Spring Container

4. ### Development Process to create beans using Java Annotations
   1. Enable component scanning in Spring config file.
   ```
   <beans ..>
        <context:component-scan base-package="com.luv2code.springdemo" />
   </beans>
   ```
   2. Add @Component Annotation to your Java classes
   ```
   @Component("thatSillyCoach")
   public class TennisCoach implements Coach{
        @Override
        public String getDailyWorkout() {
            return "Practice your backhand volley";
        }
   }
   ```
   3. Retrieve bean from Spring Container
   ```
   Coach theCoach = context.getBean("thatSillyCoach", Coach.class);
   ```

5. ### Default Component names
   - Default bean Id: the class name, make first letter lower case
   ``TennisCoach`` -> ``tennisCoach``