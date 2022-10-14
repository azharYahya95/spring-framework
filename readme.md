## Spring Dependency Injection XML configuration

1) **What is Dependency Injection?**
   1. Outsource construction and Injection of your object to external entity
   2. We inject Object that ready to use to our class/object
   3. Spring Container will get/prepare object that ready to use for you<br><br>
2) **Type of Injection**
   1. There are many types of Injection, but in this project will cover 2 types of it
      1. Constructor Injection
      2. Setter Injection
3. **Process to do the Dependency Injection**
   1. Define dependency Interface and class
   2. Create Constructor in you class for Injection
   3. Configure Dependency Injection in Spring config file
        1. using (<constructor-arg ref="id_class_to_inject"/>)
4. **What happened behind the scene of Dependency Injection**
   1. When create bean in conf file, behind the scene, Spring will create constructor for you
      1. In conf file 
         ```< bean id="myFortuneService"
          class="org.example.HappyFortuneService"></bean>
         ```
         Behind the Scene 
         ```
            HappyFortuneService myFortuneService = new HappyFortuneService();
         ```
        
        2. In conf file 
           ```
           < bean id="myCoach"class="org.example.BaseballCoach">
                  < constructor-arg ref="id_class_to_inject" /> 
           </ bean>
           ```
           Behind the Scene
            ```
            BaseballCoach myCoach = new BaseballCoac(myFortuneService);
            ```
5. **Step By Step to do the Setter Injection**
   1. Create Setter method in your class for Injections.
        ```
      public class CricketCoach{
            private FortuneService fortuneService;
            
            public void setFortuneService(){
                this.fortuneService = fortuneService;
            }
      }
      ```
   2. Configure the Dependency Injection in Spring Config file.
      ```
       < bean id="myFortuneService" 
                class="HappyFortuneService">< /bean>

      < bean id="myCricketCoach" class="CricketCoach">
          < property name="fortuneService" ref="myFortuneService"/>
      < /bean>
      ```
6. **Behind The Scene of Setter Injection**
- in Config file
    ```
  < property name="fortuneService" ref="myFortuneService"/>
    ```
- behind the scene
   ```
   CricketCoach myCoach = new CricketCoach()
   myCoach.setFortuneService(service)
   ```

7. **Injecting literal values**
```
< property name="team" value="Perak FC"/ >
```

8. **Step by Step Injecting values from Properties file**
   1. Create Properties file
      <p>name file: </p><i>sport.properties</i>
       <pre><code>foo.team=FSM</code></pre>
   2. Load Properties file in Spring config file
      ```
        < context:property-placeholder location:"classpath:sport.properties"/ >
      ```
   3. Reference values from Properties file
      ```
        < property name="team" value="${foo.email}" / >
      ```
  
