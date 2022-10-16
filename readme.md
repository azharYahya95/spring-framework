## Spring Config with Java COde (no XML)

1. ### 3 Ways of Configuring Spring Container
   1. Full XML config
   2. XML ComponentScan
   3. Java Configuration class


2. ### Development Process for Spring Configuration with Java Code
    1. Create a Java class and annotate as @Configuration
   ````
   @Configuration
   public class SportConfig{
   ....
   }
   ````
    2. Add component Scanning Support: @ComponentScan (optional)
   ````
   @Configuration
   @ComponentScan("com.luv2code.springdemo")
   public class SportConfig{
   ....
   }
   ````
    3. Read Spring Java configuration class
   ````
   AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(SportConfig.class);
   ````
    4. Retrieve bean from Spring container 
   ````
   Coach theCoach = context.getBean("tennisCoach", Coach.class);
   ````
   
3. ### Development process to inject bean using Java Code
    1. Define method to expose bean
        - using @Bean annotation
        - No Component Scan
        - Define each bean individually in this config class
   ````
   @Configuration
   public class SportConfig {
        @Bean
        public Coach swimCoach() {
            SwimCoach mySwimCoach = new SwimCoach();
            return mySwimCoach;
        }
   }
   ````
    2. Inject bean dependencies
        - create another method that become bean
        - inject to another bean by put the method name/bean name as argument
    ````
    @Configuration
    public class SportConfig{
        @Bean 
        public FortuneService happyFortuneService(){
            return new HappyFortuneService();
        }
        
        @Bean
        public Coach swimCoach(){
            SwimCoach swimCoach = new SwimCoach(happyFortuneService());
            return mySwimCoach;
        }
    }
    ````
    3. Read Spring Java configuration class
    ````
        AnnotationConfigApplicationContext context = 
                new AnnotationConfigApplicationContext(SportConfig.class);
    ````
    4. Retrieve bean from Spring Container 
    ````
        Coach theCoach = context.getBean("swimCoach", Coach.class);
    ````
   
4. ### What is Real time use case for @Bean?
    - can use to make existing third party class available to your Spring framework

5. ### List of component Scanning.
    - @Component
    - @Controller
    - @Service
    - @Repository

6. ### Development process to Inject values from Properties file.
    1. Create properties file
        - example: _sport.properties_
       ````
       foo.eamil=azhar.yahya@yahoo.com
       foo.team=Awesome Java Coders
       ````
    2. Load Properties file in Spring config
        ````
       @Configuration
       @PropertySource("classpath:sport.properties")
       public class SportConfig{
        ...
       }
        ````
    3. Reference values from Properties file 
        - example: _SwimCoach.file_
       ````
       public class SwimCoach implements Coach{
            @Value("${foo.email}")
            private String email;
       
            @Value("$foo.team")
            private String team;
       
            ...
       }
       ````
7. **Problem with Injecting values for Spring 4.2 and lower**
   - need to add this code in config java class
   ````
    // add support to resolve ${...} properties
    @Bean
    public static PropertySourcesPlaceholderConfigurer
                    propertySourcesPlaceHolderConfigurer() {
        
        return new PropertySourcesPlaceholderConfigurer();
    }
   ````