## Spring MVC

1. ### Spring MVC Overview
   - **What is Spring MVC?**
      - Framework for building web application in Java
      - Based on Model-View-Controller design pattern
   - **Benefits of Spring MVC**
      - Spring way of building web app UI in Java
      - leverage a set of reusable UI components
      - Help manage application state for web request
      - Process form data: validation, conversion etc
      - Flexible configuration for the view layer
   - **Documentation**
      - [Click here](https://docs.spring.io/spring-framework/docs/current/reference/html/web.html)

2. ### Spring MVC - Behind the Scenes
   - **Components of Spring MVC Application**
      - _Web Pages_ - a set of web pages to layout UI components
      - _Beans_ - A collection of Spring Beans (Controllers, services, etc)
      - _Spring Configurations_ - XML / Annotations / java
    ```mermaid
    graph TD;
        Web_Browser-->Front_Controller;
        Front_Controller-->|model|Controller;
        Controller-->|model|View_Template;
        View_Template-->Web_Browser;
    ```
   - **Spring MVC FrontController**
      - also known as DispatcherServlet
      - part of Spring Framework
      - already develop by Spring Dev Team
      - use to delegate the request to some other objects or items (model)
   - **Controller**
      - Contains your business logic
      - send to appropriate view template
   - **Model**
      - contains your data
      - store/retrieve data via backend system
   - **View Template**
      - Spring MVC is flexible
         - can support many templates
      - most common jsp+jstl
      - other template
         - Thymeleaf, Groovy
         - Velocity, Freemaker
3. ### Spring Configuration
   1. **Add Configuration to file:WEB-INF/web.xml**
      - Configure Spring MVC Dispatcher Servlet
      ```xml
      <web-app>
        <servlet>
            <servlet-name>dispatcher</servlet-name>
            <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
      
            <init-param>
                <param-name>contextConfigLocation</param-name>
                <param-value>/WEB-INF/spring-mvc-demo-servlet.xml</param-value>
            </init-param>
      
            <load-on-startup>1</load-on-startup>
        </servlet>
      </web-app>
      ```
      - Set up URL mapping to Dispatcher servlet
      ```xml
        <servlet-mapping>
            <servlet-name>dispatcher</servlet-name>
            <url-pattern>/</url-pattern>
       </servlet-mapping>
      ```
   2. **Add configurations to file: WEB-INF/spring-mvc-demo-servlet.xml**
      - Add support for Spring component scanning
      ```xml
        <beans>
            <context:component-scan base-package="com.luv2code.springdemo" />
        </beans>
      ```
      - Add support for conversion, formatting and validation
      ```xml
        <mvc:annotation-driven/>
      ```
      - Configure Spring MVC View Resolver
      ```xml
        <bean
            class="org.springframework.web.servlet.view.InternalResourceViewResolver">
            <property name="prefix" value="/WEB-INF/view/" />
            <property name="suffix" value=""/>
            
        </bean>
      ```