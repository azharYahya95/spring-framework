<h2>Spring IOC XML configuration</h2>

1) Spring will give appropriate object/implementation based on configuration file/annonation
<br><br>
2) <b>What  is primary function of Spring Container </b><br>
    a) Create and manage object (Inversion of Controls) <br>
    b) Inject Object Dependencies (Dependency Injection)<br><br>
3) <b>Approach to configure Spring Container</b><br>
    - XML configuration file (legacy)
    - Java Annontations (modern)
    - Java Source Code (modern)<br><br>
4) <b>Step by Step to create Beans from Spring Container </b>
    - Configure Spring Beans
      - <i>can check in applicationContext.xml</i>
    - Create Spring Container
      - known as ApplicationContext
      - got specialize implementations
        - ClassPathXMLApplicationContext
        - AnnotationConfigApplicationContext
        - GenericWebApplicationContext
        - others ...
    - Retrieve Beans from Spring Container<br><br>
5) Spring beans is Java Object that created by Spring Container
  
