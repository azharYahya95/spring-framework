## Spring Dependency Injection with Annotation and Autowiring

1. ### What is Autowiring
- It is use by Spring for Autowiring
- Spring will look for a class that matches the property
  - eg: matches by type: class or interface
- Spring will inject it automatically

2. ### AutoWiring Example
- Injecting _FortuneService_ into _Coach_ implementation
- Spring will scan @Components
- Any on implements FortuneService interface?
- If yes, lets inject them, example: _HappyFortuneService_

3. ### Autowiring Injecting Type
   a. Constructor Injection<br>
   b. Setter Injection<br>
   c. Field Injection<br>
   d. Method Injection


4. ### Development Process for Constructor Injection
   1. Define Dependency Interface and class
   2. Create constructor in your class for Injection
   3. Configure Dependency Injection with @Autowired annotation
   ```
   @Component
   public class TennisCoach implements Coach {
      private FortuneService fortuneService;
      
      @Autowired
      public TennisCoach(FortuneService theFortuneService){
         fortuneService = theFortuneService;
      }
   }
   ```
5. ### What if there are multiple Implementations?
   - Spring has special support to handle this by using @Qualifier

6. ### Autowired optional to use in Spring Framework 4.3
   - no longer necessary if target bean only defines 1 constructor to begin with
   - but if several constructor available, at least 1 must be annotated to teach container which one to use
   - but use of @Autowired can make the code more readable

7. ### Depevelopment process for Setter Injection
   - Create setter method in your class for Injection
   - Connfigure dependency Injection with @Autowired annotation
   ```
   @Component
   public class TennisCoach implements Coach {
      private FortuneService fortuneService;
   
      public TennisCoach(){
      }
   
      @Autowired
      public void setFortuneService(FortuneService fortuneService){
         this.fortuneService = fortuneService
      }
   
      ...
   }
   ```
   
8. We can inject dependencies by calling any method on your class
```
   @Component
   public class TennisCoach implements Coach{
      private FortuneServie fortuneService;
      
      public TennisCoach(){
      
      }
      
      @Autowired
      public void doSomeCrazyStuff(FortuneService fortuneService){
         this.fortuneService = fortuneService;
      }
      ...
   }
```

9. What is Field Injection?
- Inject dependency by setting field values on your class directly
- Accomplish by using Java Reflection

10.  Development Process Field Injection
- Configure dependency Injection with Autowired Annotation
  - Applied directly to the field
  - no need for setter method
  ```
   public class TennisCoach implements Coach{
       
       @Autowired
       private FortuneService fortuneService;
       
      public TennisCoach(){
      }
      //no need for setter method
   }
  ```
  
11. ### Qualifiers for Dependency Injection.
    - we need to use it if we had multiple implementation
    - we need to specify the bean name when use it
    ```
    @Component
    public class TennisCoach implements Coach {
      
      @Autowired
      @Qualifier("happyFortuneService")
      private FortuneService fortuneService;
      ....
    }
    ```
    - When can apply @Qualifier annotation
      - Constructor Injection
      - Setter injections method
      - Field Injection

12. **Default name for both first and second character are uppercase**
      - if both first and second character of class are uppercase, name is not converted <br>
      - spring use [Java Beans Introspector](https://docs.oracle.com/javase/8/docs/api/java/beans/Introspector.html#decapitalize(java.lang.String)) to generate default bean name
      - as always, you can specify the name of your bean
      ```
      @Component("foo")
      public class RESTFortuneService .... {
      
      }
      ```

13. **Using @Qualifier with Constructor**
    ```
    ...
    @Autowired
    public TennisCoach(@Qualifier("randomFortuneService") FortuneService theFortuneService){
      System.out.println(">> TennisCoach: inside constructor using @autowired and @qualifier");
      fortuneService = theFortuneService;
    }
    ```
14. **Using @Qualifier with Setter Injection**
   - can use in method arguments line
   ```
    @Autowired
	public void setFortuneService(@Qualifier("randomFortuneService") FortuneService theFortuneService) {
		System.out.println(">> TennisCoach: inside setFortuneService() method");
		this.fortuneService = theFortuneService;
	}
   ```
   - can use above method name
   ```
    @Autowired
	@Qualifier("randomFortuneService")
	public void setFortuneService(FortuneService theFortuneService) {
		System.out.println(">> TennisCoach: inside setFortuneService() method");
		this.fortuneService = theFortuneService;
	}
   ```

15. How to Inject properties file using Java annotations
    1. Step 1: Create properties file to hold your properties
       <br>text file: _src/sport.properties_      
             ```
             foo.email=myeasycoach@luv2code.com
             foo.team=Silly Java Coders
             ```
    2. Step 2: Load properties file in XML config file<br>
      file: _applicarionContext.xml_
      ```
         <context:property-holder location="classpath:sport.properties"/>
      ```
    3. Inject the properties value
      ````
      @Value("${foo.email}")
      private String email;
    
      @Value("${foo.team}")
      private String team;
      ````