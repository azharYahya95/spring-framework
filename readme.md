## Spring Configuration with annotations - Bean Scopes and lifecycle

1. ### How to set Scope annotation
    ````
    @Compoent
    @Scope("singleton")
    public class TennisCoach implements Coach {
        ....
    }
    ````
2. ### Development process for Bean lifecycle Method Annotations
   1. Define your methods for init and destroy.
   2. Add annotations: @PostConstruct and @PreDestroy
    ````
    @Component
    public class TennisCoach implements Coach{
        
        @PostConstruct
        public void doMyStartupStuff(){
        ....
        }
    }
    ````
   ````
    @Component
    public class TennisCoach implements Coach{
        
        @PreDestroy
        public void doMyCleanupStuff(){
        ....
        }
    }
   ````
   
3. **Note about @PreDestroy method**
- For "Prototype" scope beans, Spring does not call @PreDestroy methop